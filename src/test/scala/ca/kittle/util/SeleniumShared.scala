package ca.kittle.util

import org.scalatest.selenium.Page

trait SeleniumShared extends Page with DriverSelector with Configurator {

  def clickOnLinkByText(text: String): Boolean = {
    Option(find(linkText(text)))  match {
      case None => false
      case _ => click on linkText(text); true
    }
  }

  def clickOnLinkById(text: String): Boolean = {
    Option(find(id(text)))  match {
      case None => false
      case _ => click on id(text); true
    }
  }

}
