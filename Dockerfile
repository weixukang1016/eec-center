FROM swr.cn-north-4.myhuaweicloud.com/pvsoul/matlab-runtime:v1.0.59
VOLUME /tmp
#°²×°libxt
ADD libxt_1.2.0.orig.tar.gz  /usr/local/
RUN cd /usr/local/libXt-1.2.0 \
    && chmod 777 ./INSTALL \
    && ./INSTALL
ADD target/eec-center-0.0.1-SNAPSHOT.jar /eec-center.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eec-center.jar"]