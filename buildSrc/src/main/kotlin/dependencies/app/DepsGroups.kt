package dependencies.app

import Deps
import org.gradle.api.artifacts.dsl.DependencyHandler

object DepsGroups {

    fun DependencyHandler.kotlin() {
        implementation(Deps.Kotlin.kotlinJdk8Dep)
        implementation(Deps.Kotlin.Coroutines.androidDep)
    }

    fun DependencyHandler.androidBase() {
        implementation(Deps.Android.annotationsVersion)
        implementation(Deps.Android.appCompatVersion)
        implementation(Deps.Android.constrainLayoutVersion)
        implementation(Deps.Android.materialVersion)
        implementation(Deps.Android.recyclerVersion)
    }

    fun DependencyHandler.androidKtx() {
        implementation(Deps.Android.Ktx.coreKtxVersion)
        implementation(Deps.Android.Ktx.activityKtxVersion)
        implementation(Deps.Android.Ktx.fragmentKtxVersion)
    }

    fun DependencyHandler.androidNavigation() {
        implementation(Deps.Android.Navigation.fragmentVersion)
        implementation(Deps.Android.Navigation.uiVersion)
        kapt(Deps.Android.Navigation.runtimeVersion)
    }

    fun DependencyHandler.androidRoom() {
        implementation(Deps.Android.Room.roomRuntimeVersion)
        implementation(Deps.Android.Room.roomKtxVersion)
        kapt(Deps.Android.Room.roomCompilerVersion)
    }

    fun DependencyHandler.androidLifecycle(withLiveData: Boolean = false) {
        implementation(Deps.Android.Lifecycle.lifecycleRuntimeVersion)
        implementation(Deps.Android.Lifecycle.viewModelKtxVersion)
        implementation(Deps.Android.Lifecycle.lifecycleRuntimeComposeVersion)
        if (withLiveData) implementation(Deps.Android.Lifecycle.liveDataKtxVersion)
    }

    fun DependencyHandler.androidHilt() {
        api(Deps.Hilt.hilt)
        kapt(Deps.Hilt.hiltKapt)
        kapt(Deps.Hilt.hiltCompiler)
    }

    fun DependencyHandler.images() {
        implementation(Deps.Images.glideDep)
        implementation(Deps.Images.glideOkHttpIntegrationDep)
        kapt(Deps.Images.glideKaptDep)
        implementation(Deps.Images.lottieDep)
    }

    fun DependencyHandler.retrofitRx(converter: String) {
        implementation(Deps.Retrofit.adapterRxDep)
        implementation(converter)
    }

    fun DependencyHandler.imagesCompose() {
        implementation(Deps.Images.lottieCompose)
        implementation(Deps.Images.coilCompose)
    }

    fun DependencyHandler.baseCompose(projectModule: main.ProjectModule) {
        when (projectModule == main.ProjectModule.Feature) {
            true -> {
                api(Deps.Android.Compose.activityCompose)
                api(Deps.Android.Compose.composeUi)
                api(Deps.Android.Compose.tooling_ui)
                api(Deps.Android.Compose.tooling_ui_debug)
                api(Deps.Android.Compose.test_manifest_debug)
            }
            false -> {
                implementation(Deps.Android.Compose.activityCompose)
                implementation(Deps.Android.Compose.composeUi)
                implementation(Deps.Android.Compose.tooling_ui)
                debugImplementation(Deps.Android.Compose.tooling_ui_debug)
                debugImplementation(Deps.Android.Compose.test_manifest_debug)
            }
        }
    }

    fun DependencyHandler.retrofitCoroutines(converter: String) {
        retrofit()
        implementation(converter)
    }

    private fun DependencyHandler.retrofit() {
        implementation(Deps.Retrofit.retrofitDep)
        implementation(Deps.Retrofit.okHttpLoginDeep)
        implementation(Deps.Retrofit.urlConnectionDep)
    }

    private fun DependencyHandler.implementation(depName: String) {
        add("implementation", depName)
    }

    private fun DependencyHandler.androidTestImplementation(depName: String) {
        add("androidTestImplementation", depName)
    }

    private fun DependencyHandler.kaptAndroidTest(depName: String) {
        add("kaptAndroidTest", depName)
    }

    private fun DependencyHandler.testImplementation(depName: String) {
        add("testImplementation", depName)
    }

    private fun DependencyHandler.debugImplementation(depName: String) {
        add("debugImplementation", depName)
    }

    private fun DependencyHandler.api(depName: String) {
        add("api", depName)
    }

    private fun DependencyHandler.kapt(depName: String) {
        add("kapt", depName)
    }

    fun DependencyHandler.dataTest() {
        testImplementation(Deps.Test.core_arch)
        testImplementation(Deps.Test.mockk)
        testImplementation(Deps.Test.junit)
        testImplementation(Deps.Test.coroutineTest)
        testImplementation(Deps.Test.turbine)
    }

    // Compose Test
    fun DependencyHandler.androidTest() {
        androidTestCompose()
        baseAndroidTest()
        androidHilt()
        androidHiltTest()
        androidNavigationTest()
        androidEspresso()
    }

    fun DependencyHandler.androidTestCompose() {
        androidTestImplementation(Deps.Test.test)
        debugImplementation(Deps.Test.debug)
    }

    fun DependencyHandler.baseAndroidTest() {
        androidTestImplementation(Deps.Test.core_arch)
        androidTestImplementation(Deps.Test.test_fragment)
        androidTestImplementation(Deps.Test.mockkAndroid)
    }

    private fun DependencyHandler.androidHiltTest() {
        androidTestImplementation(Deps.Test.hilt_test)
        kaptAndroidTest(Deps.Test.kapt_hilt_test)
    }

    private fun DependencyHandler.androidNavigationTest() {
        androidTestImplementation(Deps.Test.test_navigation)
    }

    private fun DependencyHandler.androidEspresso() {
        //androidTestImplementation(Deps.Test.espresso_contrib)
        androidTestImplementation(Deps.Test.espresso)
    }

}