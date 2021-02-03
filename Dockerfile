FROM swr.cn-north-4.myhuaweicloud.com/pvsoul/matlab-runtime:v1.0.59
VOLUME /tmp
RUN apt install xfce4 xfce4-goodies xorg dbus-x11 x11-xserver-utils
#°²×°libxt
#ADD libxt_1.2.0.orig.tar.gz  /usr/local/
#RUN cd /usr/local/libXt-1.2.0 \
#    && chmod 777 ./INSTALL \
#    && make install
ADD target/eec-center-0.0.1-SNAPSHOT.jar /eec-center.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eec-center.jar"]