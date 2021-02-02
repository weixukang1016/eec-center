FROM swr.cn-north-4.myhuaweicloud.com/pvsoul/matlab-runtime:v1.0.59
VOLUME /tmp
#°²×°libxt
COPY libxt/  /usr/local/libxt/
RUN cd /usr/local/libxt \
    && ./INSTALL
ADD target/eec-center-0.0.1-SNAPSHOT.jar /eec-center.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eec-center.jar"]