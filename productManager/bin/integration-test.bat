@echo off
echo [INFO] ʹ��maven���ɲ���.
echo [INFO] ��ȷ�����ݿ�������.

cd ..
call mvn integration-test  -Pintegration
cd bin
pause