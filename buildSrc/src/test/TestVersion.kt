package dependencies.test

import Versions

object TestVersion {
    const val ANDROID_JUNIT = "1.1.3"
    const val COROUTINES = Versions.Kotlin.coroutinesVersion
    const val CORE_ARCH_TEST = "2.1.0"
    const val CORE_TEST = "1.4.0"
    const val DEXOPENER = "2.0.5"
    const val ESPRESSO= "3.5.1"
    const val FRAGMENT_TEST = Versions.Android.Ktx.fragments
    const val HAMCREST= "1.3"
    const val HILT_TEST = Versions.Hilt.versionHilt
    const val JUNIT = "4.13.2"

    /**
     * @since v.1.13.4
     */
    const val MOCKK = "1.13.4"

    /**
     * @since v.4.9.3
     */
    const val MOCKWEBSERVICE = "4.9.3"
    const val NAVIGATION_TEST = Versions.Android.JetPack.navigationVersion
    const val RUNNER = "1.4.0"
    const val RULES = "1.4.0"

    /**
     * @since v.0.12.1
     */
    const val TURBINE = "0.12.1"
}
