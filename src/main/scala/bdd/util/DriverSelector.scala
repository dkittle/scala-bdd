package bdd.util

import java.net.URL

import com.typesafe.config.Config
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.remote.{RemoteWebDriver, DesiredCapabilities}
import org.openqa.selenium.safari.SafariDriver
import org.openqa.selenium.{Dimension, Point, WebDriver}
import org.scalatest.selenium.{Driver, WebBrowser}

trait DriverSelector extends WebBrowser {

  implicit val webDriver: WebDriver = DriverSelector.driver
  implicit val conf: Config = Configurator.configFile

}

object DriverSelector {

  lazy val driver: WebDriver = createDriver

  private def createDriver: WebDriver = {
    val driver = selectDriver
    setupDriver
    driver
  }

  private def selectDriver: WebDriver = {
    def myChromeDriver: WebDriver = {
      val options = new ChromeOptions()
      options.addArguments("start-maximized")
      val capabilities = DesiredCapabilities.chrome()
      capabilities.setCapability(ChromeOptions.CAPABILITY, options)
      new ChromeDriver(capabilities)
    }

    def myFirefoxDriver: WebDriver = {
      val capabilities = DesiredCapabilities.firefox()
      capabilities.setCapability("marionette", true)
      new FirefoxDriver(capabilities)
    }

    def myRemoteDriver: WebDriver = {
      val caps = DesiredCapabilities.chrome()
      caps.setCapability("browserstack.debug", "true")
      caps.setCapability("os", "OS X")
      caps.setCapability("os_version", "Yosemite")
      caps.setCapability("resolution", "1280x960")
      val u = Configurator.configFile.getString("remote.url")
      new RemoteWebDriver(new URL(u), caps)
    }

    Option(System.getProperty("browser")).map { _.toLowerCase } match {
      case Some("phantomjs") => new PhantomJSDriver
      case Some("chrome") => myChromeDriver
      case Some("firefox") => myFirefoxDriver
      case Some("safari") => new SafariDriver
      case Some("remote") => myRemoteDriver
      case Some("ie") => new InternetExplorerDriver
      case _ => myFirefoxDriver
    }
  }

  private def setupDriver() = {
    if (System.getProperty("demo") == true) {
      driver.manage().window().setSize(new Dimension(1680, 1050))
      driver.manage().window().maximize()
      driver.manage().window().setPosition(new Point(0, 0))
    }
  }

}

