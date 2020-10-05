package com.example.app

import com.typesafe.config.ConfigFactory
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json._
import org.scalatra.{CorsSupport, ScalatraServlet}
import org.slf4j.{Logger, LoggerFactory}
import scalaj.http.Http

object MyScalatraServlet {
  val accessToken: String = ConfigFactory.load().getString("token")
}

class MyScalatraServlet extends ScalatraServlet with JacksonJsonSupport with CorsSupport {
  protected implicit val jsonFormats: Formats = DefaultFormats

  import MyScalatraServlet.accessToken

  private final val LOG: Logger = LoggerFactory.getLogger(MyScalatraServlet.getClass)

  before() {
    contentType = formats("json")
  }

  get("/dummy/departures") {
    val s =
      """{
        |  "trainServices": [
        |    {
        |      "origin": [
        |        {
        |          "locationName": "High Wycombe",
        |          "crs": "HWY",
        |          "via": null,
        |          "futureChangeTo": null,
        |          "assocIsCancelled": false
        |        }
        |      ],
        |      "destination": [
        |        {
        |          "locationName": "London Marylebone",
        |          "crs": "MYB",
        |          "via": null,
        |          "futureChangeTo": null,
        |          "assocIsCancelled": false
        |        }
        |      ],
        |      "currentOrigins": null,
        |      "currentDestinations": null,
        |      "rsid": "CH170800",
        |      "sta": null,
        |      "eta": null,
        |      "std": "12:13",
        |      "etd": "On time",
        |      "platform": null,
        |      "operator": "Chiltern Railways",
        |      "operatorCode": "CH",
        |      "isCircularRoute": false,
        |      "isCancelled": false,
        |      "filterLocationCancelled": false,
        |      "serviceType": 0,
        |      "length": 0,
        |      "detachFront": false,
        |      "isReverseFormation": false,
        |      "cancelReason": null,
        |      "delayReason": null,
        |      "serviceID": "WMo9Bl6lklHJJwDcd8eJsQ==",
        |      "serviceIdPercentEncoded": "MYB",
        |      "serviceIdGuid": "063dca58-a55e-5192-c927-00dc77c789b1",
        |      "serviceIdUrlSafe": "WMo9Bl6lklHJJwDcd8eJsQ",
        |      "adhocAlerts": null
        |    },
        |        {
        |      "origin": [
        |        {
        |          "locationName": "London Marylebone",
        |          "crs": "HWY",
        |          "via": null,
        |          "futureChangeTo": null,
        |          "assocIsCancelled": false
        |        }
        |      ],
        |      "destination": [
        |        {
        |          "locationName": "High Wycombe",
        |          "crs": "HWC",
        |          "via": null,
        |          "futureChangeTo": null,
        |          "assocIsCancelled": false
        |        }
        |      ],
        |      "currentOrigins": null,
        |      "currentDestinations": null,
        |      "rsid": "CH170800",
        |      "sta": null,
        |      "eta": null,
        |      "std": "12:13",
        |      "etd": "On time",
        |      "platform": null,
        |      "operator": "Chiltern Railways",
        |      "operatorCode": "CH",
        |      "isCircularRoute": false,
        |      "isCancelled": false,
        |      "filterLocationCancelled": false,
        |      "serviceType": 0,
        |      "length": 0,
        |      "detachFront": false,
        |      "isReverseFormation": false,
        |      "cancelReason": null,
        |      "delayReason": null,
        |      "serviceID": "WMo9Bl6lklHJJwDcd8eJsQ==",
        |      "serviceIdPercentEncoded": "HWY",
        |      "serviceIdGuid": "063dca58-a55e-5192-c927-00dc77c789b1",
        |      "serviceIdUrlSafe": "WMo9Bl6lklHJJwDcd8eJsQ",
        |      "adhocAlerts": null
        |    }],
        |  "busServices": null,
        |  "ferryServices": null,
        |  "generatedAt": "2019-12-08T11:55:34.1052519+00:00",
        |  "locationName": "Gerrards Cross",
        |  "crs": "GER",
        |  "filterLocationName": null,
        |  "filtercrs": null,
        |  "filterType": 0,
        |  "nrccMessages": null,
        |  "platformAvailable": true,
        |  "areServicesAvailable": true
        |}""".stripMargin
    s
  }

  get("/empty/departures") {
    val s =
      """{
        |  "trainServices": [],
        |  "busServices": null,
        |  "ferryServices": null,
        |  "generatedAt": "2019-12-08T11:55:34.1052519+00:00",
        |  "locationName": "Gerrards Cross",
        |  "crs": "GER",
        |  "filterLocationName": null,
        |  "filtercrs": null,
        |  "filterType": 0,
        |  "nrccMessages": null,
        |  "platformAvailable": true,
        |  "areServicesAvailable": true
        |}""".stripMargin
    s
  }

  get("/dummy/service/:id") {
    val id: String = params("id")
    id match {
      case "HWY" =>
        """{
          |  "rsid": "CH162500",
          |  "generatedAt": "2019-12-08T11:57:51.9950156+00:00",
          |  "serviceType": 0,
          |  "locationName": "Gerrards Cross",
          |  "crs": "GER",
          |  "operator": "Chiltern Railways",
          |  "operatorCode": "CH",
          |  "isCancelled": false,
          |  "cancelReason": null,
          |  "delayReason": null,
          |  "overdueMessage": null,
          |  "length": 0,
          |  "detachFront": false,
          |  "isReverseFormation": false,
          |  "platform": null,
          |  "sta": "13:02",
          |  "eta": "On time",
          |  "ata": null,
          |  "std": "13:02",
          |  "etd": "On time",
          |  "atd": null,
          |  "adhocAlerts": null,
          |  "previousCallingPoints": [
          |    {
          |      "callingPoint": [
          |        {
          |          "locationName": "London Marylebone",
          |          "crs": "MYB",
          |          "st": "12:43",
          |          "et": "On time",
          |          "at": null,
          |          "isCancelled": false,
          |          "length": 0,
          |          "detachFront": false,
          |          "adhocAlerts": null
          |        }
          |      ],
          |      "serviceType": 0,
          |      "serviceChangeRequired": false,
          |      "assocIsCancelled": false
          |    }
          |  ],
          |  "subsequentCallingPoints": [
          |    {
          |      "callingPoint": [
          |        {
          |          "locationName": "Beaconsfield",
          |          "crs": "BCF",
          |          "st": "13:08",
          |          "et": "On time",
          |          "at": null,
          |          "isCancelled": false,
          |          "length": 0,
          |          "detachFront": false,
          |          "adhocAlerts": null
          |        },
          |        {
          |          "locationName": "High Wycombe",
          |          "crs": "HWY",
          |          "st": "13:13",
          |          "et": "On time",
          |          "at": null,
          |          "isCancelled": false,
          |          "length": 0,
          |          "detachFront": false,
          |          "adhocAlerts": null
          |        },
          |        {
          |          "locationName": "Saunderton",
          |          "crs": "SDR",
          |          "st": "13:20",
          |          "et": "On time",
          |          "at": null,
          |          "isCancelled": false,
          |          "length": 0,
          |          "detachFront": false,
          |          "adhocAlerts": null
          |        },
          |        {
          |          "locationName": "Princes Risborough",
          |          "crs": "PRR",
          |          "st": "13:25",
          |          "et": "On time",
          |          "at": null,
          |          "isCancelled": false,
          |          "length": 0,
          |          "detachFront": false,
          |          "adhocAlerts": null
          |        },
          |        {
          |          "locationName": "Haddenham & Thame Parkway",
          |          "crs": "HDM",
          |          "st": "13:32",
          |          "et": "On time",
          |          "at": null,
          |          "isCancelled": false,
          |          "length": 0,
          |          "detachFront": false,
          |          "adhocAlerts": null
          |        },
          |        {
          |          "locationName": "Bicester North",
          |          "crs": "BCS",
          |          "st": "13:45",
          |          "et": "On time",
          |          "at": null,
          |          "isCancelled": false,
          |          "length": 0,
          |          "detachFront": false,
          |          "adhocAlerts": null
          |        },
          |        {
          |          "locationName": "Kings Sutton",
          |          "crs": "KGS",
          |          "st": "13:57",
          |          "et": "On time",
          |          "at": null,
          |          "isCancelled": false,
          |          "length": 0,
          |          "detachFront": false,
          |          "adhocAlerts": null
          |        },
          |        {
          |          "locationName": "Banbury",
          |          "crs": "BAN",
          |          "st": "14:03",
          |          "et": "On time",
          |          "at": null,
          |          "isCancelled": false,
          |          "length": 0,
          |          "detachFront": false,
          |          "adhocAlerts": null
          |        }
          |      ],
          |      "serviceType": 0,
          |      "serviceChangeRequired": false,
          |      "assocIsCancelled": false
          |    }
          |  ]
          |}""".stripMargin
      case "MYB" =>
        """{
          |  "rsid": "CH170800",
          |  "generatedAt": "2019-12-08T11:57:51.5128998+00:00",
          |  "serviceType": 0,
          |  "locationName": "Gerrards Cross",
          |  "crs": "GER",
          |  "operator": "Chiltern Railways",
          |  "operatorCode": "CH",
          |  "isCancelled": false,
          |  "cancelReason": null,
          |  "delayReason": null,
          |  "overdueMessage": null,
          |  "length": 0,
          |  "detachFront": false,
          |  "isReverseFormation": false,
          |  "platform": null,
          |  "sta": "12:13",
          |  "eta": "On time",
          |  "ata": null,
          |  "std": "12:13",
          |  "etd": "On time",
          |  "atd": null,
          |  "adhocAlerts": null,
          |  "previousCallingPoints": [
          |    {
          |      "callingPoint": [
          |        {
          |          "locationName": "High Wycombe",
          |          "crs": "HWY",
          |          "st": "11:59",
          |          "et": "On time",
          |          "at": null,
          |          "isCancelled": false,
          |          "length": 0,
          |          "detachFront": false,
          |          "adhocAlerts": null
          |        },
          |        {
          |          "locationName": "Beaconsfield",
          |          "crs": "BCF",
          |          "st": "12:06",
          |          "et": "On time",
          |          "at": null,
          |          "isCancelled": false,
          |          "length": 0,
          |          "detachFront": false,
          |          "adhocAlerts": null
          |        },
          |        {
          |          "locationName": "Seer Green",
          |          "crs": "SRG",
          |          "st": "12:09",
          |          "et": "On time",
          |          "at": null,
          |          "isCancelled": false,
          |          "length": 0,
          |          "detachFront": false,
          |          "adhocAlerts": null
          |        }
          |      ],
          |      "serviceType": 0,
          |      "serviceChangeRequired": false,
          |      "assocIsCancelled": false
          |    }
          |  ],
          |  "subsequentCallingPoints": [
          |    {
          |      "callingPoint": [
          |        {
          |          "locationName": "Denham Golf Club",
          |          "crs": "DGC",
          |          "st": "12:17",
          |          "et": "On time",
          |          "at": null,
          |          "isCancelled": false,
          |          "length": 0,
          |          "detachFront": false,
          |          "adhocAlerts": null
          |        },
          |        {
          |          "locationName": "Denham",
          |          "crs": "DNM",
          |          "st": "12:19",
          |          "et": "On time",
          |          "at": null,
          |          "isCancelled": false,
          |          "length": 0,
          |          "detachFront": false,
          |          "adhocAlerts": null
          |        },
          |        {
          |          "locationName": "West Ruislip",
          |          "crs": "WRU",
          |          "st": "12:24",
          |          "et": "On time",
          |          "at": null,
          |          "isCancelled": false,
          |          "length": 0,
          |          "detachFront": false,
          |          "adhocAlerts": null
          |        },
          |        {
          |          "locationName": "South Ruislip",
          |          "crs": "SRU",
          |          "st": "12:36",
          |          "et": "On time",
          |          "at": null,
          |          "isCancelled": false,
          |          "length": 0,
          |          "detachFront": false,
          |          "adhocAlerts": null
          |        },
          |        {
          |          "locationName": "Northolt Park",
          |          "crs": "NLT",
          |          "st": "12:39",
          |          "et": "On time",
          |          "at": null,
          |          "isCancelled": false,
          |          "length": 0,
          |          "detachFront": false,
          |          "adhocAlerts": null
          |        },
          |        {
          |          "locationName": "Wembley Stadium",
          |          "crs": "WCX",
          |          "st": "12:44",
          |          "et": "On time",
          |          "at": null,
          |          "isCancelled": false,
          |          "length": 0,
          |          "detachFront": false,
          |          "adhocAlerts": null
          |        },
          |        {
          |          "locationName": "London Marylebone",
          |          "crs": "MYB",
          |          "st": "13:00",
          |          "et": "On time",
          |          "at": null,
          |          "isCancelled": false,
          |          "length": 0,
          |          "detachFront": false,
          |          "adhocAlerts": null
          |        }
          |      ],
          |      "serviceType": 0,
          |      "serviceChangeRequired": false,
          |      "assocIsCancelled": false
          |    }
          |  ]
          |}""".stripMargin
      case _ =>
        """"""
    }
  }

  get("/departures/:station") {
    val id: String = params("station")
    val url = s"https://huxley.apphb.com/departures/$id/200?accessToken=$accessToken"
    LOG.info(s"Hit: '$url'")
    val response = Http(url).asString.body
    LOG.debug(response)
    response
  }

  get("/service/:id") {
    val id: String = params("id")
    val url = s"https://huxley.apphb.com/service/$id?accessToken=$accessToken"
    LOG.info(s"Hit: '$url'")
    val response = Http(url).asString.body
    LOG.info(response)
    response
  }
}
