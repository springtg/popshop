@echo off
echo [INFO] ʹ��maven����selenium ���ܲ���.
echo [INFO] ��ȷ��Tomcat 6������������conf/tomcat-users.xml������admin�û�.
echo [INFO] ��ȷ��Selenium Server������.

cd ..
call mvn integration-test -Pfunctional
cd bin
pause