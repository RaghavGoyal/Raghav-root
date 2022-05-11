name := "zio"

version := "0.1"

scalaVersion := "2.13.8"

//libraryDependencies += "dev.zio" %% "zio" % "2.0.0-M4"
//libraryDependencies += "dev.zio" %% "zio-streams" % "2.0.0-M4"

libraryDependencies += "dev.zio" %% "zio" % "1.0.14"
libraryDependencies += "dev.zio" %% "zio-streams" % "1.0.14"
// dependency for application monitoring
libraryDependencies += "dev.zio" %% "zio-zmx" % "0.0.6"
