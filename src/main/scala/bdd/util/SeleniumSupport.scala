package bdd.util

import com.typesafe.config.Config
import org.scalatest._
import org.scalatest.concurrent.{IntegrationPatience, Eventually}

trait SeleniumSupport extends FeatureSpec with GivenWhenThen with Suite with Eventually with
  IntegrationPatience with BeforeAndAfterAll with Matchers with DriverSelector {

  override def afterAll {
    quit()
  }

  override def beforeAll {

  }

}
