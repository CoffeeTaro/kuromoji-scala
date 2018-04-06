name := "GeoStream"

scalaVersion := "2.11.10"
version := "1.1"

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked", "-Xlint")

resolvers += "Atilika Open Source repository" at "http://www.atilika.org/nexus/content/repositories/atilika"

libraryDependencies ++= Seq(
    "com.typesafe" % "config" % "1.3.2",
    "org.atilika.kuromoji" % "kuromoji" % "0.7.7",
    "org.apache.spark" %% "spark-core" % "2.2.0" % "provided",
    "org.apache.spark" %% "spark-streaming" % "2.2.0" % "provided",
    "org.apache.bahir" %% "spark-streaming-twitter" % "2.2.0" exclude("org.spark-project.spark", "unused"),
    "org.twitter4j" % "twitter4j-stream" % "4.0.6"
)

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-unchecked",
  "-Xfuture",
  "-Xlint",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-unused-import",
  "-Ywarn-value-discard"
)

assemblyMergeStrategy in assembly := {
  case PathList("javax", "servlet", xs @ _*)         => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".html" => MergeStrategy.first
  case "application.conf"                            => MergeStrategy.concat
  case "unwanted.txt"                                => MergeStrategy.discard
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}
