# Scala DDD Example

[![License](https://img.shields.io/github/license/jorgechavezrnd/scala-ddd-example.svg?style=flat-square)](LICENSE)
[![Build Status](https://img.shields.io/travis/jorgechavezrnd/scala-ddd-example/master.svg?style=flat-square)](https://travis-ci.com/jorgechavezrnd/scala-ddd-example.svg?branch=master)
[![Coverage Status](https://img.shields.io/coveralls/github/jorgechavezrnd/scala-ddd-example/master.svg?style=flat-square)](https://coveralls.io/github/jorgechavezrnd/scala-ddd-example?branch=master)

## References
- Akka HTTP: https://doc.akka.io/docs/akka-http/current/introduction.html
- Template for generate this project: https://github.com/CodelyTV/scala-basic-skeleton.g8
- Scaladex: https://index.scala-lang.org/search?q=dependencies%3Aakka%2Fakka-http*
- HOCON (for configuration files in 'conf' folder): https://github.com/lightbend/config/blob/master/HOCON.md

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
