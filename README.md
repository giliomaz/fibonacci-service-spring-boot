#FibonacciService
A RESTful web service that:

 - Accepts a number, <code>n</code>, as input and returns the first <code>n</code> Fibonacci numbers, starting from 0.
   (i.e. given n = 5, the output would be the sequence "0 1 1 2 3")
 - The service returns the values as a String in a JSON document.
 - Given Zero or a negative number, it responds with an error String in the JSON document.
 - There are unit tests that assert the algorithm output is correct.
 - The upper boundary on the input is 93 since the 94 value causes an overflow of a 64-bit signed value.

While this project is admittedly trivial since it is my first attempt at a RESTful web service,
it was approached as if I would have to put it into production and maintain it for a significant period of time.

================

## Development Environment

This section describes how to create the development environment that was originally used for this project.

*NOTE:* All installation defaults were used unless otherwise noted.

*NOTE:* All other versions of these applications were un-installed prior to the stated version being installed.

*NOTE:* These instructions were performed on a fresh Ubuntu 14.04 LTS Desktop installation.

 - Install [JDK 7 u55](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).
    - Follow the instructions at: http://askubuntu.com/questions/56104
 - Install Apache Tomcat with TomEE
    - Follow the instructions at: http://tomee.apache.org/installation-drop-in-war.html
 - Install [NetBeans v8.0]("https://netbeans.org/downloads/").
    - Follow the instructions at: https://netbeans.org/community/releases/80/install.html
 - Add the JDK and TomEE to the NetBeans installation.
    - Start NetBeans.
    - Select menu <i>Tools -> Java Platforms</i>
       - Click <code>Add Platform ...</code>
       - Select the JDK 7 directory to add JDK 1.7 to the environment.
       - Click <code>Close</code>
    - Select menu <i>Tools -> Servers</i>
       - Click <code>Add Server ...</code>
       - Select Server type <code>Apache Tomcat or TomEE<code>.
       - Click <code>Next ></code>
       - For the Server Location enter the <code>CATALINA_HOME</code>.
       - Enter the Username/Password of an exisiting user with the <code>manager-script</code> role or check the box to create it.
       - Click <code>Finish</code>
       - Click <code>Close</code>

================

## Build/Deployment Instructions

This section includes the instructions necessary to build and have the web service accepting requests and responding to them.

*NOTE:* It is assumed the previously documented installation has already been performed.

 - Clone this [git repository](https://github.com/wdsdhei/FibonacciService.git).
 - Start NetBeans.
 - Open the project:
    - Select menu <i>File -> Open Project</i>
    - Navigate to the cloned directory.
    - Click <code>Open Project</code>.
 - Build
    - Right-Click on the project in the <i>Projects</i> tab.
    - In the pop-up menu Select <code>Clean and Bulid</code>.
    - In the <code>Output</code> tab a new tab titled <code>&lt;PROJ_NAME> (clean,dist)</code> will be opened.
    - When the text states <i>BUILD SUCCESSFUL</i> then the web service is ready to deploy.
 - Deploy the project:
    - Right-Click on the project in the <i>Projects</i> tab.
    - In the pop-up menu Select <code>Deploy</code>.
    - In the <code>Output</code> tab a new tab titled <code>&lt;PROJ_NAME> (run-deploy)</code> will be opened.
    - When the text states <i>BUILD SUCCESSFUL</i> then the web service is deployed and ready to accept requests.

*NOTE:* The pathing with respect to the server can be configured via the <code>&lt;PROJ_DIR>web/META-INF/context.xml</code> file.

*NOTE:* The internal pathing with respect to the service can be configured via the <code>@javax.ws.rs.ApplicationPath</code> annotation in the <code>ApplicationConfig.java</code> and <code>@Pathsource</code> annotation in the <code>&lt;PROJ_NAME>Service.java</code> source file.

