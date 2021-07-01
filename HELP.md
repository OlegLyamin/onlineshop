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
