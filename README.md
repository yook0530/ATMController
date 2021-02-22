# ATMController

ATMController

## Requirements

For building and running the application you need:

- [JDK 11] https://www.oracle.com/java/technologies/javase-jdk11-downloads.html
- [Gradle] 

## Test
- JUnit 5

### Gradle
```
./gradlew test
```

### IntelliJ

1) Set Project SDK
- Project Structure(Cmd + ;) -> Project Settings -> Project -> Project SDK (set Java 11)

2) Gradle JVM Setting
- Preferences(Cmd + ,) -> Build, Excecution... -> Build Tools -> Gradle -> Gradle projects -> Gradle JVM (set Java 11)

3) Per-module ByteCode Version
- Preferences -> Build, Excecution... -> Compiler -> Per-module bytecode version (set Java 11)

4) Edit Configuration
- Create Configuration > JUnit 
[![ReadMe.png](https://i.postimg.cc/Wbv1TDJm/ReadMe.png)](https://postimg.cc/5jsVm2gj)

5)
```
src > test > java > ATMController > ATMControllerImpltest > Run Test
```
