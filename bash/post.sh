#!/bin/sh
#sudo sysctl -w net.inet.ip.portrange.first=25000 #So there are enough ports for below request

ab -p json.txt -T application/json -c 100  -n 40000 http://localhost:8080/events > test1.txt &
