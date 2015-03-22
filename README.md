Commit 1.
	
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

Commit 2.

	Add a professional .gitignore file (copy from jhipster sample app folder)
	Add a README.md file in root folder
	Alter POM to look more jhipster style and also add yaml and inject dependency so we can have yml properties and @Inject Annotation
	Rename Main Class and Servlet Initializer Class to match Jhipster's accordingly
	Add a resource class (A rest controller) so at the moment our app can speak to the world.\
	OK So far we have a rest controller in embedded Tomcat and we can alter its address.
	Logging in spring boot comes from starter POM spring-boot-starter-web.

Commit 3.

	Add to .gitignore another eclipse file .springBeans
	Add logback.xml and leave in there only loggers for the packages we have included so far.


