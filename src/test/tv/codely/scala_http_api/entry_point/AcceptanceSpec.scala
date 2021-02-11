package tv.codely.scala_http_api.entry_point

import akka.http.scaladsl.model._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import akka.util.ByteString
import com.typesafe.config.ConfigFactory
import org.scalatest.{Matchers, WordSpec}
import org.scalatest.concurrent.ScalaFutures
import tv.codely.scala_http_api.module.course.infrastructure.dependency_injection.CourseModuleDependencyContainer
import tv.codely.scala_http_api.module.shared.infrastructure.config.{DbConfig, MessageBrokerConfig}
import tv.codely.scala_http_api.module.shared.infrastructure.dependency_injection.SharedModuleDependencyContainer
import tv.codely.scala_http_api.module.shared.infrastructure.persistence.doobie.DoobieDbConnection
import tv.codely.scala_http_api.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer
import tv.codely.scala_http_api.module.video.infrastructure.dependency_injection.VideoModuleDependencyContainer

protected[entry_point] abstract class AcceptanceSpec
    extends WordSpec
    with Matchers
    with ScalaFutures
    with ScalatestRouteTest {
  private val actorSystemName = "scala-http-api-acceptance-test"

  private val appConfig       = ConfigFactory.load("application")
  private val dbConfig        = DbConfig(appConfig.getConfig("database"))
  private val publisherConfig = MessageBrokerConfig(appConfig.getConfig("message-publisher"))

  private val sharedDependencies = new SharedModuleDependencyContainer(actorSystemName, dbConfig, publisherConfig)

  protected val userDependencies = new UserModuleDependencyContainer(
    sharedDependencies.doobieDbConnection,
    sharedDependencies.messagePublisher
  )
  protected val videoDependencies = new VideoModuleDependencyContainer(
    sharedDependencies.doobieDbConnection,
    sharedDependencies.messagePublisher
  )(sharedDependencies.executionContext)

  protected val courseDependencies = new CourseModuleDependencyContainer(
    sharedDependencies.doobieDbConnection,
    sharedDependencies.messagePublisher
  )

  private val routes = new Routes(
    new EntryPointDependencyContainer(userDependencies, videoDependencies, courseDependencies))

  protected val doobieDbConnection: DoobieDbConnection = sharedDependencies.doobieDbConnection

  def posting[T](path: String, request: String)(body: ⇒ T): T =
    HttpRequest(
      method = HttpMethods.POST,
      uri = path,
      entity = HttpEntity(
        MediaTypes.`application/json`,
        ByteString(request)
      )
    ) ~> routes.all ~> check(body)

  def getting[T](path: String)(body: ⇒ T): T = Get(path) ~> routes.all ~> check(body)
}
