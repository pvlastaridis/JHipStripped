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


