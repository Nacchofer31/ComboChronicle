package project

import org.gradle.api.Plugin
import org.gradle.api.Project
import main.ProjectModule
import project.plugins.packagingOptions
import project.plugins.configureBuildTypes
import project.plugins.android
import project.plugins.configureCommonAppPlugins
import project.plugins.configureCompileAndroid
import project.plugins.configureDefaultConfig

open class DataModule : Plugin<Project> {

    override fun apply(target: Project) {
        target.configurePlugins()
        target.androidConfig()
    }

    private fun Project.configurePlugins() {
        configureCommonAppPlugins(ProjectModule.Data)
        plugins.apply(BuildPlugins.pluginHilt)
    }

    private fun Project.androidConfig() {
        android.run {
            namespace = AppVersion.mainPackage.plus("data")
            configureCompileAndroid()
            configureDefaultConfig(ProjectModule.Data)
            //configureCompileAndroid()
            //lintOptions()
            packagingOptions()
            configureBuildTypes(ProjectModule.Data)
        }
    }
}