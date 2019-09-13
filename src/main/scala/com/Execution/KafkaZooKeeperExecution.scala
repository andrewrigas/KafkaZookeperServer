package com.Execution

import com.KafkaZookeeperConfig._
import com.KafkaZookeeperTools.{kafkaServerTool, zookeeperServerTool}
object KafkaZooKeeperExecution {

  def executeKafkaZookeeper = {
    //Zookeeper
    val zooKeeperServerConf = new zookeeperServerTool(
      ZookeeperServerConfig.PORT_VALUE,
      ZookeeperServerConfig.DATA_LOG_DIRECTORY_VALUE,
      ZookeeperServerConfig.DATA_DIRECTORY_VALUE,
      ZookeeperServerConfig.MAX_CLIENT_VALUE)

    val zooKeeperServer = zooKeeperServerConf.ZooKeeperServer

    val zooKeeperThread = zooKeeperServerConf.createStartThread()

    val kafkaProp0 = new KafkaServerProperties("0","kafka-logs-0","9092")
    val kafkaProp1 = new KafkaServerProperties("1","kafka-logs-1","9093")
    val kafkaProp2 = new KafkaServerProperties("2","kafka-logs-2","9094")

    val kafkaServer0 = kafkaServerTool.createKafkaServer(kafkaProp0.kafkaProperties)
    val kafkaServer1 = kafkaServerTool.createKafkaServer(kafkaProp1.kafkaProperties)
    val kafkaServer2 = kafkaServerTool.createKafkaServer(kafkaProp2.kafkaProperties)

    //Start Up Kafka Broker 0
    kafkaServer0.startup()
    //Start Up Kafka Broker 1
    kafkaServer1.startup()
    //Start Up Kafka Broker 2
    kafkaServer2.startup()
    //Join ZookeeperThread with kafka Server Thread
    zooKeeperThread.join()
    //KafkaServer shutdown
    kafkaServer0.shutdown()
    //KafkaServer shutdown
    kafkaServer1.shutdown()
    //KafkaServer shutdown
    kafkaServer2.shutdown()
    //Kafka Server 0 awaitShutdown Blocks until Broker shutdown
    kafkaServer0.awaitShutdown()
    //Kafka Server 1 awaitShutdown Blocks until Broker shutdown
    kafkaServer1.awaitShutdown()
    //Kafka Server 2 awaitShutdown Blocks until Broker shutdown
    kafkaServer2.awaitShutdown()
    //Zookeeper Server Stop
    zooKeeperServer.stop()
  }

}
