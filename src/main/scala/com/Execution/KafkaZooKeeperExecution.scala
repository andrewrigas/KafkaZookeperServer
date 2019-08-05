package com.Execution

import com.KafkaZookeeperTools.{kafkaServerTool, zookeeperServerTool}
import com.KafkaZookeeperConfig._

object KafkaZooKeeperExecution {

  def executeKafkaZookeeper = {
    //Zookeeper
    val zooKeeperServerConf = new zookeeperServerTool(
      ZookeeperServerConfig.PORT_VALUE,
      ZookeeperServerConfig.DATA_LOG_DIRECTORY_VALUE,
      ZookeeperServerConfig.DATA_DIRECTORY_VALUE)

    val zooKeeperServer = zooKeeperServerConf.ZooKeeperServer

    val zooKeeperThread = zooKeeperServerConf.createStartThread()


    //Kafka
    val kafkaProperties = Map(
      KafkaServerConfig.ZOOKEEPER_CONNECT_CONFIG -> KafkaServerConfig.ZOOKEEPER_CONNECT_VALUE,
      KafkaServerConfig.BROKER_ID_CONFIG -> KafkaServerConfig.BROKER_ID_VALUE,
      KafkaServerConfig.DELETE_TOPIC_ENABLE_CONFIG -> KafkaServerConfig.DELETE_TOPIC_ENABLE_VALUE,
      KafkaServerConfig.LOG_DIR_CONFIG -> KafkaServerConfig.LOG_DIR_VALUE,
      KafkaServerConfig.PORT_CONFIG -> KafkaServerConfig.PORT_VALUE,
      KafkaServerConfig.ZOOKEEPER_CONNECTION_TIMEOUT_MS_CONFIG -> KafkaServerConfig.ZOOKEEPER_CONNECTION_TIMEOUT_MS_VALUE
    )
    val kafkaServer = kafkaServerTool.createKafkaServer(kafkaProperties)

    //Start Up Kafka
    kafkaServer.startup()
    //Join ZookeeperThread with kafka Server Thread
    zooKeeperThread.join()
    //KafkaServer shutdown
    //kafkaServer.shutdown()
    //Kafka Server awaitShutdown Blocks until Broker shutdown
    //kafkaServer.awaitShutdown()
    //Zookeeper Server Stop
    //zooKeeperServer.stop()
  }

}
