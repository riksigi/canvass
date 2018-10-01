# READ ME 

## How to Build ?
I have used java to code and maven to build the jars provided in the target directory.Please ensure you also have java(check by typing java -version)  and maven(check by typing mvn -version) installed in your system if you want to build it yourself .In case you dont have java and maven , please directly use the challenge-0.0.1-SNAPSHOT-jar-with-dependencies.jar provided in the target directory to run the application.  

The command to build it yourself is :   
**mvn clean package**  
This command compiles and builds the jar with all dependencies. It also runs all the 7 basic unit test cases that I have provided for challenge 1 and challenge 2 ensuring nothing is broken in case future features are added.  
Here's a screenshot of it in my Mac :
![alt text](https://github.com/riksigi/challenge/blob/3da9b7f2d27642284f26a381b626685e97fcc172/screenshots/build.png)

### How to run Challenge 1 ?
**java -cp path_to_challenge-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.canvass.challenge.Challenge1**  

Example :
java -cp ./target/challenge-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.canvass.challenge.Challenge1  
Here's a screenshot of it in my Mac :
![alt text](https://github.com/riksigi/challenge/blob/master/screenshots/runChallenge1.png)

### How to run Challenge 2 ?

**java -cp path_to_challenge-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.canvass.challenge.Challenge2 path_to_input csv file**  

You can also increase the memory size (if the default memory is too low) with java flags like -Xms4G  

Example of running challenge 2 with small data set :  

java -cp ./target/challenge-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.canvass.challenge.Challenge2 ./src/main/resources/random_data.csv  

Here's a screenshot of it in my Mac :
![alt text](https://github.com/riksigi/challenge/blob/master/screenshots/runChallenge2WithSmallDataSet.png)

Example of running challenge 2 with large data set :  

java -cp ./target/challenge-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.canvass.challenge.Challenge2 ../large_data.csv  

Here's a screenshot of it in my Mac :
![alt text](https://github.com/riksigi/challenge/blob/master/screenshots/runChallenge2WithLargeDataSet.png)


## A paragraph or two about what you are particularly proud of in your implementation ?
I really like the fact that I have kept the code modular,seperated it out into different classes and everything is very structured in git.
The code is present in src/main/java/com/canvass/challenge/, Junit test cases present in src/test/java/com/canvass/challenge/, jars present in target and dependencies present in pom.xml.
The JUnit test cases provided  also helps to test the core functionality of each class making sure nothing gets broken in case something is added in future(regression testing).For challenge 1 , I have kept the approach simple seperating work into various functions.For challenge 2 , the external sort is present in a seperate class and the custom row comparator in a seperate class. This makes it easy to add more functionality/features,debug etc. 
Overall its a single jar file with different driver classes for each challenge.


## Any significant design decisions and why ?
### Challenge 1 :
I have kept the design  pretty simple and straight forward. Since 1000 to 3000 is a small range, I have just iterated it over a loop and checked for each digit in each number.This is the simplest approach . It had occured in my mind to have another approach where I keep an array of even digits from 0 to 9 ([ 0 2 4 6 8 ]) and then build all possible 4 digit numbers using recursion with memorization from this array having the first digit fixed as 2(since the first digit should lie between 1 and 3).However this approach isn't as simple as the first one and the memory utilization with recursion will be larger hence I stuck with the first approach.

### Challenge 2 :
Here since the sorting needs to be implemented for both small data set as well as large data set , it wont be possible to use traditional sorting algorithms like QuickSort . Because the size of data will be much more than what the main memory can fit, hence we will get out of memory exception pretty soon with traditional sorting algorithms. To solve this issue, we need to use the External sort algorithm, so that we can read the data in batches from the file to memory,sort it in memory , write it to temporary files and then merge all the temporary files .To make sure that the data is sorted first with deviceId and then with date I have provided a seperate custom row comparator class which can be modified if the sorting order needs to be changed. 
The Junit Test Classes mainly tests these scenarios(apart from what is handled in the code) : 
1) if 2 rows are sorted first by device id
2) if 2 rows are sorted by date if device id is same
3) if the row with blank date field(same device id) is placed first which is what I have assumed
4) if the date format of two rows are in different format(yyyy-MM-dd,mm/dd/yy)
5) if 2 rows have different device ids and their dates are in different formats

