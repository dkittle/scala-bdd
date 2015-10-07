package ca.kittle.kijiji.pages

import ca.kittle.util.SeleniumShared
import org.scalatest.selenium.Page

class LocationPage extends Page with SeleniumShared {

  val url = baseUrl
  val pageTitle = "Kijiji"

  def checkForLocationMenu() = {
    find(id("LocationMenus"))
  }

  def clickOntarioMZ(): Boolean = {
    clickOnLinkByText("Ontario (M - Z)")
  }

  def clickTorontoGta(): Boolean = {
    clickOnLinkByText("Toronto (GTA)")
  }

  def clickGo(): Boolean = {
    clickOnLinkById("LocUpdate")
  }

 }
