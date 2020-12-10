# Phone-Number-Classifier

# Run inside Docker container:

1- Open the terminal or console in the directory where the Dockerfile  exists.

2- type the following command to create an image on your machine:

	docker build -t taskhelpdemo .

Note: taskhelpdemo is a given name for the created image and could be any other name.

3- type the following command to run the container:
	 
	docker run -p 8080:8080 taskhelpdemo   

# Another way for running the application on your machine:

change the directory of the terminal or console to the place where the jar file exists then write this command:

	java -jar task-0.0.1-SNAPSHOT.jar

Requiremnts:
*JRE [15]
