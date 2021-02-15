# Scala DDD Example

[![License](https://img.shields.io/github/license/jorgechavezrnd/scala-ddd-example.svg?style=flat-square)](LICENSE)
[![Build Status](https://img.shields.io/travis/jorgechavezrnd/scala-ddd-example/master.svg?style=flat-square)](https://travis-ci.com/jorgechavezrnd/scala-ddd-example.svg?branch=master)
[![Coverage Status](https://img.shields.io/coveralls/github/jorgechavezrnd/scala-ddd-example/master.svg?style=flat-square)](https://coveralls.io/github/jorgechavezrnd/scala-ddd-example?branch=master)

## References
- Akka HTTP: https://doc.akka.io/docs/akka-http/current/introduction.html
- Template for generate this project: https://github.com/CodelyTV/scala-basic-skeleton.g8
- Scaladex: https://index.scala-lang.org/search?q=dependencies%3Aakka%2Fakka-http*
- HOCON (for configuration files in 'conf' folder): https://github.com/lightbend/config/blob/master/HOCON.md
- Scopt: https://github.com/scopt/scopt
- Doobie: https://github.com/tpolecat/doobie
- Try RabbitMQ: http://tryrabbitmq.com/
- SLF4J: http://www.slf4j.org/
- Logging with Logback in Scala: https://www.slideshare.net/knoldus/logging-with-logback-in-scala
- Logback configuration: https://logback.qos.ch/manual/configuration.html
- JSON logging for Spring applications: https://sadique.io/blog/2016/06/30/json-logging-for-spring-applications/
- Logback Logstash/JSON encoder: https://github.com/logstash/logstash-logback-encoder

## Command for create this project
- `sbt new codelytv/scala-basic-skeleton.g8` (Template URL: https://github.com/CodelyTV/scala-basic-skeleton.g8)
- Project name: Scala Http Api
- After open the project in Intellij, open a 'sbt shell' and run 't' command for run the tests

## Command for enter to sbt console
- `sbt`

## Command for run tests (in sbt console)
- `t`

## Command for all tasks before pushing to repository (in sbt console)
- `prep`

## Command for run server (in sbt console)
- `run`

## Command for reload sbt console
- `reload`

## Command for exit from sbt console
- `exit`

## Command for test server status from console
- `curl localhost:8080/status`

## Prepare the application evironment
1. Copy [the Docker environment variables config file](docker/.env.dist) and tune it with your desired values: `cp docker/.env.dist docker/.env`
2. Start Docker and bring up the project needed containers: `cd docker/; docker-compose up -d`
3. Create the database tables in your Docker MySQL container: `sbt createDbTables`

## Command example for run specifics tests
- `testOnly *DoobieMySqlUserRepositoryShould`

## URL for RabbitMQ Management
- http://localhost:8181

## Deploy
We use [SBT Native Packager](http://sbt-native-packager.readthedocs.io/en/latest/) in order to package the app in single Jar file that you can execute.

1. Create the universal package: `sbt universal:packageBin`.
2. Extract the generated zip: `unzip target/universal/codelytv-scala-http-api-1.0.zip -d ~/var/www/` which will contain:
    * `bin/`: All the executable binaries of our main classes in Unix and Windows (bat) format
    * `lib/`: All the project dependencies jar files.
3. Run the main app binary:
    * Without specifying any parameters (OK for this example app): `~/var/www/codelytv-scala-http-api-1.0/bin/scala-http-api`
    * Specifying parameters for the JVM: `~/var/www/codelytv-scala-http-api-1.0/bin/scala-http-api -Dconfig.resource=application/$CONFIG_PATH`
    * Specifying application parameters: `~/var/www/codelytv-scala-http-api-1.0/bin/scala-http-api -Dconfig.resource=application/$CONFIG_PATH -- -appParam`
