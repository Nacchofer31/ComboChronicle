/**
 *  Update 26-06-2021
 *  @see <a href="https://maven.google.com/web/index.html">Maven-Google</a>
 */
object  Versions {

    const val leakCanary = "2.7"
    const val timber = "4.7.1"
    const val javapoet = "1.13.0"
    const val jsoup = "1.13.1"

    object Kotlin {
        const val kotlinVersion = "1.7.20"
        const val coroutinesVersion = "1.6.4"
    }

    object Gradle {
        const val tools = "7.3.1"
        const val googleServicesVersion = "4.3.13"
    }

    object Hilt {
        const val versionHilt = "2.50"
        const val hiltWorkManager = "1.1.0"
    }


    object Android {
        const val activityCompose = "1.8.2"
        const val compose = "1.3.3"
        const val composeRuntime = "1.5.10"
        const val constrainLayout = "2.0.4"
        const val constraintCompose = "1.0.1"
        const val appCompat = "1.6.1"
        const val material = "1.5.0"
        const val material3 = "1.0.1"
        const val recycler = "1.3.2"
        const val room = "2.6.1"
        const val liveData = "2.6.0"
        const val viewModel = "2.6.0"
        const val viewModelCompose = "2.5.1"
        const val workManager = "2.7.1"
        const val annotationX = "1.7.1"
        const val mediaRouter = "1.3.0"
        const val datastorePreference = "1.0.0"

        object Ktx {
            const val core = "1.7.0"
            const val fragments = "1.6.2"
            const val activity = "1.8.2"
            const val lifecycle = "2.7.0"
        }

        object JetPack {
            const val paging = "3.0.1"
            const val navigationVersion = "2.7.7"
        }

        object Security {
            const val crypto = "1.0.0"
        }
    }

    object Firebase {
        const val firebaseBoomVersion = "30.2.0"
        const val classPathCrashlyticsVersion = "2.9.9"
        const val classPathPerformanceVersion = "1.4.2"
    }

    object Retrofit {
        const val retrofitVersion = "2.9.0"
        const val okHttp3Version = "4.9.1"
    }

    object Images {
        const val coilComposeVersion = "2.2.2"
        const val glideVersion = "4.16.0"
        const val glideKaptVersion = "4.12.0"
        const val lottieVersion = "5.2.0"
        const val lottieComposeVersion = "5.2.0"
    }

    object Test {
        const val mockk = "1.13.9"
        const val junit = "4.13.2"
        const val core_arch_test = "2.2.0"
        const val fragment_test = Versions.Android.Ktx.fragments
        const val hilt_test = Versions.Hilt.versionHilt
        const val navigation_test = Versions.Android.JetPack.navigationVersion
        const val espresso= "3.5.1"
        const val coroutineTest = "1.6.4"
        const val turbine = "0.12.3"
    }

}