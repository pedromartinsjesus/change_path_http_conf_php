@echo off

javac ChangePath.java
java ChangePath
c:\xampp\apache\bin\httpd -k stop


RESTARTING SERVICE....
timeout 5

c:\xampp\apache\bin\httpd -k start