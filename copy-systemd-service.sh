#!/bin/zsh

rsync -avz ./finances.service aaron@finances.homelab.io:~/finances.service
ssh aaron@finances.homelab.io "sudo cp ~/finances.service /etc/systemd/system/finances.service"
ssh aaron@finances.homelab.io "sudo systemctl daemon-reload"
ssh aaron@finances.homelab.io "sudo systemctl stop finances.service"
ssh aaron@finances.homelab.io "sudo systemctl disable finances.service"
ssh aaron@finances.homelab.io "sudo systemctl start finances.service"
ssh aaron@finances.homelab.io "sudo systemctl enable finances.service"

