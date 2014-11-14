package com.poc.scalatest

import java.io.File

import org.scalatest.{Matchers, FlatSpec}

/**
 * Matchers is a trait that provides a domain specific language (DSL) for expressing assertions in tests
 * using the word <code>should</code>.
 *
 * http://www.scalatest.org/user_guide/using_matchers#checkingEqualityWithMatchers
 */
class MatchersSpec extends FlatSpec with Matchers {

  "Result" should "be something..." in {
    3 should be (3)
    3 shouldBe 3
  }

  /* Checking size and length */
  "Result" should "have length of 11" in {
    val result = List(1, 2, 3, 4, 5)
    result should have size 5
    result should have length 5
  }

  /* Checking strings */
  "Result" must "start with..." in {
    val result = "This is a simple test"
    result should startWith ("This")
    result should endWith ("test")
    result should include ("simple")

    /* Using Regex */
    result should startWith regex "Th.s"
    result should fullyMatch regex "(.*)".r
  }

  /* Greater and less than */
  "Result" should "correspond to the equality expression" in {
    1 should be < 7
    1 should be > 0
    1 should be <= 7
    1 should be >= 0
  }

  /* Checking Boolean properties with be */
  "TempFile" should "be a file" in {
    val result = new File(".")
    result should be a 'directory
  }

  /* Checking object identity */
  "A" should "be the same as B" in {
    val a = Array()
    val b = a
    a should be theSameInstanceAs b
  }

  /* Checking an object's class */
  "values" should "be of Array type" in {
    val values = Array[String]()

    values shouldBe an [Array[String]]
    values shouldBe a [Array[String]]
  }

  /* Checking numbers against a range */
  "5.5" should "be in the range" in {
    val num = 5.5

    num should be (5.3 +- 0.3)
    num shouldNot be (5.3 +- 0.1)
  }

  /* Working with "containers" */
  "Array" should "contain B" in {
    val a = Array("B", "C")
    a should contain ("B")

    /* Or even something like this */
    Array("Doe", "Ray", "Me") should contain oneOf ("X", "Ray", "BEAM")
  }

  /* Logical expressions with and and or */
  "Map" should "contain two and not contain 7" in {
    val map = Map("two" -> 2, "ten" -> 10)
    map should (contain key "two" and not contain value (7))
  }
}
