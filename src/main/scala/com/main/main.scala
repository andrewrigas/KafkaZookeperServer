package com.main

import com.Execution.KafkaZooKeeperExecution

import scala.concurrent.Future
import scala.concurrent.ExecutionContext
import ExecutionContext.Implicits.global

object main extends App{
  KafkaZooKeeperExecution.executeKafkaZookeeper

}
