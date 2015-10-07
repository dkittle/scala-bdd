package ca.kittle.util

trait Configurator {

  implicit val baseAppUrl = selectBaseUrl()
  implicit val credentials = selectCredentials()
  implicit val currentUser = selectDefaultUser()

  private def selectBaseUrl(): String = {
    Option(System.getProperty("env")).map { _.toLowerCase } match {
      case Some("dev") => "http://www.kijiji.ca/"
      case Some("test") => "http://www.kijiji.ca/"
      case Some("uat") => "http://www.kijiji.ca/"
      case Some("prod") => "http://www.kijiji.ca/"
      case _ => "http://www.kijiji.ca/"
    }
  }

  private def selectCredentials(): (String, String) = {
    Option(System.getProperty("env")).map { _.toLowerCase } match {
      case Some("dev") => ("testuser", "12345678")
      case Some("test") => ("testuser", "12345678")
      case Some("uat") => ("testuser", "12345678")
      case Some("prod") => ("donkittle", "nottelling")
      case _ => ("newuser", "12345678")
    }
  }

  private def selectDefaultUser(): String = {
    Option(System.getProperty("env")).map { _.toLowerCase } match {
      case Some("dev") => "Don Kittle"
      case Some("test") => "Don Kittle"
      case Some("uat") => "Don Kittle"
      case Some("prod") => "Don Kittle"
      case _ => "Don Kittle"
    }
  }

}
