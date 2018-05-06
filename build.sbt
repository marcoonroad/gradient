lazy val root = (project in file(".")).settings(
  inThisBuild(
    List(
      organization := "com.marcoonroad",
      scalaVersion := "2.12.4"
    )),
  name := "gradient"
)

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"

scalastyleFailOnError := true
scalastyleFailOnWarning := true

(scalastyleFailOnError in Test) := true
(scalastyleFailOnWarning in Test) := true

coverageMinimum := 80
coverageFailOnMinimum := true
