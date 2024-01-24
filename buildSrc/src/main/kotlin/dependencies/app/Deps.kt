object Deps {
    const val implementation = "implementation"
    const val kapt = "kapt"
    const val api = "api"

    object Android {
        const val constrainLayoutVersion =
            "androidx.constraintlayout:constraintlayout:${Versions.Android.constrainLayout}"
        const val constraintCompose =
            "androidx.constraintlayout:constraintlayout-compose:${Versions.Android.constraintCompose}"
        const val materialVersion =
            "com.google.android.material:material:${Versions.Android.material}"
        const val material3Compose =
            "androidx.compose.material3:material3:${Versions.Android.material3}"
        const val appCompatVersion = "androidx.appcompat:appcompat:${Versions.Android.appCompat}"
        const val recyclerVersion =
            "androidx.recyclerview:recyclerview:${Versions.Android.recycler}"
        const val annotationsVersion =
            "androidx.annotation:annotation:${Versions.Android.annotationX}"

        object Compose {
            const val activityCompose =
                "androidx.activity:activity-compose:${Versions.Android.activityCompose}"
            const val composeUi = "androidx.compose.ui:ui:${Versions.Android.compose}"
            const val tooling_ui =
                "androidx.compose.ui:ui-tooling-preview:${Versions.Android.compose}"
            const val tooling_ui_debug =
                "androidx.compose.ui:ui-tooling:${Versions.Android.compose}"
            const val test_manifest_debug =
                "androidx.compose.ui:ui-test-manifest:${Versions.Android.compose}"
            const val compilerCompose =
                "androidx.compose.compiler:compiler:${Versions.Android.composeRuntime}"
            const val composeViewBinding =
                "androidx.compose.ui:ui-viewbinding:${Versions.Android.compose}"
        }

        object Ktx {
            const val coreKtxVersion = "androidx.core:core-ktx:${Versions.Android.Ktx.core}"
            const val fragmentKtxVersion =
                "androidx.fragment:fragment-ktx:${Versions.Android.Ktx.fragments}"
            const val activityKtxVersion =
                "androidx.activity:activity-ktx:${Versions.Android.Ktx.activity}"
        }

        object Lifecycle {
            const val lifecycleRuntimeVersion =
                "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Android.Ktx.lifecycle}"
            const val viewModelKtxVersion =
                "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Android.viewModel}"
            const val liveDataKtxVersion =
                "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Android.liveData}"
            const val viewModelCompose =
                "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Android.viewModelCompose}"
            const val lifecycleRuntimeComposeVersion =
                "androidx.lifecycle:lifecycle-runtime-compose:${Versions.Android.Ktx.lifecycle}"
        }

        object Navigation {
            const val runtimeVersion =
                "androidx.navigation:navigation-runtime-ktx:${Versions.Android.JetPack.navigationVersion}"
            const val fragmentVersion =
                "androidx.navigation:navigation-fragment-ktx:${Versions.Android.JetPack.navigationVersion}"
            const val uiVersion =
                "androidx.navigation:navigation-ui-ktx:${Versions.Android.JetPack.navigationVersion}"
            const val navigationCompose =
                "androidx.navigation:navigation-compose:${Versions.Android.JetPack.navigationVersion}"
        }

        object Persistence {
            const val datastorePreference =
                "androidx.datastore:datastore-preferences:${Versions.Android.datastorePreference}"
        }

        object Room {
            const val roomKtxVersion = "androidx.room:room-ktx:${Versions.Android.room}"
            const val roomRuntimeVersion = "androidx.room:room-runtime:${Versions.Android.room}"
            const val roomCompilerVersion = "androidx.room:room-compiler:${Versions.Android.room}"
        }

        object Security {
            const val crypto =
                "androidx.security:security-crypto:${Versions.Android.Security.crypto}"
        }

        object WorkManager {
            const val workManager_ktx =
                "androidx.work:work-runtime-ktx:${Versions.Android.workManager}"
            const val workManager_hilt = "androidx.hilt:hilt-work:${Versions.Hilt.hiltWorkManager}"
        }
    }

    object Firebase {
        const val boomDep =
            "com.google.firebase:firebase-bom:${Versions.Firebase.firebaseBoomVersion}"

        const val analiticsDep = "com.google.firebase:firebase-analytics"
        const val performanceDep = "com.google.firebase:firebase-perf"
        const val crashlyticsDep = "com.google.firebase:firebase-crashlytics"
        const val messagingDep = "com.google.firebase:firebase-messaging"
        const val commonktxDep = "com.google.firebase:firebase-common-ktx"
    }

    object Gradle {
        const val safeArgsDep =
            "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.Android.JetPack.navigationVersion}"
        const val googleServicesDep =
            "com.google.gms:google-services:${Versions.Gradle.googleServicesVersion}"
        const val firebaseCrashlyticsDep =
            "com.google.firebase:firebase-crashlytics-gradle:${Versions.Firebase.classPathCrashlyticsVersion}"
        const val firebasePerformanceDep =
            "com.google.firebase:perf-plugin:${Versions.Firebase.classPathPerformanceVersion}"
    }

    //https://dzolnai.medium.com/dagger-hilt-viewmodelclass-has-no-zero-argument-constructor-causes-76d40007eb28
    object Hilt {
        const val hiltGradle =
            "com.google.dagger:hilt-android-gradle-plugin:${Versions.Hilt.versionHilt}"
        const val hilt = "com.google.dagger:hilt-android:${Versions.Hilt.versionHilt}"
        const val hiltKapt =
            "com.google.dagger:hilt-android-compiler:${Versions.Hilt.versionHilt}"
        const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.Hilt.hiltWorkManager}"
    }

    object Images {
        const val glideDep = "com.github.bumptech.glide:glide:${Versions.Images.glideVersion}"
        const val glideOkHttpIntegrationDep =
            "com.github.bumptech.glide:okhttp3-integration:${Versions.Images.glideVersion}"
        const val glideKaptDep =
            "com.github.bumptech.glide:compiler:${Versions.Images.glideKaptVersion}"
        const val lottieDep = "com.airbnb.android:lottie:${Versions.Images.lottieVersion}"
        const val lottieCompose =
            "com.airbnb.android:lottie-compose:${Versions.Images.lottieComposeVersion}"
        const val coilCompose = "io.coil-kt:coil-compose:${Versions.Images.coilComposeVersion}"
    }

    object Kotlin {
        const val kotlinJdk8Dep =
            "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.Kotlin.kotlinVersion}"

        object Coroutines {
            const val androidDep =
                "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Kotlin.coroutinesVersion}"
        }
    }

    object Libraries {
        const val javapoet = "com.squareup:javapoet:${Versions.javapoet}"
        const val timberDep = "com.jakewharton.timber:timber:${Versions.timber}"
        const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"
        const val jsoup = "org.jsoup:jsoup:${Versions.jsoup}"

    }

    object Retrofit {
        const val retrofitDep =
            "com.squareup.retrofit2:retrofit:${Versions.Retrofit.retrofitVersion}"
        const val converterGsonDep =
            "com.squareup.retrofit2:converter-gson:${Versions.Retrofit.retrofitVersion}"
        const val converterMoshiDep =
            "com.squareup.retrofit2:converter-moshi:${Versions.Retrofit.retrofitVersion}"
        const val adapterRxDep =
            "com.squareup.retrofit2:adapter-rxjava:${Versions.Retrofit.retrofitVersion}"
        const val okHttpLoginDeep =
            "com.squareup.okhttp3:logging-interceptor:${Versions.Retrofit.okHttp3Version}"
        const val urlConnectionDep =
            "com.squareup.okhttp3:okhttp-urlconnection:${Versions.Retrofit.okHttp3Version}"
    }

    object Test {
        const val mockk = "io.mockk:mockk:${Versions.Test.mockk}"
        const val mockkAndroid = "io.mockk:mockk-android:${Versions.Test.mockk}"
        const val junit = "junit:junit:${Versions.Test.junit}"
        const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.Test.coroutineTest}"
        const val turbine = "app.cash.turbine:turbine:${Versions.Test.turbine}"

        const val test = "androidx.compose.ui:ui-test-junit4:${Versions.Android.compose}"
        const val debug = "androidx.compose.ui:ui-test-manifest:${Versions.Android.compose}"

        const val core_arch = "androidx.arch.core:core-testing:${Versions.Test.core_arch_test}"
        const val test_fragment = "androidx.fragment:fragment-testing:${Versions.Test.fragment_test}"

        const val hilt_test = "com.google.dagger:hilt-android-testing:${Versions.Test.hilt_test}"
        const val kapt_hilt_test = "com.google.dagger:hilt-android-compiler:${Versions.Test.hilt_test}"

        const val test_navigation = "androidx.navigation:navigation-testing:${Versions.Test.navigation_test}"

        const val espresso_contrib = "androidx.test.espresso:espresso-contrib:${Versions.Test.espresso}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.Test.espresso}"

    }
}

