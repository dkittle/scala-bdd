package ca.kittle.kijiji.pages

import bdd.util.SeleniumSupport
import ca.kittle.util.SeleniumShared
import org.scalatest.selenium.Page

class HomePage extends SeleniumSupport with Page {

  val url = conf.getString("app.baseUrl")
  val pageTitle = "Kijiji: Free Classifieds"
  val torontoPageTitle = "Kijiji: Free Classifieds in Toronto (GTA)"

  def clickFurniture() = {
    click on linkText("furniture")
  }

  def clickSignIn() = {
    click on id("SignInLink")
  }

  def login(username: String, password: String) = {
    textField(id("LoginEmailOrNickname")).value = username
    pwdField(id("login-password")).value = password
    click on id("SignInButton")
  }

}
