package tv.codely.scala_http_api.module.shared.infrastructure.message_broker.rabbitmq

import tv.codely.scala_http_api.module.shared.domain.Message

trait MessageConsumer {
  def startConsuming(handler: Message => Boolean): Unit
  def hasMessagesToConsume: Boolean
  def isEmpty: Boolean = !hasMessagesToConsume
}
