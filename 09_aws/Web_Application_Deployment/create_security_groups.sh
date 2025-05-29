#!/bin/bash

# Get public IP of the user
MY_IP=$(curl -s ifconfig.me)
echo "Your public IP is: $MY_IP"

# Get the default VPC ID
VPC_ID=$(aws ec2 describe-vpcs --filters Name=isDefault,Values=true --query "Vpcs[0].VpcId" --output text)
echo "Default VPC ID: $VPC_ID"

# Create a Security Group for EC2
EC2_SG_ID=$(aws ec2 create-security-group --group-name sq-EC2WebSecurityGroup --description "Security group to access EC2 instance" --vpc-id $VPC_ID --query "GroupId" --output text)
echo "EC2 Security Group created: $EC2_SG_ID"

# Add ingress rules to EC2 SG (SSH, HTTP on port 8080, ICMP)
aws ec2 authorize-security-group-ingress --group-id $EC2_SG_ID --protocol tcp --port 22 --cidr ${MY_IP}/32
aws ec2 authorize-security-group-ingress --group-id $EC2_SG_ID --protocol tcp --port 8080 --cidr ${MY_IP}/32
aws ec2 authorize-security-group-ingress --group-id $EC2_SG_ID --protocol icmp --port -1 --cidr ${MY_IP}/32

# Create a Security Group for RDS
RDS_SG_ID=$(aws ec2 create-security-group --group-name sq-RDSSecurityGroup --description "Security group to allow DB access from EC2" --vpc-id $VPC_ID --query "GroupId" --output text)
echo "RDS Security Group created: $RDS_SG_ID"

# Allow MySQL access (port 3306) only from EC2 SG
aws ec2 authorize-security-group-ingress --group-id $RDS_SG_ID --protocol tcp --port 3306 --source-group $EC2_SG_ID

echo "Security Groups and rules created successfully!"

