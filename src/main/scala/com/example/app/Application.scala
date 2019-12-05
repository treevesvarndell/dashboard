package com.example.app

// remember this package in the sbt project definition
import com.typesafe.config.ConfigFactory
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.webapp.WebAppContext
import org.scalatra.servlet.ScalatraListener

import scala.util.Try

object Application {
  def main(args: Array[String]) {
    val port: Int = Try(ConfigFactory.load().getInt("port")).getOrElse(8080)

    val server = new Server(port)
    val context = new WebAppContext()
    context setContextPath "/"
    context.setResourceBase("src/main/webapp")
    context.addEventListener(new ScalatraListener)
    context.addServlet(classOf[MyScalatraServlet], "/")

    server.setHandler(context)

    server.start()
    server.join()
  }
}