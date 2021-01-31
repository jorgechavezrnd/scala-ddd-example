package tv.codely.scala_http_api.module.user.domain

import tv.codely.scala_http_api.module.shared.domain.UuidStub

import java.util.UUID

object UserIdStub {
  def apply(value: String): UserId = UserIdStub(UuidStub(value))

  def apply(value: UUID): UserId = UserId(value)

  def random: UserId = UserId(UuidStub.random)
}
