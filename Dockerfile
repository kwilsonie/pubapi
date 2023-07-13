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
RUN mkdir /opt/service

# Create user to run app - try user 
RUN groupadd -g 999 appuser               
RUN useradd -r -u 1000 -g appuser appuser 
RUN mkdir /home/appuser                   
RUN chown appuser /home/appuser
RUN chown appuser /opt/service
USER appuser

# Create dirs and install Tomcat
RUN mkdir /opt/service/tomcat
WORKDIR /opt/service/tomcat
RUN curl -O -L https://downloads.apache.org/tomcat/tomcat-10/v10.1.10/bin/apache-tomcat-10.1.10.tar.gz
RUN tar xfz apache*.tar.gz
RUN mv apache-tomcat-10.1.10/* /opt/service/tomcat/.

# Create dirs and copy code to build in container. 
WORKDIR /opt/service/tomcat
RUN mkdir /opt/service/tomcat/src
COPY pom.xml /opt/service/tomcat
COPY src /opt/service/tomcat/src

WORKDIR /opt/service/tomcat
RUN mvn clean install -DskipTests -q
RUN cp /opt/service/tomcat/target/pub*.war /opt/service/tomcat/webapps/pub.war

USER root 
RUN rm -rf /opt/service/tomcat/src
RUN rm -rf /opt/service/tomcat/apache-tomcat-10.1.10.tar.gz
RUN rm -rf /opt/service/tomcat/apache-tomcat-10.1.10
RUN rm -rf /opt/service/tomcat/target

USER appuser
WORKDIR /opt/service/tomcat
EXPOSE 8080
CMD ["/opt/service/tomcat/bin/catalina.sh", "run"]

