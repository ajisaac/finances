#!/bin/zsh

mvn clean package
rsync -avz ./target/finances-0.0.1.jar aaron@finances.homelab.io:~/finances-0.0.1.jar
ssh aaron@finances.homelab.io "sudo systemctl restart finances.service"
