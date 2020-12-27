# Tokoin-challenge-test
This is test project for searching information from Tokoin 

#### Usage and run
Please make sure your machine is installed Java 8 (jdk 8.0), to check if installed, use this command (Window/Linux)

```
java -version
```

###### Run
There are some external library to run but no need to add manually, just run this command and it will auto include external libs (Window/Linux), the command need to run in project folder

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
		├── main             # Contain config file
		├── model            # Contain data files
		├── service          # Models Layer: contain models
		├── repository       # Repositories Layer: contain interface and implement
		│   └── impl         # Repositories implement: handle get data from files
		├── test             # Contain schemas
		├── utils            # Business Logic Layer  
	  ├──resources           # Tests package: defaine testcases and implement unittest
		├── data			 #store json file data
		├── json.properties  # store path of json file

Workflow:

- Reposiroty will read json files by using util class, parse data and convert all json data into users, tickets and organizations model.
- Service layer will get data from repository and also get relative data based on which type of search, then return list of data in type of StringBuilder.
- We can search by filter directly on files (based on which type input), but it would be slow if doing stuff on physical files. Load all data into object then manipulate on it because object is stored on java heap, then would be faster.
## What haven't done good
- Test cases is not coverd much code because lack of test cases to create, need to update more.
- The output result show on the command line is not in good format, column of data is not in straight line so hard to view