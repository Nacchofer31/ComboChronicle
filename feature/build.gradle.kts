import dependencies.app.DepsGroups.androidBase
import main.ProjectModule
import dependencies.app.DepsGroups.androidKtx
import dependencies.app.DepsGroups.androidLifecycle
import dependencies.app.DepsGroups.androidTest
import dependencies.app.DepsGroups.baseCompose
import dependencies.app.DepsGroups.dataTest
import dependencies.app.DepsGroups.images
import dependencies.app.DepsGroups.imagesCompose

plugins {
    id(BuildPlugins.pluginFeatures)
}

kapt {
    useBuildCache = true
    correctErrorTypes = true
    useBuildCache = true
}

dependencies {
    implementation(project(":domain"))
    androidBase()
    androidKtx()
    androidLifecycle(true)
    images()
    imagesCompose()
    baseCompose(ProjectModule.Feature)
    api (Deps.Android.material3Compose)
    api (Deps.Android.Lifecycle.viewModelCompose)
    api (Deps.Android.constraintCompose)
    implementation(Deps.Android.Compose.compilerCompose)
    implementation(Deps.Android.Compose.composeViewBinding)
    //Ejemplo si queremos uno que no este en grupo
    implementation(Deps.Libraries.timberDep)
    implementation(Deps.Libraries.jsoup)
    androidTest()
    dataTest()
}