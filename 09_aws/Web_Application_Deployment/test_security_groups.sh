#!/bin/bash

echo "Listing all Security Groups (Name and ID):"
aws ec2 describe-security-groups --query "SecurityGroups[*].[GroupName,GroupId]" --output table

echo -e "Inbound rules for EC2 Security Group:"
aws ec2 describe-security-groups --group-name sq-EC2WebSecurityGroup --query "SecurityGroups[0].IpPermissions"

echo -e "Inbound rules for RDS Security Group:"
aws ec2 describe-security-groups --group-name sq-RDSSecurityGroup --query "SecurityGroups[0].IpPermissions"




