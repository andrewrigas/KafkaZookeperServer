package kafka.kafkazookeeperconfig

import java.util.Properties
import kafka.server.{KafkaConfig, KafkaServerStartable}

case class kafkaServerConfig(properties: Map[String,String]) {

  private def setKafkaConfig = {
    val kafkaProperties = new Properties()
    for(tpl <- properties) kafkaProperties.put(tpl._1,tpl._2)
    KafkaConfig.fromProps(kafkaProperties)
  }

  def createKafkaServer = new KafkaServerStartable(setKafkaConfig)
}
