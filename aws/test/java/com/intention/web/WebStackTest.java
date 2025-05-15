package com.intention.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import software.amazon.awscdk.App;
import software.amazon.awscdk.assertions.Template;
import uk.org.webcompere.systemstubs.environment.EnvironmentVariables;
import uk.org.webcompere.systemstubs.jupiter.SystemStub;
import uk.org.webcompere.systemstubs.jupiter.SystemStubsExtension;

@ExtendWith(SystemStubsExtension.class)
public class WebStackTest {

    private static final String testAccount = "111111111111";

    @SystemStub
    private EnvironmentVariables environmentVariables =
            new EnvironmentVariables(
                    //"JSII_SILENCE_WARNING_UNTESTED_NODE_VERSION", "true",
                    //"JSII_SILENCE_WARNING_DEPRECATED_NODE_VERSION", "true",
                    "TARGET_ENV", "test",
                    "AWS_REGION", "eu-west-2",
                    "CDK_DEFAULT_ACCOUNT", testAccount,
                    "CDK_DEFAULT_REGION", "eu-west-2"
            );

    @Test
    public void testStackResources() {
        App app = new App();

        WebStack stack = WebStack.Builder.create(app, "WebStack")
                .env("test")
                .hostedZoneName("test.xn--intenton-z2a.com")
                .hostedZoneId("test")
                .subDomainName("test")
                .useExistingHostedZone("false")
                .certificateArn("test")
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
                .defaultDocumentAtOrigin("404-error-origin.html")
                .error404NotFoundAtDistribution("404-error-distribution.html")
                .build();

        Template template = Template.fromStack(stack);
        template.resourceCountIs("AWS::S3::Bucket", 4);
    }
}
