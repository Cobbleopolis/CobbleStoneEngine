val lwjglVersion = "3.0.0"

val scalaVer = "2.11.8"

val projectVersion = "3.0.0a"

val dependencies = Seq (
    "org.lwjgl" % "lwjgl" % lwjglVersion,
    "org.lwjgl" % "lwjgl-platform" % lwjglVersion classifier "natives-windows" classifier "natives-linux" classifier "natives-osx"
)

lazy val CobbleStoneEngine = (project in file(".")).settings(
    name := "CobbleStoneEngine",
    organization := "com.cobble.engine",
    version := projectVersion,
    scalaVersion := scalaVer,
    libraryDependencies ++= dependencies,
    crossPaths := false,
    ghpages.settings,
    git.remoteRepo := "https://github.com/Cobbleopolis/CobbleStoneEngine.git",
    siteMappings ++= Seq(file("doc/index.html") -> "index.html")
).enablePlugins(SiteScaladocPlugin)