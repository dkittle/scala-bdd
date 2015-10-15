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
      case Some("dev") => ("don@kittle.ca", "foo")
      case Some("test") => ("don@kittle.ca", "foo")
      case Some("uat") => ("don@kittle.ca", "foo")
      case Some("prod") => ("don@kittle.ca", "foo")
      case _ => ("don@kittle.ca", "foo")
    }
  }

  private def selectDefaultUser(): String = {
    Option(System.getProperty("env")).map { _.toLowerCase } match {
      case Some("dev") => "dkittle"
      case Some("test") => "dkittle"
      case Some("uat") => "dkittle"
      case Some("prod") => "dkittle"
      case _ => "dkittle"
    }
  }

}
