package com.example.app

import com.typesafe.config.ConfigFactory
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json._
import org.scalatra.{CorsSupport, ScalatraServlet}
import scalaj.http.Http

object MyScalatraServlet {
  val accessToken: String = ConfigFactory.load().getString("token")
}

class MyScalatraServlet extends ScalatraServlet with JacksonJsonSupport with CorsSupport {
  protected implicit val jsonFormats: Formats = DefaultFormats
  import MyScalatraServlet.accessToken

  before() {
    contentType = formats("json")
  }

  get("/departures") {
    Http(s"https://huxley.apphb.com/departures/GER/100?accessToken=${accessToken}").asString.body
  }

  get("/arrivals") {
    Http(s"https://huxley.apphb.com/arrivals/MYB/100?accessToken=${accessToken}").asString.body
  }
}
