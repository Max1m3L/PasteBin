FROM openjdk:21
LABEL authors="maxLVSHV"
ADD /target/PasteBin-0.0.1-SNAPSHOT.jar back.jar
ENTRYPOINT ["java", "-jar", "back.jar"]