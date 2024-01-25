import dependencies.app.DepsGroups.androidHilt
import dependencies.app.DepsGroups.dataTest

plugins {
    id(BuildPlugins.pluginDomain)
}

kapt {
    useBuildCache = true
    correctErrorTypes = true
    useBuildCache = true
}

dependencies {
    implementation(Deps.Libraries.timberDep)
    api(Deps.Android.Persistence.datastorePreference)
    api(Deps.Retrofit.converterGsonDep)
    dataTest()
}