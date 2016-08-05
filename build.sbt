name := "scala-bdd"

version := "1.0"

scalaVersion := "2.11.7"

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-feature",
  "-Xlint",
  "-Xfatal-warnings"
)

val appDependencies = Seq(
  "com.codeborne" % "phantomjsdriver" % "1.2.1" % "test"
)


libraryDependencies ++= {
  Seq(
    "com.typesafe" %  "config" % "1.3.0",
    "org.scalatest" % "scalatest_2.11" % "2.2.6",
    "org.seleniumhq.selenium" % "selenium-java" % "2.52.0",
    "com.codeborne" % "phantomjsdriver" % "1.2.1"
  )
}

javaOptions += "-Dphantomjs.binary.path=/usr/local/bin/phantomjs -Dwebdriver.chrome.driver=drivers/chromedriver -Dwebdriver.gecko.driver=/usr/local/bin/wires"

