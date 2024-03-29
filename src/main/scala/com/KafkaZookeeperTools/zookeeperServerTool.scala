package com.KafkaZookeeperTools

import java.net.InetSocketAddress
import java.nio.file.Files
import org.apache.zookeeper.server.{ServerConfig, ZooKeeperServerMain}
import org.apache.zookeeper.server.quorum.QuorumPeerConfig

class zookeeperServerTool(port: Int, dataLogDirectory: String, dataDirectory: String, maxClients: Int) {

  implicit val zooKeeperConfig: ServerConfig = new ServerConfig()
  zooKeeperConfig.readFrom(createQuorumConfiguration)

  //Extends ZookeeperServerMain Class
  class StoppableZooKeeperServerMain extends ZooKeeperServerMain {
    //Create stop function to shutdown Zookeeper in scala
    def stop(): Unit = shutdown()
  }

  //Create a Singleton Class zooKeeperServer
  object ZooKeeperServer extends StoppableZooKeeperServerMain

  //QuorumConfiguration Function
  private def createQuorumConfiguration = {
    new QuorumPeerConfig {
      override def getClientPortAddress: InetSocketAddress = new InetSocketAddress(port)

      override def getDataLogDir: String = Files.createTempDirectory(dataLogDirectory).toString

      override def getDataDir: String = Files.createTempDirectory(dataDirectory).toString

      override def getMaxClientCnxns: Int = maxClients
    }
  }

  private def createZookeeperThread(implicit serverConfiq: ServerConfig) = {
    new Thread {
      override def run(): Unit = ZooKeeperServer.runFromConfig(serverConfiq)
    }
  }

  private def startZookeeperThread(implicit kafkaThread: Thread) = kafkaThread.start()

  def createStartThread() = {
    implicit val kafkaThread = createZookeeperThread
    startZookeeperThread
    kafkaThread //return
  }

}
