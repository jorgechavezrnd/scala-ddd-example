package tv.codely.scala_http_api.module.shared.infrastructure.message_broker.rabbitmq

import com.rabbitmq.client.MessageProperties
import tv.codely.scala_http_api.module.shared.domain.{Message, MessagePublisher}
import tv.codely.scala_http_api.module.shared.infrastructure.marshaller.MessageJsonFormatMarshaller.MessageMarshaller

final class RabbitMqMessagePublisher(channelFactory: RabbitMqChannelFactory) extends MessagePublisher {
  private val channel = channelFactory.channel

  // Use the default nameless exchange in order to route the published messages based don
  // the mapping between the message routing key and the queue names.
  // Example: A message with routing key "codelytv_scala_api.video_created"
  // will be routed to the "codelytv_scala_api.video_created" queue.
  private val exchange = ""

  private def createQueueIfNotExists(name: String): Unit = {
    val availableAfterRestart     = true
    val exclusiveToConnection     = false
    val deleteOnceMessageConsumed = false
    val arguments                 = null

    channel.queueDeclare(name, availableAfterRestart, exclusiveToConnection, deleteOnceMessageConsumed, arguments)
  }

  override def publish[T <: Message](message: T): Unit = {
    val routingKey    = message.`type`
    val messageJson   = MessageMarshaller.write(message)
    val messageBytes  = messageJson.toString.getBytes
    val persistToDisk = MessageProperties.PERSISTENT_TEXT_PLAIN

    createQueueIfNotExists(name = message.`type`)

    channel.basicPublish(exchange, routingKey, persistToDisk, messageBytes)
  }
}
