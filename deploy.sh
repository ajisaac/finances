#!/bin/zsh

rsync target/finances-0.0.1-SNAPSHOT.jar aaron@finances.homelab.io:/home/aaron/finances.jar
#ssh aaron@192.168.0.27 'java -jar finances.jar'