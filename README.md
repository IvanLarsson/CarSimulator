# CarSimulator

A very simple car simulator, used as a test. 

### IDE
The IDE used for this project was Intellij IDEA

It can also be imported to Eclipse if needed. There are .project and .classpath files included for such an occasion

### Jar file
There is a included .jar file in out/artifacts/hiq_cargame_jar/

To run it 
```sh
$ cd out/artifacts/hiq_cargame_jar/
$ java -jar hiq_cargame.jar
```

### The flow of the program 
Just follow the instructions on screen and everything will just be fine. 

When inputting commands for how to move the car try to end with the command 
`'I'` this is for printing the current status for the car. This function was 
added in order to give the program a better flow (no need to restart the 
program if you want to redo the simulation). There are also a few other 
commands.

### Comments
Was not really sure on how to present the data when the car crashes, 
so what I did was, I just print the last "known" (before crashing) position of 
the car and a small text to indicate that the car has crashed 