## Simple Spring Boot Greetings App Using Gradle Multi Project

### Build
```sh
./gradlew clean build
```
### Run
```sh
java -jar services/hello-service/build/libs/hello-service-0.0.1-SNAPSHOT.jar
```
### Test 1: Endpoint Without Parameter
```sh
curl -sb -H http://localhost:8080/greeting/v1/hello 
```
#### Output
```javascript
{"message":"Hello","responseTime":1508616187061}
```
### Test 2: Endpoint With Parameter
```sh
curl -sb -H http://localhost:8080/greeting/v1/hello/rakesh 
```
#### Output
```javascript
{"message":"Hello Rakesh","responseTime":1508616314648}
```
