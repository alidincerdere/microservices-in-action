When you start config server you can check default properties of licensing-service microservice by the following path:

http://localhost:8090/licensing-service/default

http://localhost:8090/licensing-service/dev


--------

we can have the following command line parameters:

java  -Dspring.cloud.config.uri=http://localhost:8091 \
      -Dspring.profiles.active=dev \
      -jar target/licensing-service-0.0.1-SNAPSHOT.jar


--------

some actuator endpoints:

http://localhost:8091/actuator/health

http://localhost:8091/actuator/env

--------

refresh endpoint:

POST http://localhost:8091/actuator/refresh

--------

eureka naming server

http://localhost:8761/eureka/apps/licensing-service
