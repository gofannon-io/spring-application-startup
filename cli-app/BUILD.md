# Building cli-app

## Prerequisites

### Java Development Kit 17 or higher
The build of the application requires a JDK version 17 or higher to be correctly installed.
To check, run `java -version`.
For example
```shell
c:\users\me>java -version
openjdk version "21.0.1" 2023-10-17 LTS
OpenJDK Runtime Environment Zulu21.30+15-CA (build 21.0.1+12-LTS)
OpenJDK 64-Bit Server VM Zulu21.30+15-CA (build 21.0.1+12-LTS, mixed mode, sharing)
```

### Gradle access
Gradle is the application used to build the cli-app application.

A bootstrap is available among the sources in `gradle/wrapper` directory.
This bootstrap requires a web access to download the full Gradle application. 

By default, the download URL is `https://services.gradle.org/distributions/gradle-8.4-bin.zip`.

When this URL is not accessible directly, but by a proxy, read the _Networking with Gradle_ documentation [EL2].

Otherwise, it is possible to override the address by using the `gradlew` command located in root project directory.
For example:
```shell
[...]\cli-app>./gradlew wrapper --gradle-distribution-url https\://proxy.mycompany.com/services.gradle.org/distributions/gradle-8.4-bin.zip
```

For more information, read the _Gradle Wrapper Reference_ documentation [EL3].


### Artifact repository access
Some artifact repositories are  used to store the dependencies used to build the application.
If the repositories are accessible via a proxy read the _Networking with Gradle_ documentation [EL2].
Otherwise, the repositories shall be changed in `build.gradle` and `settings.gradle` files by reading _Declaring repositories_ documentation [EL4].



## Building
To build the application from the source code, run the following command from the root project directory.
```shell
cli-app>gradlew assembleBootDist
```

It generates a ZIP file containing the full distribution of the application in `build\distributions` directory:
```shell
cli-app> dir /w build\distributions

 Répertoire de cli-app\build\distributions

cli-app-boot-0.0.1-SNAPSHOT.tar cli-app-boot-0.0.1-SNAPSHOT.zip
```


## External links
* [EL1] [Gradle User Manual](https://docs.gradle.org/current/userguide/about_manual.html)
* [EL2] [Networking with Gradle](https://docs.gradle.org/current/userguide/networking.html#sec:accessing_the_web_via_a_proxy)
* [EL3] [Gradle Wrapper Reference](https://docs.gradle.org/current/userguide/gradle_wrapper.html#gradle_wrapper)
* [EL4] [Gradle Declaring repositories](https://docs.gradle.org/current/userguide/declaring_repositories.html)
