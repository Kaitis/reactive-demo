#!/bin/sh

ab -p json.txt -T application/json -c 100  -n 40000 http://localhost:8080/events > test1.txt &
