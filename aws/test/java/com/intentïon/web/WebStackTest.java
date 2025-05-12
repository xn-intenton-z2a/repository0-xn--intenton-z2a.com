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
                .sqsSourceQueueName("intention-com-web-source-queue-test")
                .sqsReplayQueueName("intention-com-web-replay-queue-test")
                .sqsDigestQueueName("intention-com-web-digest-queue-test")
                // TODO: The digest queue ARN should be optional and omitted in this test.
                .sqsDigestQueueArn("arn:aws:sqs:eu-west-2:123456789012:intention-com-web-digest-queue-test")
                .sqsUseExistingDigestQueue(false)
                .sqsRetainDigestQueue(false)
                .offsetsTableName("intention-com-web-offsets-table-test")
                .projectionsTableName("intention-com-web-projections-table-test")
                .lambdaEntry("src/lib/main.")
                .replayBatchLambdaFunctionName("intention-com-web-replay-batch-function")
                .replayBatchLambdaHandlerFunctionName("replayBatchLambdaHandler")
                .sourceLambdaFunctionName("intention-com-web-source-function")
                .sourceLambdaHandlerFunctionName("sourceLambdaHandler")
                .replayLambdaFunctionName("intention-com-web-replay-function")
                .replayLambdaHandlerFunctionName("replayLambdaHandler")
                .build();

        Template template = Template.fromStack(stack);
        template.resourceCountIs("AWS::SQS::Queue", 6);
        template.resourceCountIs("AWS::Lambda::Function", 6);
    }
}
