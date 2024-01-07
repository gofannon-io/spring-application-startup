# cli-app application

## About
This project is a demonstration of a Spring Boot web application with basic functionalities :
* Build & run documentation
* Single "fat" JAR generation
* Distribution creation
* Centralized logging
* Command line management
* Program exit code 

## Building the application
The full documentation is available in [BUILD.md](BUILD.md)

## Running the application

### Prerequisites
A JRE version 17 or higher shall be installed.
To check, run `java -version`.
For example
```shell
c:\users\me>java -version
openjdk version "21.0.1" 2023-10-17 LTS
OpenJDK Runtime Environment Zulu21.30+15-CA (build 21.0.1+12-LTS)
OpenJDK 64-Bit Server VM Zulu21.30+15-CA (build 21.0.1+12-LTS, mixed mode, sharing)
```

### Deploy the distribution
Unzip the ZIP distribution

For example on shell:
```shell
[...]\> unzip web-app-boot-0.0.1-SNAPSHOT.zip

[...]\> ls web-app-boot-0.0.1-SNAPSHOT/*/*
web-app-boot-0.0.1-SNAPSHOT/bin/web-app 
web-app-boot-0.0.1-SNAPSHOT/bin/web-app.bat
web-app-boot-0.0.1-SNAPSHOT/lib/web-app-0.0.1-SNAPSHOT.jar
```

### Run
There are two launchers in `bin` directory of the distribution.
* Use `web-app` launcher on Linux/Unit and MacOS.
* Use `web-app.bat` launcher on Windows.

```shell
[...]\web-app-boot-0.0.1-SNAPSHOT\>.\bin\web-app.bat 
```

### Call end-point
The base URL of all end-point is http://localhost:8080/web-app/.
To call the end-points, run an HTTP request like:
```shell
$ curl http://localhost:8080/web-app/star -H "Accept: application/json"
```

The response is something like:
```text
HTTP/1.1 200 
Content-Type: application/json
Content-Length: 34
Date: Sun, 07 Jan 2024 18:17:11 GMT
Keep-Alive: timeout=60
Connection: keep-alive

{
  "message": "Hello, world"
}
```


### Logging
The log file is available in `logs` directory of the distribution.
```text
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.2.1)


2024-01-07T15:55:18.076+01:00  INFO 11464 --- [main] i.g.a.cliapp.CliAppApplication           : Starting CliAppApplication using Java 21.0.1 with PID 11464 ([...]\web-app\build\distributions\web-app-boot-0.0.1-SNAPSHOT\lib\web-app-0.0.1-SNAPSHOT.jar started by me in [...]\web-app\build\distributions)
2024-01-07T15:55:18.077+01:00 DEBUG 11464 --- [main] i.g.a.cliapp.CliAppApplication           : Running with Spring Boot v3.2.1, Spring v6.1.2
2024-01-07T15:55:18.077+01:00  INFO 11464 --- [main] i.g.a.cliapp.CliAppApplication           : No active profile set, falling back to 1 default profile: "default"
2024-01-07T15:55:18.792+01:00  INFO 11464 --- [main] i.g.a.cliapp.CliAppApplication           : Started CliAppApplication in 1.418 seconds (process running for 2.077)
2024-01-07T15:55:18.797+01:00  INFO 11464 --- [main] i.g.a.cliapp.CliAppApplication           : Starting application
2024-01-07T15:55:18.797+01:00 DEBUG 11464 --- [main] i.g.a.cliapp.CliAppApplication           : Command line argument : star path/to/directory
2024-01-07T15:55:18.799+01:00  INFO 11464 --- [main] i.g.a.cliapp.CliAppApplication           : Work in progress on command STAR
2024-01-07T15:55:18.799+01:00  INFO 11464 --- [main] i.g.a.cliapp.CliAppApplication           : Exit application
```
