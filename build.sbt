lazy val root = crossProject.in(file("."))
  .settings(
    name := "JLMaG",
    version := "1.0",
    scalaVersion := "2.12.3"
  )
  .jsSettings(
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.2",
    scalaJSUseMainModuleInitializer := true
  )

lazy val rootJS = root.js
lazy val rootJVM = root.jvm