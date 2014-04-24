FibonacciService
================
# Development Environment

This section describes how to create the development environment used for this project.

*NOTE:* All installation defaults were used unless otherwise noted.

*NOTE:* All other versions of these applications were un-installed prior to these versions being installed.
 
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
    - Select <i>Tools -> Java Platforms</i>
       - Click <code>Add Platform ...</code> and select the JDK 7 directory to add JDK 1.7 to the environment.
       - Click <code>Close</code>
