package project

import org.gradle.api.Plugin
import org.gradle.api.Project
import project.plugins.*
import project.plugins.android
import project.plugins.configureBuildTypes
import project.plugins.configureCommonAppPlugins
import project.plugins.configureCompileAndroid
import project.plugins.configureDefaultConfig
import main.ProjectModule

open class FeatureModule : Plugin<Project> {

    override fun apply(target: Project) {
        target.configurePlugins()
        target.androidConfig()
    }

    private fun Project.configurePlugins() {
        configureCommonAppPlugins(ProjectModule.Feature)
        plugins.apply(BuildPlugins.pluginHilt)
        plugins.apply(BuildPlugins.pluginNavArgs)
    }

    private fun Project.androidConfig() {
        android.run {
            namespace = AppVersion.mainPackage.plus("feature")
            configurationStrategy()
            configureCompileAndroid()
            configureDefaultConfig(ProjectModule.Feature)
            buildFeatures.viewBinding = true
            buildFeatures.compose = true
            composeOptions {
                kotlinCompilerExtensionVersion = Versions.Android.composeRuntime
            }
            packagingOptions()
            configureBuildTypes(ProjectModule.Feature)
        }
    }
}