package tv.codely.scala_http_api.module.user.infrastructure.dependency_injection

import tv.codely.scala_http_api.module.shared.infrastructure.persistence.doobie.DoobieDbConnection
import tv.codely.scala_http_api.module.user.application.search.UsersSearcher
import tv.codely.scala_http_api.module.user.infrastructure.repository.DoobieMySqlUserRepository

import scala.concurrent.ExecutionContext

final class UserModuleDependencyContainer(
    doobieDbConnection: DoobieDbConnection
)(implicit executionContext: ExecutionContext) {
  val repository = new DoobieMySqlUserRepository(doobieDbConnection)

  val usersSearcher = new UsersSearcher(repository)
}
