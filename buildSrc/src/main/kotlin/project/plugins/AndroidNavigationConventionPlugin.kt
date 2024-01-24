package project.plugins

import BuildPlugins
import dependencies.app.DepsGroups.androidNavigation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

abstract class AndroidNavigationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.configurePlugins()
        target.afterEvaluate {
            target.configureDependencies()
        }
    }

    private fun Project.configurePlugins() {
        with(pluginManager){
            apply(BuildPlugins.navigationSafeArgsDsl)
        }
    }

    private fun Project.configureDependencies() {
        dependencies {
            androidNavigation()
        }
    }
}



