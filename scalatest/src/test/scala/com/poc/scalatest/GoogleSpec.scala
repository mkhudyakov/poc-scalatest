package com.poc.scalatest

import org.openqa.selenium.WebDriver
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.scalatest.selenium.WebBrowser
import org.scalatest.{ShouldMatchers, FlatSpec}

/**
 * Using Selenium - http://www.scalatest.org/user_guide/using_selenium
 */
class GoogleSpec extends FlatSpec with ShouldMatchers with WebBrowser {

  implicit val webDriver: WebDriver = new HtmlUnitDriver

  val host = "https://www.google.com.ua/"

  "The Google Home Page" should "have the correct title" in {
    go to host
    pageTitle should be ("Google")
  }
}
