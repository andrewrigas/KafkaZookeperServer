package com.KafkaZookeeperConfig

import java.nio.file.Files

object KafkaServerConfig {

  //Keys
  val ZOOKEEPER_CONNECT_CONFIG = "zookeeper.connect"
  val ZOOKEEPER_CONNECTION_TIMEOUT_MS_CONFIG = "zookeeper.connection.timeout.ms"
  val BROKER_ID_CONFIG = "broker.id"
  val PORT_CONFIG = "port"
  val DELETE_TOPIC_ENABLE_CONFIG = "delete.topic.enable"
  val LOG_DIR_CONFIG = "log.dirs"

  //Values
  val ZOOKEEPER_CONNECT_VALUE = "localhost:2181"
  val ZOOKEEPER_CONNECTION_TIMEOUT_MS_VALUE = "5000"
  val BROKER_ID_VALUE = "1"
  val PORT_VALUE = "9092"
  val DELETE_TOPIC_ENABLE_VALUE = "true"
  val LOG_DIR_VALUE = Files.createTempDirectory("kafka-logs").toString
}
