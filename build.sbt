val ScalatraVersion = "2.6.4"

organization := "com.reevcom"

name := "Dashboard Server"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.12.6"

mainClass := Some("com.example.JettyLauncher")

resolvers += Classpaths.typesafeReleases

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra" % ScalatraVersion,
  "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "test",
  "com.typesafe" % "config" % "1.3.2",
  "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime",
  "org.eclipse.jetty" % "jetty-webapp" % "9.4.9.v20180320" % "container;compile",
  "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
  "org.scalaj" %% "scalaj-http" % "2.4.1",
  "org.scalatra" %% "scalatra-json" % ScalatraVersion,
  "org.json4s" %% "json4s-jackson" % "3.5.2",
)

enablePlugins(SbtTwirl)
enablePlugins(ScalatraPlugin)
