FROM openjdk:oraclelinux7   

# Install sudo 
RUN yum install sudo -y

# Install curl
RUN yum install curl 

# Install Maven
ARG MAVEN_VERSION=3.9.3
ARG USER_HOME_DIR="/root"
RUN mkdir -p /usr/share/maven && \
curl -fsSL http://apache.osuosl.org/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz | tar -xzC /usr/share/maven --strip-components=1 && \
ln -s /usr/share/maven/bin/mvn /usr/bin/mvn
ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"

# Speed up Maven JVM a bit
ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"

# Create dirs and install Tomcat
RUN sudo mkdir /opt/service
RUN sudo mkdir /opt/service/tomcat
WORKDIR /opt/service/tomcat
RUN curl -O -L https://downloads.apache.org/tomcat/tomcat-10/v10.1.10/bin/apache-tomcat-10.1.10.tar.gz
RUN tar xfz apache*.tar.gz
RUN sudo mv apache-tomcat-10.1.10/* /opt/service/tomcat/.

# Create dirs and copy code to build in container. 
WORKDIR /opt/service/tomcat
RUN sudo mkdir /opt/service/tomcat/src
COPY pom.xml /opt/service/tomcat
COPY src /opt/service/tomcat/src

WORKDIR /opt/service/tomcat
RUN sudo mvn clean install -DskipTests -q
RUN sudo cp /opt/service/tomcat/target/pub*.war /opt/service/tomcat/webapps/pub.war
RUN sudo rm -rf /opt/service/tomcat/src
RUN sudo rm -rf /opt/service/tomcat/apache-tomcat-10.1.10.tar.gz
RUN sudo rm -rf /opt/service/tomcat/apache-tomcat-10.1.10
RUN sudo rm -rf /opt/service/tomcat/target

WORKDIR /opt/service/tomcat
EXPOSE 8080
CMD ["/opt/service/tomcat/bin/catalina.sh", "run"]
