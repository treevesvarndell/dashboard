package com.example.app

import org.scalatra.test.scalatest._

class MyScalatraServletTests extends ScalatraFunSuite {

  addServlet(classOf[MyScalatraServlet], "/*")

  test("GET endpoints should return 200") {
    get("/departures") {
      status should equal (200)
    }

    get("/arrivals") {
      status should equal (200)
    }
  }

}
