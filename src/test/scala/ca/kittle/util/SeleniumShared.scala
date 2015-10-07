package ca.kittle.util

import org.scalatest.selenium.Page

trait SeleniumShared extends Page with DriverSelector with Configurator {

  def clickOnLinkByText(text: String): Boolean = find(linkText(text)).map(_ => click on linkText(text)).isDefined

  def clickOnLinkById(text: String): Boolean = find(id(text)).map (_ => click on id(text)).isDefined

}
