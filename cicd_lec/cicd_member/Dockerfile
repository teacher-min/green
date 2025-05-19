FROM openjdk:17-jdk

ARG VERSION
ARG JAR_FILE=target/memberapp-0.0.1-SNAPSHOT.jar

LABEL maintainer="KyongTae Min<minkt78@gmail.com>" \
      title="Member App" \
      description="This is member service image" \
      version="$VERSION"

COPY $JAR_FILE memberapp.jar

EXPOSE 9090

ENTRYPOINT ["java"]
CMD ["-jar", "memberapp.jar"]