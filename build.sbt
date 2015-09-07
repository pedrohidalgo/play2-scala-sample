import java.net.URLClassLoader
import sbt.classpath._

name := """my-blog-server"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

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

libraryDependencies += "com.typesafe.play" %% "play-slick" % "1.0.1"

libraryDependencies += "com.typesafe.play" %% "play-slick-evolutions" % "1.0.1"

libraryDependencies += "info.cukes" % "cucumber-scala_2.11" % "1.2.4" % "test"

resolvers += "Sonatype-Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
resolvers += Resolver.file("Local repo", file("./lib/.ivy2/local"))(Resolver.ivyStylePatterns)
resolvers += Resolver.mavenLocal

// Play2-cucumber integration
cucumberSettings

cucumberFeaturesLocation := "./test/features"

cucumberStepsBasePackage := "features.steps"

// Coveralls token Settings
import CoverallsKeys._

coverallsToken := Some("uWEbteyTmnmgTLi3xJbVOidS0rgnILyiK")

val generate_schema = taskKey[Unit]("Schema Generator")

generate_schema <<= (fullClasspath in Runtime) map {classpath =>
    val loader: ClassLoader = ClasspathUtilities.toLoader(classpath.map(_.data).map(_.getAbsoluteFile))
    val schemaGenerator = loader.loadClass("misc.SchemaGenerator").newInstance().asInstanceOf[Runnable]
    schemaGenerator.run
}