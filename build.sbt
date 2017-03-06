name          := "minimerce"
version       := "0.0.1"
scalaVersion  := "2.11.7"

libraryDependencies ++= {
  val akkaVersion = "2.4.2"
  val slickVersion = "3.1.1"
  Seq(
    "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test",
    "com.typesafe.akka"   %%  "akka-http-experimental"    % akkaVersion,
    "com.typesafe.akka"   %%  "akka-http-core"    % akkaVersion,
    "com.typesafe.akka"   %%  "akka-http-testkit" % akkaVersion,
    "com.typesafe.akka"	  %%  "akka-http-spray-json-experimental"	% akkaVersion,
    "com.typesafe.akka"   %%  "akka-actor"    % akkaVersion,
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaVersion   % "test",
    "com.typesafe.slick" %% "slick" % slickVersion,
    "com.typesafe.slick" %% "slick-hikaricp" % slickVersion,
    "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0",
    "mysql" % "mysql-connector-java" % "5.1.36",
    "ch.qos.logback" % "logback-classic" % "1.1.3",
    "org.slf4j" % "slf4j-nop" % "1.6.4",
    "joda-time" % "joda-time" % "2.9.4"
  )
}
