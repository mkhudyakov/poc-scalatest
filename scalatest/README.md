# Scalatest

### Selecting testing styles for your project
ScalaTest supports different styles of testing, each designed to address a particular set of needs. To help you find the best-fit styles for your project, [this page] will describe the intended use cases for each option.
### Run single test
``
sbt "test-only com.poc.scalatest.SetSpec”
``
### Run tests before the package step
``
sbt test package
``

[this page]:http://www.scalatest.org/user_guide/selecting_a_style