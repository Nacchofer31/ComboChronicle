import dependencies.app.DepsGroups.androidBase
import dependencies.app.DepsGroups.androidKtx
import dependencies.app.DepsGroups.androidLifecycle
import dependencies.app.DepsGroups.androidTest
import dependencies.app.DepsGroups.baseCompose
import dependencies.app.DepsGroups.images
import dependencies.app.DepsGroups.imagesCompose
import main.ProjectModule

plugins {
    id(BuildPlugins.pluginMain)
}

kapt {
    useBuildCache = true
    correctErrorTypes = true
    useBuildCache = true
}

android {
    hilt{
        enableAggregatingTask = true
    }
}

dependencies {
    //implementation(project(":data"))
    implementation(project(":feature"))
    androidBase()
    androidKtx()
    androidLifecycle(true)
    images()
    imagesCompose()
    baseCompose(ProjectModule.Main)
    implementation (Deps.Android.material3Compose)
    implementation (Deps.Android.Lifecycle.viewModelCompose)
    implementation (Deps.Android.constraintCompose)

    implementation(Deps.Libraries.timberDep)

    androidTest()
    androidTestImplementation(project(":domain"))

}