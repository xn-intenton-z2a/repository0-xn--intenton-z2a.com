package com.intention.web;

import software.amazon.awscdk.App;
import software.amazon.awscdk.CfnOutput;

public class WebApp {
    public static void main(final String[] args) {
        App app = new App();

        WebStack stack = WebStack.Builder.create(app, "WebStack")
                .env(System.getenv("ENV_NAME"))
                .hostedZoneName(System.getenv("HOSTED_ZONE_NAME"))
                .hostedZoneId(System.getenv("HOSTED_ZONE_ID"))
                .subDomainName(System.getenv("SUB_DOMAIN_NAME"))
                .useExistingHostedZone(Boolean.parseBoolean(System.getenv("USE_EXISTING_HOSTED_ZONE")))
                .useExistingCertificate(Boolean.parseBoolean(System.getenv("USE_EXISTING_CERTIFICATE")))
                .cloudTrailEnabled(Boolean.parseBoolean(System.getenv("CLOUD_TRAIL_ENABLED")))
                .cloudTrailLogGroupPrefix(System.getenv("CLOUD_TRAIL_LOG_GROUP_PREFIX"))
                .cloudTrailLogGroupRetentionPeriodDays(Integer.parseInt(System.getenv("CLOUD_TRAIL_LOG_GROUP_RETENTION_PERIOD_DAYS")))
                .accessLogGroupRetentionPeriodDays(Integer.parseInt(System.getenv("ACCESS_LOG_GROUP_RETENTION_PERIOD_DAYS")))
                .s3UseExistingBucket(Boolean.parseBoolean(System.getenv("USE_EXISTING_BUCKET")))
                .s3RetainBucket(Boolean.parseBoolean(System.getenv("RETAIN_BUCKET"))) // TODO: Switch to removal policy
                .cloudTrailEventSelectorPrefix(System.getenv("OBJECT_PREFIX"))
                .logS3ObjectEventHandlerSource(System.getenv("LOG_S3_OBJECT_EVENT_HANDLER_SOURCE"))
                .logGzippedS3ObjectEventHandlerSource(System.getenv("LOG_GZIPPED_S3_OBJECT_EVENT_HANDLER_SOURCE"))
                .docRootPath(System.getenv("DOC_ROOT_PATH"))
                .error404HtmlOrigin(System.getenv("DEFAULT_HTML_DOCUMENT"))
                .error404HtmlDistribution(System.getenv("ERROR_HTML_DOCUMENT"))
                .build();

        CfnOutput.Builder.create(stack, "OriginBucketArn")
                .value(stack.originBucket.getBucketArn())
                .build();

        CfnOutput.Builder.create(stack, "OriginAccessLogBucketArn")
                .value(stack.originAccessLogBucket.getBucketArn())
                .build();

        CfnOutput.Builder.create(stack, "DistributionAccessLogBucketArn")
                .value(stack.distributionAccessLogBucket.getBucketArn())
                .build();

        CfnOutput.Builder.create(stack, "DistributionId")
                .value(stack.distribution.getDistributionId())
                .build();

        CfnOutput.Builder.create(stack, "HostedZoneId")
                .value(stack.hostedZone.getHostedZoneId())
                .build();

        CfnOutput.Builder.create(stack, "CertificateArn")
                .value(stack.certificate.getCertificateArn())
                .build();

        CfnOutput.Builder.create(stack, "ARecord")
                .value(stack.aRecord.getDomainName())
                .build();

        CfnOutput.Builder.create(stack, "AaaaRecord")
                .value(stack.aaaaRecord.getDomainName())
                .build();

        app.synth();
    }
}
