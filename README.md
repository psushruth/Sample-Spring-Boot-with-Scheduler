# Sample-Spring-Boot-with-Scheduler

Implement Project Euler problem 21.

To run

1. mvn package.
2. java -jar target/Sample-Application-1.0-SNAPSHOT.jar

Design.

1. Use Spring boot to orchsetrate the application.
2. Spring scheduler to wakeup every 3 seconds & do a post request.
3. REST service receives the request & calculates the solution to Project EUler 21 & returns response in Json.
4. if request has been processed before then throw http code 409.
5. Used HSQL database & spring hibernate for persistance.

Code.

1. Sender.java uses springs REST template to build a request & issue post.
2. AppController.java - controller to receive post requets & forward them to the Euler algorithm processor.
3. EulerAlgorithm.java - solves the problem for question 21 & returns a value.
4. AppRepository.java & AppServiceImple.java = to connect to embedded hsql database.
5. AppRequest.java & AppResponse.java = use entity based annotations to serialize & deserialize.
6. IdExistsException.java - custom exception class to send http 409 in case of previously seen requests.

Sample Run.
`
 .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.0.1.RELEASE)

Request={"missionId":"1","seed":17948}
Response:
HTTP code=200
Body={"answer":97402}



Request={"missionId":"1","seed":18821}
2016-06-04 10:13:47 WARN  o.s.w.c.RestTemplate:581 - POST request for "http://localhost:8080/messages" resulted in 409 (Conflict); invoking error handler
Response:
HTTP code= 409



Request={"missionId":"3","seed":15945}
Response:
HTTP code=200
Body={"answer":80106}



Request={"missionId":"4","seed":17544}
Response:
HTTP code=200
Body={"answer":97402}



Request={"missionId":"5","seed":15036}
Response:
HTTP code=200
Body={"answer":80106} `
