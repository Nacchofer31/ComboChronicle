// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id (BuildPlugins.daggerHiltDsl) version(Versions.Hilt.versionHilt) apply false
    id (BuildPlugins.navigationSafeArgsDsl) version (Versions.Android.JetPack.navigationVersion) apply false
}
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}