FibonacciService
================
# Development Environment
This section describes how to create the development environment used for this project.
*NOTE:* All installation defaults were used unless otherwise noted.
*NOTE:* All other versions of these applications were un-installed prior to these versions being installed.
 - Install [JDK 7 u55](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).
    - Create/Update the ```JAVA_HOME``` user environment variable with the ```<JDK_DIR>```
       - IF <code>%JAVA_HOME%\bin</code> is not already part of the <code>DEV_PATH</code> user environment variable, THEN add it.</li>
       - Open the Java Control Panel by selecting <i>Start -> Control Panel -> Java</i></li>
       - In the JCP <i>Advanced</i> tab, Un-Check the <i>Miscellaneous -> Java Quick Starter</i> box.</li>
       - Click <code>OK</code></li>
    - Install [JDK 7 u55 docs](http://download.oracle.com/otn-pub/java/jdk/7u55-b13/jdk-7u55-apidocs.zip).
 - Install Apache Tomcat with TomEE following the instructions at: http://tomee.apache.org/installation-drop-in-war.html
    - Download [TomEE Supported Tomcat](http://archive.apache.org/dist/tomcat/tomcat-7/v7.0.42/bin/apache-tomcat-7.0.42.tar.gz)
    - Decompress/Extract:
       - ```tar xvfz apache-tomcat-7.0.42.tar.gz```
    - Download [TomEE Drop-in WAR](http://www.eng.lsu.edu/mirrors/apache/tomee/tomee-1.6.0.1/tomee-plus-webapp-1.6.0.1.war)
    - Copy the TomEE Drop-in WAR to the correct location with the correct name:
       - ```cp tomee-plus-webapp-1.6.0.1.war $CATALINA_HOME/webapps/tomee.war```
 - Install [NetBeans v8.0]("https://netbeans.org/downloads/").
    - Create/Update the ```NB_HOME``` user environment variable with the ```<NB_DIR>```.
    - Create/Update the ```ANT_HOME``` user environment variable with the ```%NB_HOME%\java\ant```.
    - IF ```%ANT_HOME%\bin``` is not already part of the ```DEV_PATH``` user environment variable, THEN add it.
    - Start the NetBeans IDE.
    - Select _Tools -> Java Platforms_
       - Click ```Add Platform ...``` and select the JDK 7 directory to add JDK 1.7 to the environment.
       - Click ```Close```
