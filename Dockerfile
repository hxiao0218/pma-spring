FROM ubuntu-jdk

MAINTAINER HX "hxiao0218@gmail.com"

ENV version=aws-db-usage
ENV dbuser=postgres
ENV dbpass=password321
ENV jdbcurl=jdbc:postgresql://pmadatabaseaws.csqj6frnjrln.us-east-2.rds.amazonaws.com:5432/postgres

WORKDIR /user/local/bin

ADD target/project-management-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-jar", "project-management-0.0.1-SNAPSHOT.jar"]











