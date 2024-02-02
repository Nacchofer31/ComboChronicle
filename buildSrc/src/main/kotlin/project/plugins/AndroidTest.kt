package project.plugins

import main.ProjectModule
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureOptionsTest() {
    android.run {
        testOptions.unitTests{
            isIncludeAndroidResources = true
        }
        testOptions {
            resultsDir = "${project.buildDir}/test/results"
            packagingOptions {
                jniLibs {
                    useLegacyPackaging = true
                }
            }
        }

        defaultConfig {
            testInstrumentationRunner = "com.nacchofer31.runner.ComboChronicle"
        }
    }
}