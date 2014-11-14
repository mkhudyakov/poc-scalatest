package com.poc.scalatest

import org.scalatest.{GivenWhenThen, Ignore, FlatSpec}

/**
 * FlatSpec facilitates a “behavior-driven” style of development (BDD),
 * in which tests are combined with text that specifies the behavior the tests verify.
 *
 * Trait FlatSpec is so named because your specification text and tests line up flat
 * against the left-side indentation level, with no nesting needed.
 *
 * http://doc.scalatest.org/2.2.1/#org.scalatest.FlatSpec
 *
 * @author Maksym Khudiakov
 */
class SetSpecBehaviourClause extends FlatSpec {

  behavior of "An empty Set"

  it should "have size 0" in {
    assert(Set.empty.size === 0)
  }

  it should "produce NoSuchElementException when head is invoked" in {
    intercept[NoSuchElementException] {
      Set.empty.head
    }
  }
}

@Ignore
class SetSpec extends FlatSpec {

  "An empty Set" should "have size 0" in {
    assert(Set.empty.size === 0)
  }

  it should "produce NoSuchElementException when head is invoked" in {
    intercept[NoSuchElementException] {
      Set.empty.head
    }
  }

  ignore must "produce NoSuchElementException when head is invoked" in {
    intercept[NoSuchElementException] {
      Set.empty.head
    }
  }
}

import collection.mutable
import org.scalatest._

class SetSpecGivenWhenThen extends FlatSpec with GivenWhenThen {

  "A mutable Set" should "allow an element to be added" in {
    Given("an empty mutable Set")
    val set = mutable.Set.empty[String]

    When("an element is added")
    set += "clarity"

    Then("the Set should have size 1")
    assert(set.size === 1)

    And("the Set should contain the added element")
    assert(set.contains("clarity"))

    info("That's all folks!")
  }
}