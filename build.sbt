name        := "Scala-Java-exercises"
version     := "0.1"
description := "Project contains the sample code written in Scala and Java"

scalaVersion in ThisBuild := "2.13.2"

// PROJECTS
lazy val global = project
  .in(file("."))
  .settings(settings)
  .aggregate(`Scala-module`)

lazy val `Scala-module` = project
  .settings(
    name := "Scala-module",
    settings,
    libraryDependencies ++= scalaDependencies
  )

lazy val dependencies =
  new {
    val parallelColl= "org.scala-lang.modules" %% "scala-parallel-collections" % "0.2.0"
    val akka = "com.typesafe.akka" %% "akka-actor" % "2.6.5"
    val scalafx = "org.scalafx" %% "scalafx" % "14-R19"
  }

lazy val scalaDependencies = Seq(
  dependencies.akka,
  dependencies.parallelColl,
  dependencies.scalafx
)

lazy val settings = Seq(
  scalacOptions ++= compilerOptions
)

lazy val compilerOptions = Seq(
  "-unchecked",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-language:postfixOps",
  "-deprecation",
  "-encoding",
  "utf8"
)