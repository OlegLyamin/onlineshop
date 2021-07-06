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

ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCvqgBGolH4vUpasc4Bkd9svKkqe43TCc3gnqf919cwCmlOUVFflMswAwzTY0RlNeA9GBet2wXj92F9oB4IczvT7r7sXBg4SP/AvkM9FaTynNtkiVMKVMQ9efHHtVYj41Lmloqt4IAWtHlw8iD72TBBbsDnd9f5eZlke9yqWmuN0TQ+43eOj84oWPSMbt16zdPtsuPS/2faQQhCFE1LNKajqeP6Tip9rfxWviQcCfaJ0R3S/jL00tKXPyRHnwu/7mpXdQEu0YJ9ViFUSye1raX1dKNxr/TYR8FVHFk1JXbfNFaPt6qpOnpPcMh3R48MChXMzTfGUevQYSvsDlp5xQlv
