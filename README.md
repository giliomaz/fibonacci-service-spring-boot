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
 
 - Install [JDK 7 u55](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).
    - Create/Update the <code>JAVA_HOME</code> user environment variable with the <code>&lt;JDK_DIR></code>
       - IF <code>%JAVA_HOME%\bin</code> is not already part of the <code>DEV_PATH</code> user environment variable, THEN add it.
       - Open the Java Control Panel by selecting <i>Start -> Control Panel -> Java</i>
       - In the JCP <i>Advanced</i> tab, Un-Check the <i>Miscellaneous -> Java Quick Starter</i> box.
       - Click <code>OK</code>
    - Install [JDK 7 u55 docs](http://download.oracle.com/otn-pub/java/jdk/7u55-b13/jdk-7u55-apidocs.zip).
 - Install Apache Tomcat with TomEE following the instructions at:
    - http://tomee.apache.org/installation-drop-in-war.html
    - Download [TomEE Supported Tomcat](http://archive.apache.org/dist/tomcat/tomcat-7/v7.0.42/bin/apache-tomcat-7.0.42.tar.gz)
    - Decompress/Extract:
       - <code>tar xvfz apache-tomcat-7.0.42.tar.gz</code>
    - Download [TomEE Drop-in WAR](http://www.eng.lsu.edu/mirrors/apache/tomee/tomee-1.6.0.1/tomee-plus-webapp-1.6.0.1.war)
    - Copy the TomEE Drop-in WAR to the correct location with the correct name:
       - <code>cp tomee-plus-webapp-1.6.0.1.war $CATALINA_HOME/webapps/tomee.war</code>
 - Install [NetBeans v8.0]("https://netbeans.org/downloads/").
    - Create/Update the <code>NB_HOME</code> user environment variable with the <code>&lt;NB_DIR></code>.
    - Create/Update the <code>ANT_HOME</code> user environment variable with the <code>%NB_HOME%\java\ant</code>.
    - IF <code>%ANT_HOME%\bin</code> is not already part of the <code>DEV_PATH</code> user environment variable, THEN add it.
    - Start the NetBeans IDE.
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
