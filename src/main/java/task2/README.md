## How to run

1. Navigate to the project root directory.
2. Compile the Java code:  
   `javac -d out src/main/java/util/*.java src/main/java/task2/Task2App.java`
3. Run the application:  
   `java -cp out task2.Task2App`


## Task2

Again, the input is a long list of integers. Provide a working code that will find all the pairs (in this integer list) that sum up to 13. Each pair in the output should have first number not greater than the second one and lines should be sorted in an ascending order.

Sample:  

For the input:  
1 2 10 7 5 3 6 6 13 0  

expected output is:  
0 13  
3 10  
6 7  
6 7  