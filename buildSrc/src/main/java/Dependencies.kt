import org.gradle.api.JavaVersion

object Versions {
    const val android_gradle_plugin = "3.5.2"
    const val artifactory = "4.13.0"
    const val junit = "4.12"
    const val kotlin = "1.3.61"
    const val retrofit = "2.6.2"
    const val room = "2.2.2"
    const val support = "1.1.0"
}

object Config {
    const val minSdk = 19
    const val compileSdk = 29
    const val targetSdk = 29
    const val buildTools = "29.0.2"
    val javaVersion = JavaVersion.VERSION_1_8
}

object Tools {
    const val gradle = "com.android.tools.build:gradle:${Versions.android_gradle_plugin}"
    const val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val artifactory = "org.jfrog.buildinfo:build-info-extractor-gradle:${Versions.artifactory}"
}

object Libs {

    // Common
    const val androidx_appcompat = "androidx.appcompat:appcompat:${Versions.support}"
    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    // Room
    const val androidx_room_runtime = "androidx.room:room-runtime:${Versions.room}"
    const val androidx_room = "androidx.room:room-ktx:${Versions.room}"
    const val androidx_room_compiler = "androidx.room:room-compiler:${Versions.room}"

    // Utils
    const val retrofit_converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    // Testing
    const val junit = "junit:junit:${Versions.junit}"
}