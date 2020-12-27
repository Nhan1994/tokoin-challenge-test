# Tokoin-challenge-test
This is test project for searching information from Tokoin 

#### Usage and run
This project is developed on Window machine so if you run this program on Windows, please make sure to install Java 8.
###### Run
There are some external library to run but no need to add manually, just run this command and it will auto include external lib

```
java -jar tokoin-challenge-test.jar
```
###### Test
```
java -cp tokoin-challenge-test.jar com.tokoin.test.TestRunner
```
#### Structure and workflow
This project is splitted into many module:

- src
	- main: program will be run from this class Main inside this package
	- model: store User, Organziation, Ticket class to store data from json file into object.
	- repository: store interface for get data
		- impl: repository implement to get data from json file
	- service: handle how data will be get and show on output
	- test: store unit test files and define data mock
	- utils: store some utility class that use in many places
- resources: 
	- data: store json file data
	json.properties: store path of json file

	
Workflow


