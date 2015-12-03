import java.net.URLClassLoader
import sbt.classpath._

name := """my-blog-server"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala, PlayEbean)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
    cache,
    ws,
    specs2 % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

//libraryDependencies += evolutions

libraryDependencies += "org.postgresql" % "postgresql" % "9.3-1102-jdbc41"
