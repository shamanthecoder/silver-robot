The application is a simulation of a toy robot moving on a square tabletop, of dimensions 5
units x 5 units.
There are no other obstructions on the table surface.
The robot is free to roam around the surface of the table, but must be prevented from
falling to destruction
Any movement that would result in the robot falling from the table must be prevented,
however further valid movement commands must still be allowed.
The application is written in Java and below are the build and run instructions for the app.

Build:-
mvn clean install
This will run the associated tests too along with the build.
A successful build will create a jar file in the target directory of the project named
"toy-jar-with-dependencies.jar".

This is an executable jar and can be executed using java -jar command in this way:

java -jar target/toy-jar-with-dependencies.jar

which will produce an output like below and has 2 ways of giving the input to the application.
e.g:
Shamants-MacBook-Pro:robotsimulation sammac$ java -jar target/toy-jar-with-dependencies.jar 
Enter the option for input type.Valid inputs are 1 or 2
1:Input file
2:Standard Input 

Option 1 will take input from an input file and option 2 will take it from standard input.
If option 1 is chosen then input the file name of the input file and the app will produce the output accordingly.

Command example:
Shamants-MacBook-Pro:robotsimulation sammac$ java -jar target/toy-jar-with-dependencies.jar 
Enter the option for input type.Valid inputs are 1 or 2
1:Input file
2:Standard Input
1
Please enter the input file name
inputFile.txt
Output: 4,4,NORTH
Output: 4,4,EAST

Here inputFile.txt is the input file and a sample file is part of the app for example.

Option 2 will be standard input from the console and will be as belwo:

Command example:

Shamants-MacBook-Pro:robotsimulation sammac$ java -jar target/toy-jar-with-dependencies.jar 
Enter the option for input type.Valid inputs are 1 or 2
1:Input file
2:Standard Input
2
Valid commands for Robot simualtion are
'PLACE X,Y,NORTH|SOUTH|EAST|WEST'
MOVE
LEFT
RIGHT
REPORT
Enter EXIT to end the simulation
PLACE 3,3,WEST
MOVE
LEFT
LEFT
RIGHT
MOVE
MOVE
REPORT
Output: 2,1,SOUTH
junkcommand
REPORT
Output: 2,1,SOUTH
RIGHT
REPORT
Output: 2,1,WEST
EXIT
 
The junit tests can be run using mvn clean install or mvn clean test.
The logs for the application is logged at logs/toyRobot.log where logs directory is located in the home directory of the application.
A small class diagram is also available in the application to give the class structure of the project.

 
