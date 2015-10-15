package ca.kittle.kijiji.pages

import ca.kittle.util.SeleniumShared
import org.scalatest.selenium.Page

class HomePage extends Page with SeleniumShared {

  val url = baseAppUrl
  val pageTitle = "Kijiji: Free Classifieds in Toronto (GTA)"

  def clickFurniture(): Boolean = {
    clickOnLinkByText("furniture")
  }

  def clickSignIn(): Boolean = {
    clickOnLinkById("SignInLink")
  }

  def login(username: String, password: String): Boolean = {
    textField(id("LoginEmailOrNickname")).value = username
    pwdField(id("login-password")).value = password
    clickOnLinkById("SignInButton")
  }

}
