package com.intentïon.web;

import software.amazon.awscdk.CfnOutput;
import software.amazon.awscdk.RemovalPolicy;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.cloudtrail.S3EventSelector;
import software.amazon.awscdk.services.cloudtrail.Trail;
import software.amazon.awscdk.services.iam.ArnPrincipal;
import software.amazon.awscdk.services.iam.Effect;
import software.amazon.awscdk.services.iam.PolicyDocument;
import software.amazon.awscdk.services.iam.PolicyStatement;
import software.amazon.awscdk.services.iam.Role;
import software.amazon.awscdk.services.logs.LogGroup;
import software.amazon.awscdk.services.logs.RetentionDays;
import software.amazon.awscdk.services.s3.Bucket;
import software.amazon.awscdk.services.s3.IBucket;
import software.constructs.Construct;

import java.util.Arrays;
import java.util.List;

public class WebStack extends Stack {

    public IBucket eventsBucket;
    public LogGroup eventsBucketLogGroup;
    public Trail eventsBucketTrail;
    public Role s3AccessRole;

    public static class Builder {
        public Construct scope;
        public String id;
        public StackProps props;
        public String s3WriterArnPrinciple;
        public String s3WriterRoleName;
        public String s3BucketName;
        public String s3ObjectPrefix;
        public boolean s3UseExistingBucket;
        public boolean s3RetainBucket;

        public Builder(Construct scope, String id, StackProps props) {
            this.scope = scope;
            this.id = id;
            this.props = props;
        }

        public static Builder create(Construct scope, String id) {
            Builder builder = new Builder(scope, id, null);
            return builder;
        }

        public static Builder create(Construct scope, String id, StackProps props) {
            Builder builder = new Builder(scope, id, props);
            return builder;
        }

        public Builder s3WriterArnPrinciple(String s3WriterArnPrinciple) {
            this.s3WriterArnPrinciple = s3WriterArnPrinciple;
            return this;
        }

        public Builder s3WriterRoleName(String s3WriterRoleName) {
            this.s3WriterRoleName = s3WriterRoleName;
            return this;
        }

        public Builder s3BucketName(String s3BucketName) {
            this.s3BucketName = s3BucketName;
            return this;
        }

        public Builder s3ObjectPrefix(String s3ObjectPrefix) {
            this.s3ObjectPrefix = s3ObjectPrefix;
            return this;
        }

        public Builder s3UseExistingBucket(boolean s3UseExistingBucket) {
            this.s3UseExistingBucket = s3UseExistingBucket;
            return this;
        }

        public Builder s3RetainBucket(boolean s3RetainBucket) {
            this.s3RetainBucket = s3RetainBucket;
            return this;
        }

        public WebStack build() {
            WebStack stack = new WebStack(this.scope, this.id, this.props, this);
            return stack;
        }

    }

    public WebStack(Construct scope, String id, WebStack.Builder builder) {
        this(scope, id, null, builder);
    }

    public WebStack(Construct scope, String id, StackProps props, WebStack.Builder builder) {
        super(scope, id, props);

        String s3BucketName = this.getConfigValue(builder.s3BucketName, "s3BucketName");
        String s3ObjectPrefix = this.getConfigValue(builder.s3ObjectPrefix, "s3ObjectPrefix");
        boolean s3UseExistingBucket = Boolean.parseBoolean(this.getConfigValue(Boolean.toString(builder.s3UseExistingBucket), "s3UseExistingBucket"));
        boolean s3RetainBucket = Boolean.parseBoolean(this.getConfigValue(Boolean.toString(builder.s3RetainBucket), "s3RetainBucket"));
        String s3WriterRoleName = this.getConfigValue(builder.s3WriterRoleName, "s3WriterRoleName");
        String s3WriterArnPrinciple = this.getConfigValue(builder.s3WriterArnPrinciple, "s3WriterArnPrinciple");

        if (s3UseExistingBucket) {
            this.eventsBucket = Bucket.fromBucketName(this, "EventsBucket", s3BucketName);
        } else {
            this.eventsBucket = Bucket.Builder.create(this, "EventsBucket")
                    .bucketName(s3BucketName)
                    .versioned(true)
                    .removalPolicy(s3RetainBucket ? RemovalPolicy.RETAIN : RemovalPolicy.DESTROY)
                    .autoDeleteObjects(!s3RetainBucket)
                    .build();
            this.eventsBucketLogGroup = LogGroup.Builder.create(this, "EventsBucketLogGroup")
                    .logGroupName("/aws/s3/" + this.eventsBucket.getBucketName())
                    .retention(RetentionDays.THREE_DAYS)
                    .build();
            this.eventsBucketTrail = Trail.Builder.create(this, "EventsBucketAccessTrail")
                    .trailName(this.eventsBucket.getBucketName() + "-access-trail")
                    .cloudWatchLogGroup(this.eventsBucketLogGroup)
                    .sendToCloudWatchLogs(true)
                    .cloudWatchLogsRetention(RetentionDays.THREE_DAYS)
                    .includeGlobalServiceEvents(false)
                    .isMultiRegionTrail(false)
                    .build();

            this.eventsBucketTrail.addS3EventSelector(Arrays.asList(S3EventSelector.builder()
                    .bucket(this.eventsBucket)
                    .objectPrefix(s3ObjectPrefix)
                    .build()
            ));
        }

        PolicyStatement eventsObjectCrudPolicyStatement = PolicyStatement.Builder.create()
                .effect(Effect.ALLOW)
                .actions(List.of(
                        "s3:PutObject",
                        "s3:GetObject",
                        "s3:ListBucket",
                        "s3:DeleteObject"
                ))
                .resources(List.of(
                        this.eventsBucket.getBucketArn(),
                        this.eventsBucket.getBucketArn() + "/" + s3ObjectPrefix + "*"
                ))
                .build();
        this.s3AccessRole = Role.Builder.create(this, "EventsS3AccessRole")
                .roleName(s3WriterRoleName)
                .assumedBy(new ArnPrincipal(s3WriterArnPrinciple))
                .inlinePolicies(java.util.Collections.singletonMap("S3AccessPolicy", PolicyDocument.Builder.create()
                        .statements(List.of(eventsObjectCrudPolicyStatement))
                        .build()))
                .build();
    }

    private String getConfigValue(String customValue, String contextKey) {
        if (customValue == null || customValue.isEmpty()) {
            Object contextValue = null;
            try {
                contextValue = this.getNode().tryGetContext(contextKey);
            }catch (Exception e) {
                // NOP
            }
            if (contextValue != null && !contextValue.toString().isEmpty()) {
                CfnOutput.Builder.create(this, contextKey)
                        .value(contextValue.toString() + " (Source: CDK context.)")
                        .build();
                return contextValue.toString();
            } else {
                throw new IllegalArgumentException("No customValue found or context key " + contextKey);
            }
        }
        return customValue;
    }
}
