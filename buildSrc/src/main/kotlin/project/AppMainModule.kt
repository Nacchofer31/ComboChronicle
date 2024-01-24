package project

import AppVersion
import BuildPlugins
import org.gradle.api.Plugin
import org.gradle.api.Project
import project.plugins.*
import main.ProjectModule


/**
 * Aplicación Base con:
 *
 * MVVM[https://www.google.es]
 *
 * KOTLIN
 *
 * COROUTINES
 *
 * NAVIGATION
 **/
open class AppMainModule : Plugin<Project> {

    override fun apply(target: Project) {
        target.configurePlugins()
        target.androidConfig()
    }

    private fun Project.configurePlugins() {
        configureCommonAppPlugins(ProjectModule.Main)
        plugins.apply(BuildPlugins.pluginHilt)
        plugins.apply(BuildPlugins.pluginNavArgs)
    }

    private fun Project.androidConfig() {
        android.run {
            namespace = AppVersion.nameSpace
            configurationStrategy()
            configureCompileAndroid()
            configureDefaultConfig(ProjectModule.Main)
            configureOptionsTest()
            lintOptions()
            packagingOptions()
            dataBindingOptions()
            configureBuildTypes(ProjectModule.Main)
        }
    }
}