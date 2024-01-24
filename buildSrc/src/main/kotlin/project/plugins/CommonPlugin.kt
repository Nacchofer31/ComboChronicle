package project.plugins

import AndroidSDK
import Versions
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import main.ProjectModule

internal val Project.androidApp: BaseAppModuleExtension
    get() = extensions.findByName("android") as? BaseAppModuleExtension
        ?: error("Not an Android module: $name")


internal val Project.android: BaseExtension
    get() = extensions.findByName("android") as? BaseExtension
        ?: error("Not an Android module: $name")


internal fun Project.configureCommonAppPlugins(projectModule: ProjectModule) {
    when (projectModule) {
        ProjectModule.Main -> plugins.apply(BuildPlugins.androidApp)
        else -> plugins.apply(BuildPlugins.androidLibrary)
    }
    plugins.apply(BuildPlugins.kotlinAndroid)
    plugins.apply(BuildPlugins.kotlinKapt)
    when (projectModule) {
        ProjectModule.Main, ProjectModule.Feature, ProjectModule.Domain -> plugins.apply(
            BuildPlugins.parcelable
        )
        else -> { /*No need parcelable*/
        }
    }
}

internal fun Project.configureCompileAndroid() {
    android.run {
        compileSdkVersion(AndroidSDK.compile)
        buildToolsVersion(AndroidSDK.buildToolsVersion)
    }
}

internal fun Project.configurationStrategy() {
    android.run { configurations.all { resolutionStrategy {
        force("org.jetbrains.kotlin:kotlin-stdlib:${Versions.Kotlin.kotlinVersion}")
        force ("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.Kotlin.kotlinVersion}") } } }
}

internal fun Project.dataBindingOptions() {
    androidApp.run {
        buildFeatures {
            dataBinding = false
            viewBinding = true
            compose = true
        }
        dataBinding.addKtx = false
        dataBinding.addDefaultAdapters = false
        composeOptions {
            kotlinCompilerExtensionVersion = Versions.Android.composeRuntime
        }
    }
}

internal fun BaseExtension.configureDefaultConfig(projectModule: ProjectModule) {
    defaultConfig {
        if (projectModule == ProjectModule.Main) applicationId = AppVersion.applicationId
        vectorDrawables.useSupportLibrary = true
        minSdk = AndroidSDK.min
        targetSdk = AndroidSDK.target
        versionCode = AppVersion.versionCode
        versionName = AppVersion.versionName
    }
}

internal fun BaseExtension.configureCompileOptions() {
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

internal fun Project.lintOptions() {
    androidApp.run {
        lint {
            checkReleaseBuilds = false
            abortOnError = false
        }
    }
}

fun BaseExtension.packagingOptions() {
    packagingOptions {
        resources.excludes.add("META-INF/*")
        resources.excludes.add("META-INF/licenses/ASM")
        resources.excludes.add("**/attach_hotspot_windows.dll")
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
}