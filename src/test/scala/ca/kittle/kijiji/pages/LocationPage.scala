package ca.kittle.kijiji.pages

import bdd.util.SeleniumSupport
import ca.kittle.util.SeleniumShared
import org.scalatest.selenium.Page

class LocationPage extends SeleniumSupport with Page {

  val url = conf.getString("app.baseUrl")
  val pageTitle = "Kijiji"

  def checkForLocationMenu() = {
    find(id("LocationMenus"))
  }

  def clickOntarioMZ() = {
    click on linkText("Ontario (M - Z)")
  }

  def clickTorontoGta() = {
    click on linkText("Toronto (GTA)")
  }

  def clickAllGta() = {
    click on linkText("All of Toronto (GTA)")
  }

 }
