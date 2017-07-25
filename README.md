# spring-boot-demo

Code for demonstration only, ***Kids, don't try this at home*** :) 

--
Script for user data:

#!/bin/bash
sudo yum update -y
cd /home/ec2-user/
curl -L -O -H "Cookie: oraclelicense=accept-securebackup-cookie" -k "http://download.oracle.com/otn-pub/java/jdk/8u131-b11/d54c1d3a095b4ff2b6607d096fa80163/jdk-8u131-linux-x64.tar.gz"
tar xfvz jdk-8u131-linux-x64.tar.gz
curl -L -O -k "http://ftp.unicamp.br/pub/apache/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz"
tar xfvz apache-maven-3.3.9-bin.tar.gz
yum install git -y
git clone https://github.com/andregouvea/demo-spring-boot-ec2
echo "export JAVA_HOME=/home/ec2-user/jdk1.8.0_131" >> /home/ec2-user/.bashrc
echo "export M2_HOME=/home/ec2-user/apache-maven-3.3.9" >> /home/ec2-user/.bashrc
echo "export M2=\$M2_HOME/bin" >> /home/ec2-user/.bashrc
echo "export PATH=\$JAVA_HOME/bin:\$M2:\$PATH" >> /home/ec2-user/.bashrc
source .bashrc
echo "#"'!'"/bin/sh" > run.sh
echo "cd demo-spring-boot-ec2" >> run.sh
echo "nohup mvn spring-boot:run >> nohup.out 2>&1 &" >> run.sh
echo "  " >> run.sh
chmod 775 /home/ec2-user/run.sh
/home/ec2-user/run.sh
