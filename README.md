#FibonacciService
A RESTful web service that:

 - Accepts a number, <code>n</code>, as input and returns the first <code>n</code> Fibonacci numbers, starting from 0.
   (i.e. given `n = 5`, the output would be the sequence "_0 1 1 2 3_")
 - The service returns the values as a String in a JSON document.
 - Given Zero or a negative number, it responds with a status code of __FORBIDDEN__ (403) and an error String in the JSON document.
 - There are unit tests that assert the algorithm output is correct.
 - The upper boundary on the input is _93_ since the _94_ value causes an overflow of a 64-bit signed value.
 - Given a value above the upper boundary, it responds with a status code of __FORBIDDEN__ (403) and an error String in the JSON document.

While this project is admittedly trivial since it is my first attempt at a RESTful web service,
it was approached as if I would have to put it into production and maintain it for a significant period of time.

UPDATE: I have started migrating this app to SpringBoot as I'm learning this new to me technology, but I'm continuing to
follow the mindset of producing a long-term production quality application.

NOTE: This is still in migration and the XML and HTML encodings are not currently working.

NOTE: This is still in migration and the POST endpoints are not currently working.

## Build/Deployment Instructions

This section includes the instructions necessary to build and have the web service accepting requests and responding to them.

 - Clone this [git repository](https://github.com/wdsdhei/FibonacciService.git).
 - Execute the following:
    - `./gradlew clean bootRun`
 - Access the endpoint(s) with a web browser or CLI tool like `curl`:
    - `curl -iv http://localhost:8080/fibonacci`
    - `curl -iv http://localhost:8080/fibonacci/0`
    - `curl -iv http://localhost:8080/fibonacci/50`
    - `curl -iv http://localhost:8080/fibonacci/100`

## Further Reading

These pages all provided valuable information in my quest to create my first RESTful web-service.

 - http://tomee.apache.org/examples-trunk/rest-xml-json/README.html
 - http://vichargrave.com/restful-web-service-development-with-netbeans-and-tomcat-tutorial/
 - http://engineering.tango.me/post/25683784643/restful-services-with-json-xml-content
 - http://blog.webstarworks.com/2014/02/testing-the-jax-rs-restful-web-service
