package com.KafkaZookeeperConfig

import java.nio.file.Files

object KafkaServerConfig {

  //Config
  val ZOOKEEPER_CONNECT_CONFIG = "zookeeper.connect"
  val ZOOKEEPER_CONNECTION_TIMEOUT_MS_CONFIG = "zookeeper.connection.timeout.ms"
  val BROKER_ID_CONFIG = "broker.id"
  val PORT_CONFIG = "port"
  val DELETE_TOPIC_ENABLE_CONFIG = "delete.topic.enable"
  val LOG_DIR_CONFIG = "log.dirs" //comma separated list of directories under which to store log files
  val NUM_NETWORK_THREADS_CONFIG = "num.network.threads" //number of threads that the server uses for receiving requests from the network and sending responses to the network
  val NUM_IO_THREADS_CONFIG = "num.io.threads" // number of threads that the server uses for processing requests, which may include disk I/O
  val SOCKET_SEND_BUFFER_BYTES_CONFIG = "socket.send.buffer.bytes" // send buffer (SO_SNDBUF) used by the socket server
  val SOCKET_RECEIVE_BUFFER_BYTES_CONFIG = "socket.receive.buffer.bytes"// receive buffer (SO_RCVBUF) used by the socket server
  val SOCKET_REQUEST_MAX_BYTES_CONFIG = "socket.request.max.bytes"// maximum size of a request that the socket server will accept (protection against OOM)
  val NUM_PARTITIONS_CONFIG = "num.partitions"//More partitions allow greater parallelism for consumption, but this will also result in more files across the brokers.
  val NUM_RECOVERY_THREADS_PER_DATA_DIR_CONFIG = "num.recovery.threads.per.data.dir"//The number of threads per data directory to be used for log recovery at startup and flushing at shutdown
  //the replication factor for the group metadata internal topics "__consumer_offsets" and "__transaction_state"
  //For anything other than development testing, a value greater than 1 is recommended for to ensure availability such as 3.
  val OFFSETS_TOPIC_REPLICATION_FACTOR_CONFIG = "offsets.topic.replication.factor"
  val TRANSACTION_STATE_LOG_REPLICATION_FACTOR_CONFIG = "transaction.state.log.replication.factor"
  val TRANSACTION_STATE_LOG_MIN_ISR_CONFIG = "transaction.state.log.min.isr"
  //Control the flush of data to disk
  val LOG_FLUSH_INTERVAL_MESSAGES_CONFIG = "log.flush.interval.messages"//The number of messages to accept before forcing a flush of data to disk
  val LOG_FLUSH_INTERVAL_MS_CONFIG = "log.flush.interval.ms"//The maximum amount of time a message can sit in a log before we force a flush
  //Control the disposal of log segments
  val LOG_RETENTION_HOURS_CONFIG = "log.retention.hours" //The minimum age of a log file to be eligible for deletion due to age
  val LOG_RETENTION_BYTES_CONFIG = "log.retention.bytes" //A size-based retention policy for logs
  val LOG_SEGMENT_BYTES_CONFIG = "log.segment.bytes" //The maximum size of a log segment file. When this size is reached a new log segment will be created.
  val LOG_RETENTION_CHECK_INTERVAL_MS_CONFIG = "log.retention.check.interval.ms" //The interval at which log segments are checked to see if they can be deleted according to the retention policies
  val GROUP_INITIAL_REBALANCE_DELAY_MS_CONFIG = "group.initial.rebalance.delay.ms" //the rebalance will be further delayed when new members join the group, up to a maximum of max.poll.interval.ms.


  //Values
  val ZOOKEEPER_CONNECT_VALUE = "localhost:2181"
  val ZOOKEEPER_CONNECTION_TIMEOUT_MS_VALUE = "6000"
  val BROKER_ID_VALUE = "1"
  val PORT_VALUE = "9092"
  val DELETE_TOPIC_ENABLE_VALUE = "true"
  val LOG_DIR_VALUE = Files.createTempDirectory("kafka-logs").toString
  val NUM_NETWORK_THREADS_VALUE = "3"
  val NUM_IO_THREADS_VALUE = "8"
  val SOCKET_SEND_BUFFER_BYTES_VALUE = "102400"
  val SOCKET_RECEIVE_BUFFER_BYTES_VALUE = "102400"
  val SOCKET_REQUEST_MAX_BYTES_VALUE = "104857600"
  val NUM_PARTITIONS_VALUE = "1"
  val NUM_RECOVERY_THREADS_PER_DATA_DIR_VALUE = "1"
  val OFFSETS_TOPIC_REPLICATION_FACTOR_VALUE = "1"
  val TRANSACTION_STATE_LOG_REPLICATION_FACTOR_VALUE = "1"
  val TRANSACTION_STATE_LOG_MIN_ISR_VALUE = "1"
  val LOG_FLUSH_INTERVAL_MESSAGES_VALUE = "10000"
  val LOG_FLUSH_INTERVAL_MS_VALUE = "1000"
  val LOG_RETENTION_HOURS_VALUE = "168"
  val LOG_RETENTION_BYTES_VALUE = "1073741824"
  val LOG_SEGMENT_BYTES_VALUE = "1073741824"
  val LOG_RETENTION_CHECK_INTERVAL_MS_VALUE = "300000"
  val GROUP_INITIAL_REBALANCE_DELAY_MS_VALUE = "0%"



}
