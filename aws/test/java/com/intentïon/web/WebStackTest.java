package com.intentïon.web;

import org.junit.jupiter.api.Test;
import software.amazon.awscdk.App;
import software.amazon.awscdk.assertions.Template;

public class WebStackTest {

    @Test
    public void testStackResources() {
        App app = new App();

        WebStack stack = WebStack.Builder.create(app, "WebConfigureAndBuildStack")
                .s3WriterArnPrinciple("arn:aws:iam::123456789012:user/test")
                .s3WriterRoleName("intention-com-web-bucket-writer-role-test")
                .s3BucketName("intention-com-web-bucket-test")
                .s3ObjectPrefix("test/")
                .s3UseExistingBucket(false)
                .s3RetainBucket(false)
                .build();

        Template template = Template.fromStack(stack);
        template.resourceCountIs("AWS::S3::Bucket", 2);
    }
}
