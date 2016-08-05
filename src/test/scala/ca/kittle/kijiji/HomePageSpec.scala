package ca.kittle.kijiji

import bdd.util.SeleniumSupport
import ca.kittle.kijiji.pages.{HomePage, LocationPage}
import ca.kittle.kijiji.steps.HomePageSteps
import ca.kittle.util.{Configurator, SeleniumScalaTestSupport}


class HomePageSpec extends SeleniumSupport {

  val homePage = new HomePage
  val locationPage = new LocationPage

  info("Story: Hit Kijiji homepage and be prompted to select a location")

  go to homePage
  currentUrl should be (locationPage.url)
  pageTitle should include (locationPage.pageTitle)


  feature("Select your location"){
    scenario("Setting your location to Toronto/GTA should show Toronto listings"){
      Given("user navigates to the kijiji.ca website without a cookie")
      locationPage checkForLocationMenu()
      When("I click on Ontario M-Z")
      locationPage clickOntarioMZ()
      And("I click on Toronto/Gta")
      locationPage clickTorontoGta()
      And("I click on all Gta")
      locationPage clickAllGta()
      Then("")
      eventually {
        pageTitle should contain (homePage.torontoPageTitle)
      }
    }
  }


//  "foo" should "cheese" in {
//    homePage clickSignIn() should be (true)
//    eventually {
//      find(id("LoginEmailOrNickname")) should not be (None)
//    }
//    homePage.login(credentials._1, credentials._2) should be (true)
//
//    eventually {
//      find(className("user-name")).get.text should include (currentUser)
//    }
//  }

}
