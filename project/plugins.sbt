// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.4.4")

// web plugins

addSbtPlugin("com.typesafe.sbt" % "sbt-coffeescript" % "1.0.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-less" % "1.0.6")

addSbtPlugin("com.typesafe.sbt" % "sbt-jshint" % "1.0.3")

addSbtPlugin("com.typesafe.sbt" % "sbt-rjs" % "1.0.7")

addSbtPlugin("com.typesafe.sbt" % "sbt-digest" % "1.1.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-mocha" % "1.1.0")

// cucumber plugin which located in the local directory
resolvers += Resolver.file("Local repo", file("./lib/.ivy2/local"))(Resolver.ivyStylePatterns)
addSbtPlugin("templemore" % "sbt-cucumber-plugin" % "0.9.0-SNAPSHOT")

// coverall plugin
resolvers += Classpaths.sbtPluginReleases

addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.0.4")

addSbtPlugin("org.scoverage" % "sbt-coveralls" % "1.0.0")

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "4.0.0")