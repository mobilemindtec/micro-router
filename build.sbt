val sharedSettings = Seq(
  scalaVersion := "3.6.4",
  scalacOptions ++= Seq(
    "-new-syntax",
    //"-no-indent",
    "-Wvalue-discard",
    "-Wunused:all",
    //"-Werror",
    "-deprecation",
    "-explain",
    "-explain-cyclic",
    "-rewrite",
    "-source:future",
    "-language:experimental.modularity",
    "-language:experimental.betterFors",
    "-language:experimental.namedTuples",
  ),
  javacOptions ++= Seq("-source", "23", "-target", "23")
)

lazy val router =
  // select supported platforms
  crossProject(JSPlatform, JVMPlatform, NativePlatform)
    .crossType(CrossType.Full) // [Pure, Full, Dummy], default: CrossType.Full
    .withoutSuffixFor(JVMPlatform)
    .in(file("router"))
    .settings(sharedSettings *)
    .settings(
      name := "router",
      organization := "io.micro",
      version := "0.0.1"
    )
    .jvmSettings(
      libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % "test"
    )
    // configure Scala-Native settings
    .nativeSettings( /* ... */ ) // defined in sbt-scala-native
