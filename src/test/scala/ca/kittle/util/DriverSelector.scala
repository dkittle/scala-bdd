package ca.kittle.util

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.safari.SafariDriver
import org.scalatest.selenium.{InternetExplorer, Driver, WebBrowser}

trait DriverSelector extends WebBrowser with Driver {

  implicit val webDriver: WebDriver = DriverSelector.driver

}

object DriverSelector {
  val driver: WebDriver = selectDriver

  private def selectDriver(): WebDriver = {
    Option(System.getProperty("browser")).map { _.toLowerCase } match {
      case Some("chrome") => new ChromeDriver
      case Some("firefox") => new FirefoxDriver
      case Some("safari") => new SafariDriver
      case Some("ie") => new InternetExplorerDriver
      case _ => new PhantomJSDriver
    }
  }

}