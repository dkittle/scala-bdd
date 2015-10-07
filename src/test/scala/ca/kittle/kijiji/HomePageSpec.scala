package ca.kittle.kijiji

import ca.kittle.kijiji.pages.{LocationPage, HomePage}
import ca.kittle.util.SeleniumScalaTestSupport


class HomePageSpec extends SeleniumScalaTestSupport {

  val homePage = new HomePage
  val locationPage = new LocationPage
  
  "Navigating to homepage with no location cookie" should "redirect to the location page" in {
    go to homePage
    currentUrl should be (locationPage.url)
    pageTitle should include (locationPage.pageTitle)
  }

  "Picking Toronto GTA" should "display homepage with Toronto/GTA set as location" in {
    go to homePage

    locationPage checkForLocationMenu() should not be None
    locationPage clickOntarioMZ() should be (true)
    locationPage clickTorontoGta() should be (true)
    locationPage clickGo() should be (true)

    eventually {
      pageTitle should include (homePage.pageTitle)
    }
  }

}
