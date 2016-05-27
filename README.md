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
