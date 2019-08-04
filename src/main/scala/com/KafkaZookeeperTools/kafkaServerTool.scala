package com.KafkaZookeeperTools

import java.util.Properties
import kafka.server.{KafkaConfig, KafkaServerStartable}

object kafkaServerTool {
  private def setKafkaConfig(properties: Map[String,String]): KafkaConfig = {
    val kafkaProperties = new Properties()
    for(tpl <- properties) kafkaProperties.put(tpl._1,tpl._2)
    KafkaConfig.fromProps(kafkaProperties)
  }

  def createKafkaServer(properties: Map[String,String]) = new KafkaServerStartable(setKafkaConfig(properties))
}
