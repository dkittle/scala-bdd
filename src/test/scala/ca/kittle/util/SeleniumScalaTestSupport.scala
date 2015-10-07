package ca.kittle.util

import org.scalatest.{BeforeAndAfterAll, Matchers, FlatSpec}
import org.scalatest.concurrent.{IntegrationPatience, Eventually}

trait SeleniumScalaTestSupport extends FlatSpec with DriverSelector with Configurator with Eventually with Matchers with
IntegrationPatience with BeforeAndAfterAll {

  override def afterAll {
    quit()
  }

}
