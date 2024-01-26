package dependencies.test

object TestLibraries {
    object UnitTest {
        const val COROUTINE = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${TestVersion.COROUTINES}"
        const val HAMCREST = "org.hamcrest:hamcrest-all:${TestVersion.HAMCREST}"
        const val JUNIT4 = "junit:junit:${TestVersion.JUNIT}"
        const val MOCKK = "io.mockk:mockk:${TestVersion.MOCKK}"
        const val MOCKWEBSERVICE = "com.squareup.okhttp3:mockwebserver:${TestVersion.MOCKWEBSERVICE}"
        const val TURBINE = "app.cash.turbine:turbine:${TestVersion.TURBINE}"
    }

    object AndroidTest {
        const val kaptAndroidTest = "kaptAndroidTest"
        const val androidTestimplementation = "androidTestImplementation"
        const val platform = "platform"
        const val debugImplementation = "debugImplementation"

        // Testing dependencies
        const val CORE_ARCH = "androidx.arch.core:core-testing:${TestVersion.CORE_ARCH_TEST}"
        const val TESTCORE = "androidx.test:core:${TestVersion.CORE_TEST}"
        const val TEST_NAVIGATION = "androidx.navigation:navigation-testing:${TestVersion.NAVIGATION_TEST}"
        const val ESPRESSO_INTENTS = "androidx.test.espresso:espresso-intents:${TestVersion.ESPRESSO}"
        const val ESPRESSO_IDLING = "androidx.test.espresso:espresso-idling-resource:${TestVersion.ESPRESSO}"
        const val ESPRESSO_CONTRIB = "androidx.test.espresso:espresso-contrib:${TestVersion.ESPRESSO}"
        const val ESPRESSO = "androidx.test.espresso:espresso-core:${TestVersion.ESPRESSO}"
        const val COMPOSE_UI_TEST = "androidx.compose.ui:ui-test"
        const val COMPOSE_UI_JUNIT_TEST = "androidx.compose.ui:ui-test-junit4"
        const val COMPOSE_TEST_MANIFEST_DEBUG = "androidx.compose.ui:ui-test-manifest"

        //if you want hilt test like unitTest then define cons val to root TestLibraries and remove this HILT_TEST-KAPT_HILT_TEST
        const val HILT_TEST = "com.google.dagger:hilt-android-testing:${TestVersion.HILT_TEST}"
        const val KAPT_HILT_TEST = "com.google.dagger:hilt-android-compiler:${TestVersion.HILT_TEST}"
        const val RUNNER = "androidx.test:runner:${TestVersion.RUNNER}"
        const val ANDROID_JUNIT = "androidx.test.ext:junit:${TestVersion.ANDROID_JUNIT}"
        const val TEST_FRAGMENT = "androidx.fragment:fragment-testing:${TestVersion.FRAGMENT_TEST}"
        const val MOCKK = "io.mockk:mockk-android:${TestVersion.MOCKK}"
        const val DEXOPENER = "com.github.tmurakami:dexopener:${TestVersion.DEXOPENER}"
    }
}
