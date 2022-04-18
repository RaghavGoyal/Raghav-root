name := "hangManApp"

version := "0.1"

scalaVersion := "2.13.8"

val zioVersion = "1.0.4"

libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % zioVersion
)

lazy val root = (project in file("."))
