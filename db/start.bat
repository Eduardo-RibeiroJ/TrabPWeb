SET DERBY_HOME=%USERPROFILE%\Desktop\db
set CLASSPATH=%DERBY_HOME%\lib\derbyclient.jar;%DERBY_HOME%\lib\derbytools.jar;%
java -jar %DERBY_HOME%\lib\derbyrun.jar server start
