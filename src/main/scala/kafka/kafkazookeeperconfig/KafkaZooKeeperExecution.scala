package kafka.kafkazookeeperconfig
import java.nio.file.Files

object KafkaZooKeeperExecution {

  def executeKafkaZookeeper = {
    val zooKeeperServerConf = new zooKeeperServerConfig()
    val zooKeeperServer = zooKeeperServerConf.ZooKeeperServer
    val zooKeeperThread = zooKeeperServerConf.createStartThread()
    val kafkaProperties = Map(("zookeeper.connect", "localhost:2181"),("broker.id", "1"),("log.dirs", Files.createTempDirectory("kafka-logs").toString))
    val kafkaServerConf = kafkaServerConfig(kafkaProperties)
    val kafkaServer = kafkaServerConf.createKafkaServer
    kafkaServer.startup()
    zooKeeperThread.join()
    kafkaServer.shutdown()
    kafkaServer.awaitShutdown()
    zooKeeperServer.stop()
  }

}
