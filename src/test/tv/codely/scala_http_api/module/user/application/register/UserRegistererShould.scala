package tv.codely.scala_http_api.module.user.application.register

import tv.codely.scala_http_api.module.UnitTestCase
import tv.codely.scala_http_api.module.shared.infrastructure.MessagePublisherMock
import tv.codely.scala_http_api.module.user.domain.{UserRegisteredStub, UserStub}
import tv.codely.scala_http_api.module.user.infrastructure.repository.UserRepositoryMock

final class UserRegistererShould extends UnitTestCase with UserRepositoryMock with MessagePublisherMock {
  private val registerer = new UserRegisterer(repository, messagePublisher)

  "save a user" in {
    val user           = UserStub.random
    val userRegistered = UserRegisteredStub(user)

    repositoryShouldSave(user)

    publisherShouldPublish(userRegistered)

    registerer.register(user.id, user.name) shouldBe (())
  }
}
