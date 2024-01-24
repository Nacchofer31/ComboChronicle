package project.plugins

import BuildPlugins
import dependencies.app.DepsGroups.androidHilt
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import project.AppMainModule

abstract class AndroidHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.configurePlugins()
        target.configureProcessorFlags()
        target.configureDependencies()
        /*target.plugins.withType(AppMainModule::class.java) {
            target.configurePlugins()
            target.configureProcessorFlags()
        }*/

        target.afterEvaluate {
            target.configureDependencies()
        }
    }

    private fun Project.configurePlugins() {
        with(pluginManager){
            apply(BuildPlugins.daggerHiltDsl)
        }
    }

    private fun Project.configureDependencies() {
        dependencies {
            androidHilt()
        }
    }

    private fun Project.configureProcessorFlags() {
        val processorOptions = listOf(
            "dagger.fastInit" to "enabled",
            "dagger.hilt.android.internal.disableAndroidSuperclassValidation" to "true"
        )
        // Pass annotation processor flag to disable @AndroidEntryPoint superclass validation.
        android.defaultConfig.apply {
            javaCompileOptions.apply {
                annotationProcessorOptions.apply {
                    processorOptions.forEach { (key, value) -> argument(key, value) }
                }
            }
        }
    }
}



