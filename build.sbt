name := "poc-scalatest"

version := Build.version

scalaVersion := Build.scalaVersion

lazy val `poc-scalatest` = project.in(file("."))
  .aggregate(
    scalatest,
    `akka-testkit`
  )

lazy val scalatest = project in file("scalatest")

lazy val `akka-testkit` = project in file("akka-testkit")
