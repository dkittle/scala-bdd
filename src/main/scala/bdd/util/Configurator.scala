package bdd.util

import com.typesafe.config.ConfigFactory
import com.typesafe.config.Config

object Configurator {

  lazy val configFile = readConfigFile

  def readConfigFile = ConfigFactory.load(
    Option(System.getProperty("config-resource")).getOrElse("local.application.conf"))

}
