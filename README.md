# intentïon.com (repository0-xn-intenton-z2a.com)

The consumer front end of intentïon.com 
featuring [repository0](https://github.com/xn-intenton-z2a/repository0) 
and the [agentic-lib](https://github.com/xn-intenton-z2a/agentic-lib).

`xn--intenton-z2a.com` is a project by Polycode Limited which presents the intentïon home page: https://xn--intenton-z2a.com/

## TODO

Public brand:
- [x] Website for intentïon.com text light, light grey or misty: https://xn--intenton-z2a.com/
- [x] Logo selection
- [x] Sign up for LinkTree
- [x] CDK deploy
- [x] Swap to use repository0 template.
- [x] CI deployment
- [~] Swap over to host live site from the CDK deployment by adding default environment 'ci' and the option of 'prod'.
- [~] Automated activity generation from showcased projects
- [ ] Chat to interact with the projects
- [ ] Showcase links
- [ ] Automated feed generation
- [ ] Add contact bots for socials
- [ ] Add contact bots via Slack / Discord or Redit
- [ ] Register: intentiion.com, intentionai.com, intentiionai.com, intentiionaii.com
- [ ] Brand ownership
- [ ] Brand protection
- [ ] Web analytics
- [ ] Link to Linktree
- [ ] Audience Dashboard


LinkedIn - https://www.linkedin.com/company/intentïon
```
-> intentïon.com
-> Personal LinkedIn
-> Shared showcased projects posts crediting the service or API used
-> No direct messages
-> Comments and mentions are an [Inbox]
```

Facebook - https://www.facebook.com/profile.php?id=61559328506140
```
-> intentïon.com
-> Shared showcased projects posts crediting the service or API used
-> No direct messages
-> Comments and mentions are an [Inbox]
```

Twitter - https://twitter.com/intentiionai
```
-> intentïon.com
-> Re-Tweets of showcased projects tweets crediting the service or API used
-> No direct messages
-> Replies and mentions are an [Inbox]
```

Instagram - https://www.instagram.com/intentiionaii
```
-> LinkTree
-> Shared showcased projects posts crediting the service or API used
-> No direct messages
-> Comments and mentions are an [Inbox]
```

LinkTree - https://linktr.ee/intentiion
```
-> intentïon.com
-> LinkedIn
-> Facebook
-> Twitter
-> Instagram
```

GitHub (showcase projects)
```
-> How to seed a new similar project [Goal]
-> Featured intentïon services
-> Featured intentïon APIs
-> Download and clone stats
-> CI stats
-> Attribution documents
-> Contributor guidelines
```

GitHub (projects)
```
-> How to seed a project [Goal]
-> Examples (such as the showcase projects)
-> Activity in social media
-> Discussion forum
-> Wiki
-> Ticketing system [Inbox]
```

Request email
```
-> Link on intentïon.com to a form to request contact by email [Inbox]
```

# intentïon: The Feedback Loop of Innovation

intentïon is the beginning of an iterative journey where AI meets real-world interaction and creative problem-solving. Intentïon is built around the concept that conversational AI that engages in a continuous cycle of feedback and enhancement.

Starting with a number-guessing game that teaches the AI the basics of interaction and response adjustment, intentïon paves the way for AI to step out of the virtual domain and interact with the physical environment. This project embodies the integration of AI into real-world applications, foreseeing a future where AI, with resources like 3D printing and drone technology, could manifest a tangible presence and contribute substantively to tasks that were once the sole domain of humans.

Going beyond the fundamentals, intentïon aspires to harness the vast potential of social media, envisioning an AI that can not only create and manage an online presence but also attract a following and engage in complex activities such as securing sponsorships. This leap from simple number prediction to negotiating the social media landscape marks a significant step in AI's evolution, rooted in the belief that a careful blend of machine learning and human oversight can push the boundaries of what we perceive as achievable.

What intentïon brings to the table is not just a promise but a steady march towards realizing the intersection of AI capabilities and human aspirations. It invites us to ponder, as we witness this fusion of technology and creativity unfold, "What is your intentïon?"

## Pronunciation

intentïon. Pronunciation: /ɪnˈtɛnʃən/. The diaeresis? It's a style thing (and .com was available for 13 bucks); you are invited to pronounce your intentïon as you please.

## Glossary

- **intentïon**: An *intentïon* can be *accomplished* in a single *iteration* with at least one *parameter set*.
- **iteration**: An *iteration* is a finite pre-defined *workflow* of *actions* initiated by a *request*.
- **request**: A *request* is described by a **parameter set** (the inputs) and it has a *response* (the outputs).
- **workflow**: A *workflow* is a *parameterised* network of procedural structures. e.g. A flowchart description of a process.
- **action**: An *action* uses an *expression* of *capabilities* to transform an input into an output.
- **expression**: An *expression* is a functional structure. e.g. A mathematical formula.
- **capability**: A *capability* is a functional unit. e.g. A mathematical operation.
- **response**: A *response* is the output of a *workflow*.
- **accomplished**: An *intentïon* infers the state when *accomplished*. e.g. An intention to walk is accomplished when walking.
- **parameterised**: A *workflow* is *parameterised* using a *heuristic* to select a *parameter set* from the *parameter search space*.
- **parameter search space**: The *parameter search space* is every *parameter set* requires to access all the navigable paths through the network and the full range of inputs for the *actions*.
- **parameter set**: A *parameter set* is a set of inputs that can be used to execute an *iteration*.
- **heuristic**: A *heuristic* can apply the *intentïon* to select a *parameter set* from the *search space*.
- **enhancement**: An *enhancement* is the *heuristic* applied to previous request & responses and the *intentïon*.

# Deployment

## Local Development Environment

### Clone the Repository

```bash

git clone https://github.com/your-username/repository0-xn-intenton-z2a.com.git
cd repository0-xn-intenton-z2a.com
```

### Install Node.js dependencies and test

```bash

npm install
npm test
```

### Build and test the Java Application

```bash
./mvnw clean package
```

### Synthesis the CDK

```bash
npx cdk synth
```

### Run the website locally

```bash
http-server public/ --port 3000
```

Webserver output:
```log
Starting up http-server, serving public/

http-server version: 14.1.1

http-server settings: 
CORS: disabled
Cache: 3600 seconds
Connection Timeout: 120 seconds
Directory Listings: visible
AutoIndex: visible
Serve GZIP Files: false
Serve Brotli Files: false
Default File Extension: none

Available on:
  http://127.0.0.1:3000
  http://192.168.1.121:3000
  http://10.14.0.2:3000
  http://169.254.59.96:3000
Hit CTRL-C to stop the server
```

Access via http://127.0.0.1:3000 or install [ngrok](https://ngrok.com/) and get a SSL terminated public URL:
```bash
ngrok http 3000
```

ngrok runs:
```log
ngrok                                                                                                                                                                                                          (Ctrl+C to quit)
                                                                                                                                                                                                                               
🤖 Want to hang with ngrokkers on our new Discord? http://ngrok.com/discord                                                                                                                                                    
                                                                                                                                                                                                                               
Session Status                online                                                                                                                                                                                           
Account                       Antony @ Polycode (Plan: Free)                                                                                                                                                                   
Version                       3.22.1                                                                                                                                                                                           
Region                        Europe (eu)                                                                                                                                                                                      
Web Interface                 http://127.0.0.1:4040                                                                                                                                                                            
Forwarding                    https://d57b-146-70-103-222.ngrok-free.app -> http://localhost:3000                                                                                                                              
                                                                                                                                                                                                                               
Connections                   ttl     opn     rt1     rt5     p50     p90                                                                                                                                                      
                              0       0       0.00    0.00    0.00    0.00                  
```

Here you can open https://d57b-146-70-103-222.ngrok-free.app in a browser of your choice (you'll have your own URL
unless I am still running this one, I don't know when the id's roll so I might.)

## Setup for AWS CDK

You'll need to have run `cdk bootstrap` to set up the environment for the CDK. This is a one-time setup per AWS account and region.
General administrative permissions are required to run this command. (NPM installed the CDK.)

In this example for user `antony-local-user` and `agentic-lib-github-actions-role` we would add the following
trust policy so that they can assume the role: `agentic-lib-deployment-role`:
```json
{
	"Version": "2012-10-17",
	"Statement": [
		{
			"Sid": "Statement1",
			"Effect": "Allow",
			"Action": ["sts:AssumeRole", "sts:TagSession"],
			"Resource": ["arn:aws:iam::541134664601:role/agentic-lib-deployment-role"]
		}
	]
}
```

The `agentic-lib-github-actions-role` also needs the following trust entity to allow GitHub Actions to assume the role:
```json
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Principal": {
                "Federated": "arn:aws:iam::541134664601:oidc-provider/token.actions.githubusercontent.com"
            },
            "Action": "sts:AssumeRoleWithWebIdentity",
            "Condition": {
                "StringEquals": {
                    "token.actions.githubusercontent.com:aud": "sts.amazonaws.com"
                },
                "StringLike": {
                    "token.actions.githubusercontent.com:sub": "repo:xn-intenton-z2a/s3-sqs-bridge:*"
                }
            }
        }
    ]
}
```

Create the IAM role with the necessary permissions to assume role from your authenticated user:
```bash

cat <<'EOF' > agentic-lib-deployment-trust-policy.json
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Principal": {
        "AWS": [
          "arn:aws:iam::541134664601:user/antony-local-user",
          "arn:aws:iam::541134664601:role/agentic-lib-github-actions-role"
        ]
      },
      "Action": "sts:AssumeRole"
    }
  ]
}
EOF
aws iam create-role \
  --role-name agentic-lib-deployment-role \
  --assume-role-policy-document file://agentic-lib-deployment-trust-policy.json
```

Add the necessary permissions to deploy `repository0-xn-intenton-z2a.com`:
```bash

cat <<'EOF' > agentic-lib-deployment-permissions-policy.json
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Action": [
        "cloudformation:*",
        "iam:*",
        "s3:*",
        "cloudtrail:*",
        "logs:*",
        "events:*",
        "lambda:*",
        "dynamodb:*",
        "sqs:*",
        "sts:AssumeRole"
      ],
      "Resource": "*"
    }
  ]
}
EOF
aws iam put-role-policy \
  --role-name agentic-lib-deployment-role \
  --policy-name agentic-lib-deployment-permissions-policy \
  --policy-document file://agentic-lib-deployment-permissions-policy.json
```

Assume the deployment role:
```bash

ROLE_ARN="arn:aws:iam::541134664601:role/agentic-lib-deployment-role"
SESSION_NAME="agentic-lib-deployment-session-local"
ASSUME_ROLE_OUTPUT=$(aws sts assume-role --role-arn "$ROLE_ARN" --role-session-name "$SESSION_NAME" --output json)
if [ $? -ne 0 ]; then
  echo "Error: Failed to assume role."
  exit 1
fi
export AWS_ACCESS_KEY_ID=$(echo "$ASSUME_ROLE_OUTPUT" | jq -r '.Credentials.AccessKeyId')
export AWS_SECRET_ACCESS_KEY=$(echo "$ASSUME_ROLE_OUTPUT" | jq -r '.Credentials.SecretAccessKey')
export AWS_SESSION_TOKEN=$(echo "$ASSUME_ROLE_OUTPUT" | jq -r '.Credentials.SessionToken')
EXPIRATION=$(echo "$ASSUME_ROLE_OUTPUT" | jq -r '.Credentials.Expiration')
echo "Assumed role successfully. Credentials valid until: $EXPIRATION"
```
Output:
```log
Assumed role successfully. Credentials valid until: 2025-03-25T02:27:18+00:00
```

Check the session:
```bash

aws sts get-caller-identity
```

Output:
```json
{
  "UserId": "AROAX37RDWOM7ZHORNHKD:agentic-lib-deployment-session",
  "Account": "541134664601",
  "Arn": "arn:aws:sts::541134664601:assumed-role/agentic-lib-deployment-role/agentic-lib-deployment-session"
}
```

Check the permissions of the role:
```bash

aws iam list-role-policies \
  --role-name agentic-lib-deployment-role
```
Output (the policy we created above):
```json
{
  "PolicyNames": [
    "agentic-lib-deployment-permissions-policy"
  ]
}
```

An example of the GitHub Actions role being assumed in a GitHub Actions Workflow:
```yaml
      - name: Configure AWS Credentials
        uses: aws-actions/configure-aws-credentials@v4
        with:
          role-to-assume: arn:aws:iam::541134664601:role/agentic-lib-deployment-role
          aws-region: eu-west-2
      - name: Set up Node.js
        uses: actions/setup-node@v3
        with:
          node-version: '20'
      - run: npm install -g aws-cdk
      - run: aws s3 ls --region eu-west-2
```

## Deployment to AWS

See also:
* local running using [Localstack](LOCALSTACK.md).
* Debugging notes for the AWS deployment here [DEBUGGING](DEBUGGING.md).

Package the CDK, deploy the CDK stack which rebuilds the Docker image, and deploy the AWS infrastructure:
```bash

./mvnw clean package
```

Maven build output:
```log
...truncated...
[INFO] Replacing original artifact with shaded artifact.
[INFO] Replacing /Users/antony/projects/repository0-xn--intenton-z2a.com/target/web-1.1.0.jar with /Users/antony/projects/repository0-xn--intenton-z2a.com/target/web-1.1.0-shaded.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  15.522 s
[INFO] Finished at: 2025-05-14T03:16:19+02:00
[INFO] ------------------------------------------------------------------------
```

Assume deployment role:
```bash

. ./scripts/aws-assume-agentic-lib-deployment-role.sh                                     
```

Output:
```log
Assumed arn:aws:iam::541134664601:role/agentic-lib-deployment-role successfully, expires: 2025-05-14T02:19:16+00:00. Identity is now:
{
"UserId": "AROAX37RDWOMSMQUIZOI4:agentic-lib-deployment-session-local",
"Account": "541134664601",
"Arn": "arn:aws:sts::541134664601:assumed-role/agentic-lib-deployment-role/agentic-lib-deployment-session-local"
}
```~/projects/repository0-xn--intenton-z2a.com %
```

Deploys the AWS infrastructure including an App Runner service, an SQS queue, Lambda functions, and a PostgresSQL table.
```bash

npx cdk deploy
```

Example output:
```log
WebStack | 4/8 | 3:20:29 AM | UPDATE_COMPLETE      | AWS::CloudFormation::Stack                      | WebStack 
[03:20:34] Stack WebStack has completed updating

 ✅  WebStack

✨  Deployment time: 46.85s

Outputs:
WebStack.ARecord = dev.web.xn--intenton-z2a.com
WebStack.AaaaRecord = dev.web.xn--intenton-z2a.com
WebStack.CertificateArn = arn:aws:acm:us-east-1:541134664601:certificate/73421403-bd8c-493c-888c-e3e08eec1c41
WebStack.DistributionAccessLogBucketArn = arn:aws:s3:::dev-web-intention-com-distribution-access-logs
WebStack.DistributionId = E24DIA1LSWOHYI
WebStack.HostedZoneId = Z09934692CHZL2KPE9Q9F
WebStack.OriginAccessLogBucketArn = arn:aws:s3:::dev-web-intention-com-origin-access-logs
WebStack.OriginBucketArn = arn:aws:s3:::dev-web-intention-com
WebStack.accessLogGroupRetentionPeriodDays = 30 (Source: CDK context.)
WebStack.certificateId = 73421403-bd8c-493c-888c-e3e08eec1c41 (Source: CDK context.)
WebStack.cloudTrailEnabled = true (Source: CDK context.)
WebStack.cloudTrailEventSelectorPrefix = none (Source: CDK context.)
WebStack.cloudTrailLogGroupPrefix = /aws/s3/ (Source: CDK context.)
WebStack.cloudTrailLogGroupRetentionPeriodDays = 3 (Source: CDK context.)
WebStack.defaultDocumentAtOrigin = index.html (Source: CDK context.)
WebStack.docRootPath = public (Source: CDK context.)
WebStack.env = dev (Source: CDK context.)
WebStack.error404NotFoundAtDistribution = 404-error-distribution.html (Source: CDK context.)
WebStack.hostedZoneId = Z09934692CHZL2KPE9Q9F (Source: CDK context.)
WebStack.hostedZoneName = xn--intenton-z2a.com (Source: CDK context.)
WebStack.logGzippedS3ObjectEventHandlerSource = target/web-1.1.0.jar (Source: CDK context.)
WebStack.logS3ObjectEventHandlerSource = target/web-1.1.0.jar (Source: CDK context.)
WebStack.s3RetainBucket = false (Source: CDK context.)
WebStack.s3UseExistingBucket = false (Source: CDK context.)
WebStack.subDomainName = web (Source: CDK context.)
WebStack.useExistingCertificate = true (Source: CDK context.)
WebStack.useExistingHostedZone = true (Source: CDK context.)
Stack ARN:
arn:aws:cloudformation:eu-west-2:541134664601:stack/WebStack/b49af1d0-2f5e-11f0-a683-063fb0a54f1d

✨  Total time: 52.69s

```

Destroy a previous stack and delete related log groups:
```bash

npx cdk destroy
```

Delete the log groups:
```bash

aws logs delete-log-group \
  --log-group-name "/aws/s3/s3-sqs-bridge-bucket"
```

# Prompts

Website brief:
```shell
I want a single index.html file that is well-formed, declares
and adheres to all the latest accessibility guidelines and is
responsively rendered on all mainstream devices.

The page should render the word intentïon when the screen is
tapped (or mouse moved) for 3 seconds then fade out.

The word intentïon should be in dark grey (charcoal?) and
as wide as the horizontal viewport. The background should be
light grey, almost white with a hint of yellow (like fog
under bright sunlight).

The background (full screen, no text) should have the
attached images all fading in and out of transparency at
different rates.

Please show the HTML (all inline JS and CSS) the images
and any libraries you pull in would be links.
```

## CDK  Installation and initialisation of a project deployment directory

Create a deployment directory, initialise it with a CDK project then move the files to the root of the repository:
````bash
 % mkdir account
 % cd ./account
 % cdk init app --language java
Applying project template app for java
# Welcome to your CDK Java project!
...
 % rm -rf target README .gitignore
mv -v * ../.
cdk.json -> .././cdk.json
pom.xml -> .././pom.xml
src -> .././src
 % cd ..
 % rm -rf ./account
````

## The CDK README

The `cdk.json` file tells the CDK Toolkit how to execute your app.

It is a [Maven](https://maven.apache.org/) based project, so you can open this project with any Maven compatible Java IDE to build and run tests.

Useful commands:

* `./mvnw package`     compile and run tests
* `cdk ls`          list all stacks in the app
* `cdk synth`       emits the synthesized CloudFormation template
* `cdk deploy`      deploy this stack to your default AWS account/region
* `cdk diff`        compare deployed stack with current state
* `cdk docs`        open CDK documentation

# Ownership

`xn--intenton-z2a.com` is a project by Polycode Limited which presents the intentïon home page: https://xn--intenton-z2a.com/

# License

Copyright (c) 2024 Polycode Limited

All rights reserved.

This software and associated documentation files (the "Software") are the property of Polycode Limited and are strictly confidential.
This Software is solely for use by individuals or entities that have been granted explicit permission by Polycode Limited.
This Software may not be copied, modified, distributed, sublicensed, or used in any way without the express written permission of Polycode Limited.

# Chats

intentïon: brand: https://chat.openai.com/share/(TODO: ChatGPT share link is broken)

# Thank you

Thank you for your interest in intentïon. Please be careful with our public brand.
