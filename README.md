# Tokoin-challenge-test
This is test project for searching information from Tokoin 

#### Usage and run
Please make sure your machine is installed Java 8 (jdk 8.0), to check if installed, use this command (Window/Linux)

```
java -version
```

###### Run
There are some external library to run which is I already included in project so no need to add manually, 
just run this command and it will auto include external libs (Window/Linux), the command need to run in project folder.

```
java -jar tokoin-challenge-test.jar
```
###### Test
```
java -cp tokoin-challenge-test.jar com.tokoin.test.TestRunner
```
#### Structure and workflow
This project is splitted into many modules:

	  ├──src
		├── main             # This include main program to start running
		├── model            # Contain object class model to store value from json
		├── service          # This module is used to get data from repository to manipulate and output result 
		├── repository       # Repository Layer: contain interface and implement
		│   └── impl         # Repository implement: handle get data from files and data from field
		├── test             # Store unit test and also mock data test
		├── utils            # Contains some general util class to read json or print object 
	  ├──resources           
		├── data			 # Store json file data
		├── json.properties  # Store path of json file

Workflow:

- Repository will read json files by using util class, parse data and convert all json data into users, tickets and organizations model.
- Service layer will get data from repository and also get relative data based on which type of search, then return list of data in type of StringBuilder.
- We can search by filter directly on files (based on which type input), but it would be slow if doing stuff on physical files. Load all data into object then manipulate on it because object is stored on java heap, then would be faster.
#### What haven't done well
- Test cases is not covered much code because lack of test cases created, need to update more.
- The output result show on the command line is not in good format, column of data is not in straight line so hard to view.