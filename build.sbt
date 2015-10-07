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
    "org.slf4j" % "slf4j-api" % "1.6.4",
    "org.slf4j" % "jcl-over-slf4j" % "1.6.4",
    "org.slf4j" % "log4j-over-slf4j" % "1.6.4",
    "ch.qos.logback" % "logback-classic" % "1.0.13",
    "ch.qos.logback" % "logback-core" % "1.0.13",
    "org.slf4j" % "slf4j-api" % "1.6.4",
    "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
    "org.seleniumhq.selenium" % "selenium-java" % "2.46.0" % "test",
    "com.codeborne" % "phantomjsdriver" % "1.2.1" % "test",
    "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.4",
    "org.scala-lang" % "scala-reflect" % "2.11.7"
  )
}

javaOptions += "-Dphantomjs.binary.path=/usr/local/bin/phantomjs -Dwebdriver.chrome.driver=drivers/chromedriver"

