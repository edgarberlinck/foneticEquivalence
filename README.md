# Fonetic Equivalence

Software to find if two or more words are fonetically equivalent. 

# Building

### Pre-Requisites

* Download and Install Java SE 8 and make sure to add the Java Home directory to your system path
* Download Apache Maven, extract it and add _\/place\/where\/you\/extracted\/maven\/bin _to your system path.

## Making the executable jar

After install Java SE and Maven you just need open you terminal window and access the source code folder. If you want to know if you are on the right path, just look for a file called _pom.xml_. And call maven install:

`mvn install`

Remember that you can download the latest version [here. ](https://github.com/edgarberlinck/foneticEquivalence/blob/master/build/latest/foneticEquivalence.jar)Older releases are available [here](https://github.com/edgarberlinck/foneticEquivalence/tree/master/build).

## Using

First of all, you have to create a dictionary file. This file must be a simple text file and each word should be place on it\`s own line. If you want to put the words: angel, brave, Braev, Don, Engel, go, goal, son, sunny, Tom and Tooonnnnyyyy to your dictionary you should create a text file and place each of those words on it. You disctioary file must look like this:

> angel
> 
> brave
> 
> Braev
> 
> Don
> 
> Engel
> 
> go
> 
> goal
> 
> son
> 
> sunny
> 
> Tom
> 
> Tooonnnnyyyy

Just call the appliation using java -jar command and pass the words wich you what to test the fonetic equivalence against the dictionary words. If you want to test the words 1tom\#, brief and soon against the dictionary placed on \/home\/user\/dictionary.txt just call the jar file using: 

`java -jar foneticEquivalence.jar 1tom# brief, soon /home/user/dictionary.txt`

The result shoud apear on your terminal window in just a few seconds.



