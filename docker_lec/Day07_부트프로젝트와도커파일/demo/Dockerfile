# 베이스 이미지
FROM openjdk:17

# 인자
ARG VERSION
ARG JAR_FILE=target/*.jar

# 포트 열기
EXPOSE 8080

# 작업 디렉터리 (컨테이너 내부 경로)
WORKDIR /app

# 작업 디렉터리로 jar 복사
COPY ${JAR_FILE} demo.jar

# 실행 명령
ENTRYPOINT [ "java" ]

# 실행 명령
CMD [ "-jar", "demo.jar" ]