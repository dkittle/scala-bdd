package ca.kittle.kijiji

import ca.kittle.kijiji.pages.{LocationPage, HomePage}
import ca.kittle.kijiji.steps.HomePageSteps
import ca.kittle.util.{Configurator, SeleniumScalaTestSupport}


class HomePageSpec extends SeleniumScalaTestSupport with Configurator {

  val homePage = new HomePage
  val locationPage = new LocationPage
  val homePageSteps = new HomePageSteps(homePage, locationPage)

  "Navigating to homepage with no location cookie" should "redirect to the location page" in {
    go to homePage
    currentUrl should be (locationPage.url)
    pageTitle should include (locationPage.pageTitle)
  }

  "Picking Toronto GTA" should "display homepage with Toronto/GTA set as location" in {
    homePageSteps chooseGTALocation()
  }

  "foo" should "cheese" in {
    homePage clickSignIn() should be (true)
    eventually {
      find(id("LoginEmailOrNickname")) should not be (None)
    }
    homePage.login(credentials._1, credentials._2) should be (true)

    eventually {
      find(className("user-name")).get.text should include (currentUser)
    }
  }

}
