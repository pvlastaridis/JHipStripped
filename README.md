Commit 1. STS Starter Spring Project
	
	Install STS in eclipse.
	Go to File -> New -> Project.
	Choose Spring -> Spring Starter Project
	Then Configure the following:
		Java Version 1.8
		Packaging war
		Group com.mycompany.myapp
		Artifact jhipstripped
		Package com.mycompany.myapp
		Dependencies Web

Commit 2. First Touch on STS Starter Project

	Add a professional .gitignore file (copy from jhipster sample app folder)
	Add a README.md file in root folder
	Alter POM to look more jhipster style and also add yaml and inject dependency so we can have yml properties and @Inject Annotation
	Rename Main Class and Servlet Initializer Class to match Jhipster's accordingly
	Add a resource class (A rest controller) so at the moment our app can speak to the world.\
	OK So far we have a rest controller in embedded Tomcat and we can alter its address.
	Logging in spring boot comes from starter POM spring-boot-starter-web.

Commit 3. Adding Logback

	Add to .gitignore another eclipse file .springBeans
	Add logback.xml and leave in there only loggers for the packages we have included so far.

Commit 4. Adding Cool Maven Plugins and Profiles

	In this commit we will add maven and spring profiles in order to have different logging levels.
	But First Let's add some interesting Maven plugins :
		1) Maven sort POM
			Used to sort and verify POM.xml files makes them easier to read and compare.
		2) Maven eclipse plugin 
			With the goal clean usefull to delete everything in target folder.
			Also to attach sources and Javadocs to eclipse libraries
		3) Maven enforcer plugin
			To check Java version and Maven version
		4) Maven surefire plugin
			To ensure that minimum memory pool for tests is -Xmx256m
			And also they run in an Alphabetical order to have reproducible results.
		5) Maven war plugin 
			To exclude packaging of Embedded Tomcat jars.
		6) Sonar maven plugin
			SonarCube is an open source platform for Continuous Inspection of code quality. The Maven Plugin triggers the code analyzers.
			You run mvn sonar:sonar but firstly you must run a sonar server in localhost:9000
		7) Spring boot maven plugin
			In order to pass jvm Arguments
				i) -Djava.rmi.server.hostname=localhost. Remote method invocation i.e. a JVM can call methods on other JVMs.
				ii) -Xdebug (Enables the application to be debugged).
					-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005 (Loads the reference implementation of the Java Debug 
						Wire Protocol, which enables remote debugging).
					These are Java Platform Debugger Architecture parameters
					JPDA makes possible Java programming language debugging tools to be easily written and used. 
				I AM GOING TO LEAVE OUT THE ABOVE STATEMENTS SINCE I CAN NOT SEE ANY USE OF THEM AT THE MOMENT.
			and a default profile
		8) In the plugin Management we override some of the M2Eclipse plugin settings more specifically we set what goals of other 
		plugins Eclipse is allowed to execute and which to ignore using the plugin lifecycle-mapping.

		After adding the cool stuff above let;s get different log levels depending on profile:
		1) In the build element of POM.xml we also declare which resources files to be included in the target/classes folder. All xml files filtered i.e. have their values of type ${...} calculated from properties files and all non xml files unfiltered.
		2) Also we add the property run.addResources which belongs to spring boot mvn plugin and it adds maven resources to the classpath directly, this allows live in-place editing of resources.
		3) In the Application and ApplicationWebXML classes we add profiles either from the System, Command Line

		Now we have three ways of altering the profiles:
		1) When running the war
		java -jar jhipster-0.0.1-SNAPSHOT.war --spring.profiles.active=prod
		2) Before creating a war or running the app
		mvn -Pprod package or mvn -Pdev spring-boot:run
		3) Add envinment variables on server
		-Dspring.profiles.active=prod to your JAVA_OPTS

Commit 5 Adding database support

		1) For Each Profile Add two different configurations (MySQL and H2). Only used JDBC Template, JPA will be added later.
		Two ways for pre-populating dbs BC Template execute.




