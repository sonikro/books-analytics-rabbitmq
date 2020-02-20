package br.com.sonikro.message

import com.rabbitmq.client.BuiltinExchangeType
import com.rabbitmq.client.Channel
import io.micronaut.configuration.rabbitmq.connect.ChannelInitializer
import javax.inject.Singleton

@Singleton
class ChannelPoolListener: ChannelInitializer() {
    override fun initialize(channel: Channel) {
        channel.exchangeDeclare("micronaut", BuiltinExchangeType.DIRECT, true)
        channel.queueDeclare("analytics", true, false, false, null)
        channel.queueBind("analytics", "micronaut", "analytics")
    }
}