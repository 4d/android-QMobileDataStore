/*
 * Created by Quentin Marciset on 7/2/2020.
 * 4D SAS
 * Copyright (c) 2020 Quentin Marciset. All rights reserved.
 */

import org.gradle.api.JavaVersion

object Versions {
    val android_gradle_plugin = "3.5.2"
    val artifactory = "4.15.2"
    val junit = "4.13"
    val kotlin = "1.3.72"
    val retrofit = "2.9.0"
    val room = "2.2.5"
    val support = "1.1.0"
}

object Config {
    val buildTools = "29.0.2"
    val compileSdk = 29
    val minSdk = 19
    val targetSdk = 29
    val javaVersion = JavaVersion.VERSION_1_8
}

object Tools {
    val artifactory =
        "org.jfrog.buildinfo:build-info-extractor-gradle:${Versions.artifactory}"
    val gradle = "com.android.tools.build:gradle:${Versions.android_gradle_plugin}"
    val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object Libs {

    // Common
    val androidx_appcompat = "androidx.appcompat:appcompat:${Versions.support}"
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    // Room
    val androidx_room = "androidx.room:room-ktx:${Versions.room}"

    // Utils
    val retrofit_converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    // Testing
    val junit = "junit:junit:${Versions.junit}"
}