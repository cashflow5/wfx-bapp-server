118 更新wfx-bapp-server， root登录后进入wfx-bpp-server 运行deploy_restart.sh 自动更新代码打包更新部署。
#cd cd wfx-bapp-server/
# ./deploy_restart.sh


0.在249上 第一次下载代码（之后不需要执行此步骤）
# git clone git@10.20.30.14:wfx/wfx-bapp-server.git
1.进入249目录
# cd wfx-bapp-server
2.更新
# git pull
3.打包：
# mvn package -DskipTests  
4将  wfx-bapp-server/appserver-core/target/wfx-bapp-server.jar 上传到118 上的  /root/wfx-bapp-server/201605031120 （201605031120当前时间分钟,每次变化）

# scp -P 22 /root/wfx-bapp-server/appserver-core/target/wfx-bapp-server.jar root@192.168.211.118:/root/wfx-bapp-server/201605031120/wfx-bapp-server.jar

部署重启：
1.停止服务
# ps -A -o pid,cmd|grep java |grep 'java -jar wfx-bapp-server.jar' | grep -v grep | head -n 1 |awk '{print $1}' | xargs kill -9
2.清空部署
# rm  /usr/local/wfx-bapp-server/wfx-bapp-server.jar
3.更新部署 （201605031120 改为上面打包上传的目录,每次变化）
# cp /root/wfx-bapp-server/201605031120/wfx-bapp-server.jar /usr/local/wfx-bapp-server/
4.进入目录
# cd /usr/local/wfx-bapp-server/
5.启动服务
# java -jar wfx-bapp-server.jar > /dev/null &


测试环境配置文件:
/usr/local/wfx-bapp-server/config/application.properties