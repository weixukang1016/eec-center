#从安装了libxt6的matlab-runtime镜像构建能效云
#FROM swr.cn-east-3.myhuaweicloud.com/hw68278460/matlab-runtime:v1.0.17
#从安装了xorg的matlab-runtime镜像构建能效云
FROM  swr.cn-north-4.myhuaweicloud.com/pvsoul/matlab-runtime:v1.0.110
VOLUME /tmp
ADD target/eec-center-0.0.1-SNAPSHOT.jar /eec-center.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eec-center.jar"]