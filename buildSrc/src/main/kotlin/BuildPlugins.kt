object BuildPlugins {

    //MODULES
    const val pluginMain = "appMainModule"
    const val pluginDomain = "domain"
    const val pluginData = "data"
    const val pluginFeatures = "feature"

    //CUSTOM PLUGINS
    const val pluginHilt = "androidHiltPlugin"
    const val pluginNavArgs = "androidNavigationPlugin"
    const val pluginTesting = "sharedTest"

    //ANDROID PLUGINS
    const val androidApp = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinKapt = "kotlin-kapt"
    const val kotlin = "kotlin"
    const val navigationSafeArgsDsl = "androidx.navigation.safeargs.kotlin"
    const val daggerHiltDsl = "com.google.dagger.hilt.android"
    const val parcelable = "kotlin-parcelize"
    const val firebasePerformance = "com.google.firebase.firebase-perf"
    const val firebaseCrashlitycs = "com.google.firebase.crashlytics"
    const val googleServices = "com.google.gms.google-services"
}