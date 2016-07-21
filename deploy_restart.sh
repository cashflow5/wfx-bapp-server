#!/bin/sh
git pull
sleep 2

mvn clean

sh package.sh
sleep 2

ps -A -o pid,cmd|grep java |grep 'java -jar wfx-bapp-server.jar' | grep -v grep | head -n 1 |awk '{print $1}' | xargs kill -9
sleep 2


rm  /usr/local/wfx-bapp-server/wfx-bapp-server.jar
cp appserver-core/target/wfx-bapp-server.jar /usr/local/wfx-bapp-server/
cd /usr/local/wfx-bapp-server/
java -jar wfx-bapp-server.jar   > /dev/null &

