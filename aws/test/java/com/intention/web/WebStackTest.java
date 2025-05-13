package com.intention.web;

import org.junit.jupiter.api.Test;
import software.amazon.awscdk.App;
import software.amazon.awscdk.assertions.Template;

public class WebStackTest {

    @Test
    public void testStackResources() {
        App app = new App();

        WebStack stack = WebStack.Builder.create(app, "WebStack")
                .env("test")
                .hostedZoneName("test.xn--intenton-z2a.com")
                .hostedZoneId("test")
                .subDomainName("test")
                .useExistingHostedZone("false")
                .certificateId("test")
                .useExistingCertificate("false")
                .cloudTrailEnabled("true")
                .cloudTrailLogGroupPrefix("/aws/s3/")
                .cloudTrailLogGroupRetentionPeriodDays("3")
                .accessLogGroupRetentionPeriodDays("30")
                .s3UseExistingBucket("false")
                .s3RetainBucket("false")
                .cloudTrailEventSelectorPrefix("none")
                .logS3ObjectEventHandlerSource("none")
                .logGzippedS3ObjectEventHandlerSource("none")
                .docRootPath("public/")
                .error404HtmlOrigin("404-error-origin.html")
                .error404HtmlDistribution("404-error-distribution.html")
                .build();

        Template template = Template.fromStack(stack);
        template.resourceCountIs("AWS::S3::Bucket", 4);
    }
}
