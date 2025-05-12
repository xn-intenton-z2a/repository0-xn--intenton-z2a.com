package com.intentïon.web;

import software.amazon.awscdk.App;
import software.amazon.awscdk.CfnOutput;

public class WebApp {
    public static void main(final String[] args) {
        App app = new App();

        WebStack stack = WebStack.Builder.create(app, "WebStack")
                // TODO: LogGroup retention periods
                .s3WriterArnPrinciple(System.getenv("S3_WRITER_ARN_PRINCIPLE"))
                .s3WriterRoleName(System.getenv("S3_WRITER_ROLE_NAME"))
                .s3BucketName(System.getenv("BUCKET_NAME"))
                // TODO: S3 LogGroup prefix
                // TODO: S3 bucket enable/disable cloudtrail
                .s3ObjectPrefix(System.getenv("OBJECT_PREFIX"))
                .s3UseExistingBucket(Boolean.parseBoolean(System.getenv("USE_EXISTING_BUCKET")))
                .s3RetainBucket(Boolean.parseBoolean(System.getenv("RETAIN_BUCKET"))) // TODO: Switch to removal policy
                // TODO: S3 bucket object lifecycle policy (delete after 1 month)
                .build();

        CfnOutput.Builder.create(stack, "EventsBucketArn")
                .value(stack.eventsBucket.getBucketArn())
                .build();

        CfnOutput.Builder.create(stack, "EventsS3AccessRoleArn")
                .value(stack.s3AccessRole.getRoleArn())
                .build();

        app.synth();
    }
}
