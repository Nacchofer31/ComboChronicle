package project.plugins

import AppVersion
import HostUrl
import com.android.build.gradle.BaseExtension
import main.ProjectModule

internal fun BaseExtension.configureBuildTypes(projectModule: ProjectModule) {
    val fileProvider = ".fileprovider"
    val provideAuthorityName = "providerAuthority"
    val buildAppIdName = "BUILD_APPLICATION_ID"
    val versionName = "version"
    buildTypes {

        getByName("debug") {
            if (projectModule == ProjectModule.Main) applicationIdSuffix = ".debug"
            debuggable(true)
            isMinifyEnabled = false
            defaultConfig.versionName = AppVersion.versionQA
            if (projectModule == ProjectModule.Data) buildConfigField("String", "HOST", HostUrl.DEBUG.HOST)
            buildConfigField(
                "String",
                buildAppIdName,
                "\"${AppVersion.applicationId.plus(AppVersion.environmentDebug)}\""
            )
            buildConfigField("String", versionName, "\"${AppVersion.versionQA}\"")
            resValue(
                "string",
                provideAuthorityName,
                "\"${AppVersion.applicationId.plus(AppVersion.environmentDebug).plus(fileProvider)}\""
            )
        }

        create("stage") {
            if (projectModule == ProjectModule.Main) applicationIdSuffix = ".stage"
            debuggable(true)
            isMinifyEnabled = true

            buildConfigField("String", versionName, "\"${AppVersion.versionQA}\"")

            if (projectModule == ProjectModule.Data) buildConfigField("String", "HOST", HostUrl.STAGE.HOST)
            buildConfigField(
                "String",
                buildAppIdName,
                "\"${AppVersion.applicationId.plus(AppVersion.environmentStage)}\""
            )
            resValue(
                "string",
                provideAuthorityName,
                "\"${AppVersion.applicationId.plus(AppVersion.environmentStage).plus(fileProvider)}\""
            )
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro", "retrofit2.pro"
            )
        }

        getByName("release") {
            debuggable(false)
            isMinifyEnabled = true
            buildConfigField("String", "HOST", HostUrl.RELEASE.HOST)
            buildConfigField("String", buildAppIdName, "\"${AppVersion.applicationId}\"")
            buildConfigField("String", versionName, "\"${AppVersion.versionName}\"")
            resValue("string", provideAuthorityName, "\"${AppVersion.applicationId.plus(fileProvider)}\"")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro", "retrofit2.pro"
            )
        }
    }
}