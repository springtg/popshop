@echo off
echo [INFO] ʹ��maven������Ŀ��������tomcat��.
echo [INFO] ��ȷ��Tomcat 6������������conf/tomcat-users.xml������admin�û�.

cd ..
call mvn package cargo:redeploy
cd bin
pause