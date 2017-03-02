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
    "com.typesafe.slick" %% "slick-hikaricp" % slickVersion
  )
}
