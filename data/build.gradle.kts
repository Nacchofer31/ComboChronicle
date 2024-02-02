
import dependencies.app.DepsGroups.dataTest
import dependencies.app.DepsGroups.retrofitCoroutines

plugins {
    id(BuildPlugins.pluginData)
}

kapt {
    useBuildCache = true
    correctErrorTypes = true
    useBuildCache = true
}

dependencies {
    implementation(project(":domain"))
    implementation(Deps.Libraries.timberDep)
    retrofitCoroutines(Deps.Retrofit.converterGsonDep)
    implementation(Deps.Android.Persistence.datastorePreference)
    dataTest()
}