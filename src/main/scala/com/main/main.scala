package com.main

import kafka.kafkazookeeperconfig.KafkaZooKeeperExecution

import scala.concurrent.Future
import scala.concurrent.ExecutionContext
import ExecutionContext.Implicits.global

object main extends App{

  Future {
    KafkaZooKeeperExecution.executeKafkaZookeeper
  }



}
