package kafka.kafkazookeeperconfig
import java.nio.file.Files

object KafkaZooKeeperExecution {

  def executeKafkaZookeeper = {
    val zooKeeperServerConf = new zooKeeperServerConfig()
    val zooKeeperServer = zooKeeperServerConf.ZooKeeperServer
    val zooKeeperThread = zooKeeperServerConf.createStartThread()
    val kafkaProperties = Map(
      ("zookeeper.connect", "localhost:2181"), //Zookeeper Connect storing broker metadata
      ("zookeeper.connection.timeout.ms","5000"),//Time to wait before going down
      ("broker.id", "1"), //Every broken in a cluster must have unique integer id
      ("port","9092"), //Set broker port
      ("delete.topic.enable","true"), //Enable delete topic
      ("log.dirs", Files.createTempDirectory("kafka-logs").toString))
    val kafkaServerConf = kafkaServerConfig(kafkaProperties)
    val kafkaServer = kafkaServerConf.createKafkaServer
    kafkaServer.startup()
    zooKeeperThread.join()
    kafkaServer.shutdown()
    kafkaServer.awaitShutdown()
    zooKeeperServer.stop()
  }

}
