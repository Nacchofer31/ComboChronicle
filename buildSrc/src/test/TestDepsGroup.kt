package dependencies.test

import dependencies.test.TestLibraries.AndroidTest.androidTestimplementation
import dependencies.test.TestLibraries.AndroidTest.debugImplementation
import dependencies.test.TestLibraries.AndroidTest.kaptAndroidTest
import org.gradle.api.artifacts.dsl.DependencyHandler

object TestDepsGroup {

    fun DependencyHandler.androidTest() {
        add(androidTestimplementation, TestLibraries.AndroidTest.CORE_ARCH)
        add(androidTestimplementation, TestLibraries.AndroidTest.TEST_FRAGMENT)
        add(androidTestimplementation, TestLibraries.AndroidTest.MOCKK)
        add(androidTestimplementation, TestLibraries.AndroidTest.RUNNER)
        androidHiltTest()
        androidEspresso()
        androidComposeTest()
        androidNavigationTest()
    }

    fun DependencyHandler.androidHiltTest(){
        add(androidTestimplementation, TestLibraries.AndroidTest.HILT_TEST)
        add(kaptAndroidTest, TestLibraries.AndroidTest.KAPT_HILT_TEST)
    }

    private fun DependencyHandler.androidNavigationTest(){
        add(androidTestimplementation, TestLibraries.AndroidTest.TEST_NAVIGATION)
    }

    private fun DependencyHandler.androidEspresso(){
        add(androidTestimplementation, TestLibraries.AndroidTest.ESPRESSO)
    }

    private fun DependencyHandler.androidComposeTest(){
        add(androidTestimplementation, platform(Deps.Android.Compose.activityCompose))
        add(androidTestimplementation, TestLibraries.AndroidTest.COMPOSE_UI_TEST)
        add(androidTestimplementation, TestLibraries.AndroidTest.COMPOSE_UI_JUNIT_TEST)
        // Needed for createAndroidComposeRule, but not createComposeRule:
        add(debugImplementation,TestLibraries.AndroidTest.COMPOSE_TEST_MANIFEST_DEBUG)
    }
}
