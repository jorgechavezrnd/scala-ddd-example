package tv.codely.scala_http_api.module.user.domain

object User {
  def apply(id: String, name: String): User = User(UserId(id), UserName(name))
}

case class User(id: UserId, name: UserName)
