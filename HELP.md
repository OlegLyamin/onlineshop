# Demo project for learning aws

### Onlineshop
Commands for running application:

docker image build -t onlineshop .

docker container run -d --name onlineshop -p 8080:8080 onlineshop


#### scp:
scp -i onlineshop.pem DockerFile ec2-user@ec2_instance_domain_name:~/.

scp -i onlineshop.pem DockerFile ec2-user@ec2_instance_domain_name:~/.

scp -i onlineshop.pem onlineshop-0.0.1-SNAPSHOT.jar ec2-user@ec2-18-193-3-97.eu-central-1.compute.amazonaws.com:~/.

#### aws ec2:
docker build -t onlineshop ./DockerFile
docker container run -d --name onlineshop -p 8080:8080 onlineshop


###
sudo rpm --import https://pkg.jenkins.io/redhat-stable/jenkins.io.key


openjdk-11
https://download.java.net/java/GA/jdk11/13/GPL/openjdk-11.0.1_linux-x64_bin.tar.gz
jdk-11.0.1

kubectl run onlineshop --image=onlineshop:0.0.1 --image-pull-policy=Never

minikube kubectl -- delete pod onlineshop
minikube kubectl -- delete service onlineshop
minikube kubectl -- delete deployment onlineshop


from __future__ import print_function
import boto3
import json


def lambda_handler(event, context):
client = boto3.client('sns')
for record in event['Records']:
payload = record["body"]
print(str(payload))
response = client.publish(
TopicArn='sns arn here',
Message=json.dumps({'default': str(payload)}),
MessageStructure='json'
)
