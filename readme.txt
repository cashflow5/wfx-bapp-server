118 ����wfx-bapp-server�� root��¼�����wfx-bpp-server ����deploy_restart.sh �Զ����´��������²���
#cd cd wfx-bapp-server/
# ./deploy_restart.sh


0.��249�� ��һ�����ش��루֮����Ҫִ�д˲��裩
# git clone git@10.20.30.14:wfx/wfx-bapp-server.git
1.����249Ŀ¼
# cd wfx-bapp-server
2.����
# git pull
3.�����
# mvn package -DskipTests  
4��  wfx-bapp-server/appserver-core/target/wfx-bapp-server.jar �ϴ���118 �ϵ�  /root/wfx-bapp-server/201605031120 ��201605031120��ǰʱ�����,ÿ�α仯��

# scp -P 22 /root/wfx-bapp-server/appserver-core/target/wfx-bapp-server.jar root@192.168.211.118:/root/wfx-bapp-server/201605031120/wfx-bapp-server.jar

����������
1.ֹͣ����
# ps -A -o pid,cmd|grep java |grep 'java -jar wfx-bapp-server.jar' | grep -v grep | head -n 1 |awk '{print $1}' | xargs kill -9
2.��ղ���
# rm  /usr/local/wfx-bapp-server/wfx-bapp-server.jar
3.���²��� ��201605031120 ��Ϊ�������ϴ���Ŀ¼,ÿ�α仯��
# cp /root/wfx-bapp-server/201605031120/wfx-bapp-server.jar /usr/local/wfx-bapp-server/
4.����Ŀ¼
# cd /usr/local/wfx-bapp-server/
5.��������
# java -jar wfx-bapp-server.jar > /dev/null &


���Ի��������ļ�:
/usr/local/wfx-bapp-server/config/application.properties