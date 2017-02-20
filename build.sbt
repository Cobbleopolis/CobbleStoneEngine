val lwjglVersion = "3.0.0"

val scalaVer = "2.11.8"

val projectVersion = "3.0.0-SNAPSHOT"

val dependencies = Seq (
    "org.lwjgl" % "lwjgl" % lwjglVersion,
    "org.lwjgl" % "lwjgl-platform" % lwjglVersion classifier "natives-windows" classifier "natives-linux" classifier "natives-osx"
)

lazy val CobbleStoneEngine = (project in file(".")).settings(
    name := "CobbleStoneEngine",
    organization := "com.cobble.engine",
    version := projectVersion,
    scalaVersion := scalaVer,
    isSnapshot := projectVersion.toLowerCase.contains("snapshot"),
    libraryDependencies ++= dependencies,
    crossPaths := false,
    target in Compile in doc := baseDirectory.value / "docs",
    apiURL := Some(url("https://cobbleopolis.github.io/CobbleStoneEngine/")),
    autoAPIMappings := true,
    apiMappings += (scalaInstance.value.libraryJar -> url(s"http://www.scala-lang.org/api/${scalaVersion.value}/")),
    publishTo := {
        val nexus = "http://mvn.random.haus/repository/"
        if (isSnapshot.value)
            Some("CobbleStoneStudios" at nexus + "maven-snapshots/")
        else
            Some("CobbleStoneStudios"  at nexus + "maven-releases/")
    },
    credentials += Credentials(Path.userHome / ".m3" / ".credentials")
)