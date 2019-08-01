name := "KafkaStreaming"

version := "0.1"

scalaVersion := "2.11.8"

val sparkVersion = "2.0.0"

// https://mvnrepository.com/artifact/org.apache.kafka/kafka
libraryDependencies += "org.apache.kafka" %% "kafka" % "2.0.0"

// https://mvnrepository.com/artifact/org.apache.zookeeper/zookeeper
libraryDependencies += "org.apache.zookeeper" % "zookeeper" % "3.4.5" pomOnly()

// https://mvnrepository.com/artifact/org.apache.avro/avro
libraryDependencies += "org.apache.avro" % "avro" % "1.8.1"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.3" % Runtime