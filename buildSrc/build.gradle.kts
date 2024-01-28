plugins {
    `kotlin-dsl`
}
repositories{
    google()
    mavenCentral()
    gradlePluginPortal()
}

java{
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

kotlinDslPluginOptions {
    jvmTarget.set("11")
}

sourceSets.getByName("main") {
    java.srcDir("src/main/kotlin")
}

/**
 * Gradle Upadate
 * Values of variant API AnnotationProcessorOptions.arguments are queried and may return non final values, this is unsupported
 * https://issuetracker.google.com/issues/247906487
 */
dependencies {
    implementation("com.android.tools.build:gradle:7.4.2")
    implementation("com.android.tools.build:gradle-api:7.4.0")
    implementation("org.jlleitschuh.gradle:ktlint-gradle:11.6.1")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.19.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
    implementation(gradleApi())
    implementation("com.squareup:javapoet:1.13.0")
}

//echarle un ojo a esto https://discuss.gradle.org/t/how-to-pass-parameters-to-a-plugin-during-apply/22144/4
//poder pasar unos parametros de configuracion.
gradlePlugin {
   plugins{
       register("appMainModule") {
           id = "appMainModule"
           implementationClass = "project.AppMainModule"
       }
       register("domain"){
           id = "domain"
           implementationClass = "project.DomainModule"
       }
       register("data"){
           id = "data"
           implementationClass = "project.DataModule"
       }
       register("feature"){
           id = "feature"
           implementationClass = "project.FeatureModule"
       }
       register("androidHiltPlugin") {
           id = "androidHiltPlugin"
           implementationClass = "project.plugins.AndroidHiltConventionPlugin"
       }
       register("androidNavigationPlugin") {
           id = "androidNavigationPlugin"
           implementationClass = "project.plugins.AndroidNavigationConventionPlugin"
       }
   }
}


