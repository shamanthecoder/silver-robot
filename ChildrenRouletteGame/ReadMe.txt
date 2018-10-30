Problem Statement:

n children stand around a circle.Starting with a given child and working clockwise, each child gets a sequential number, which we will refer to as it’s id. 
Then starting with the first child, they count out from 1 until k. The k’th child is now out and leaves the circle. The count starts again with the child immediately next to the eliminated one. Children are so removed from the circle one by one. The winner is the child left standing last.

Design:
The game intakes input from the user through standard input and outputs the winner on standard output.
The main logic of the game is linear iteration of the list and printing the sequence of exit of children and the final answer which will be the winner
The time complexity of the game is O(n).


Build:
The project is maven based project and can be built using mvn clean install from the src directory which will generate a jar with all the dependenices in target directiry which is executed as below.

Example:
Shamants-MacBook-Pro:ChildrenRouletteGame sammac$ java -jar target/ChildrenRouletteGame-0.0.1-SNAPSHOT-jar-with-dependencies.jar 
Enter value for n and k
10
3
Enter the child ID where the game should start. Value must be 0<childId<=n
1
Elimination order: 
Child3 with ID 3 is eliminated
Child6 with ID 6 is eliminated
Child9 with ID 9 is eliminated
Child2 with ID 2 is eliminated
Child7 with ID 7 is eliminated
Child1 with ID 1 is eliminated
Child8 with ID 8 is eliminated
Child5 with ID 5 is eliminated
Child10 with ID 10 is eliminated

The winner of the game is Child4 with ID 4

Tests: The tests are run as part of the main build and test various valid and invalid inputs to the game.





