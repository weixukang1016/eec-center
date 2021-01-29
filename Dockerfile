FROM swr.cn-north-4.myhuaweicloud.com/pvsoul/matlab-runtime:v1.0.39
VOLUME /tmp
ADD target/eec-center-0.0.1-SNAPSHOT.jar /eec-center.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eec-center.jar"]