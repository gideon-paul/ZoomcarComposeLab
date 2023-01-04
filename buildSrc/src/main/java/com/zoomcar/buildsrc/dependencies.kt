/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zoomcar.buildsrc

object Libs {
    object Version {
        const val supportLibrary = "1.0.0-beta01"
        const val recyclerView = "1.2.0-alpha02"
        const val appcompat = "1.5.0"
        const val material = "1.6.1"
        const val lifecycle = "2.5.1"
        const val livedata = "2.5.1"
        const val workManager = "2.7.1"
        const val navigation = "2.5.1"
        const val coroutines = "1.3.5"
        const val kotlinCore = "1.1.0"
        const val debugDb = "1.0.6"
        const val dagger = "2.42"
        const val networkLibrary = "1.0.7"
        const val appsFlyer = "6.5.1"
        const val exoPlayer = "2.15.1"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:7.2.2"

    const val junit = "junit:junit:4.13"
    const val robolectric = "org.robolectric:robolectric:4.3.1"

    const val dexter = "com.karumi:dexter:6.0.2"
    const val dls = "com.github.ZoomCar:android-dls:1.2.7"
    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:2.0-alpha-3"
    const val advancedWebView = "com.github.delight-im:Android-AdvancedWebView:v3.2.1"
    const val mvi = "com.zoomcar.zms:mvi:2.0"

    object Google {
        const val firebaseCore = "com.google.firebase:firebase-core:17.5.0"

        const val analytics = "com.google.firebase:firebase-analytics:17.5.0"
        const val crashlytics = "com.google.firebase:firebase-crashlytics:17.1.0"
        const val crashlyticsGradle = "com.google.firebase:firebase-crashlytics-gradle:2.2.1"

        const val gmsGoogleServices = "com.google.gms:google-services:4.3.3"

        const val openSourceLicensesPlugin = "com.google.android.gms:oss-licenses-plugin:0.10.2"
        const val openSourceLicensesLibrary =
            "com.google.android.gms:play-services-oss-licenses:17.0.0"
        //Goole play core
        const val playCore = "com.google.android.play:core:1.10.0"
        const val playCoreKtx = "com.google.android.play:core-ktx:1.8.1"

        //Firebase Performance
        const val firebasePerf = "com.google.firebase:firebase-perf-ktx:20.2.0"
        const val firebasePerfGradlePlugin = "com.google.firebase:perf-plugin:1.4.2"
    }

    object Glide {
        const val version = "4.12.0"
        const val glide = "com.github.bumptech.glide:glide:$version"
        const val annotationGlide = "com.github.bumptech.glide:compiler:$version"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.5.0"
        const val browser = "androidx.browser:browser:1.0.0"
        const val collection = "androidx.collection:collection-ktx:1.1.0"
        const val palette = "androidx.palette:palette:1.0.0"
        const val recyclerview = "androidx.recyclerview:recyclerview:1.2.0-alpha05"
        const val emoji = "androidx.emoji:emoji:1.1.0"
        const val swiperefresh = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"

        object DataStore {
            private const val version = "1.0.0"
            const val preferences = "androidx.datastore:datastore-preferences:$version"
            const val proto = "androidx.datastore:datastore-core:$version"
        }

        object Navigation {
            private const val version = "2.5.1"
            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
            const val ui = "androidx.navigation:navigation-ui-ktx:$version"
            const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
        }

        object Fragment {
            private const val version = "1.5.2"
            const val fragment = "androidx.fragment:fragment:$version"
            const val fragmentKtx = "androidx.fragment:fragment-ktx:$version"
        }

        object Test {
            private const val version = "1.2.0"
            const val core = "androidx.test:core:$version"
            const val rules = "androidx.test:rules:$version"
            const val runner = "androidx.test:runner:$version"

            object Ext {
                private const val version = "1.1.2"
                const val junit = "androidx.test.ext:junit:$version"
                const val junitKtx = "androidx.test.ext:junit-ktx:$version"

                const val truth = "androidx.test.ext:truth:1.3.0"
            }

            const val espressoCore = "androidx.test.espresso:espresso-core:3.2.0"
            const val fragment = "androidx.fragment:fragment-testing:1.2.5"
        }

        const val archCoreTesting = "androidx.arch.core:core-testing:2.1.0"

        object Paging {
            private const val version = "2.1.2"
            const val common = "androidx.paging:paging-common-ktx:$version"
            const val runtime = "androidx.paging:paging-runtime-ktx:$version"
        }

        const val preference = "androidx.preference:preference:1.1.1"

        const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.1.4"

        const val coreKtx = "androidx.core:core-ktx:1.7.0"

        object Lifecycle {
            private const val version = "2.5.1"
            const val extensions = "androidx.lifecycle:lifecycle-extensions:$version"
            const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
            const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        }

        object Room {
            private const val version = "2.4.3"
            const val common = "androidx.room:room-common:$version"
            const val runtime = "androidx.room:room-runtime:$version"
            const val compiler = "androidx.room:room-compiler:$version"
            const val ktx = "androidx.room:room-ktx:$version"
            const val testing = "androidx.room:room-testing:$version"
        }

        object Work {
            private const val version = "2.7.1"
            const val runtimeKtx = "androidx.work:work-runtime-ktx:$version"
        }

        object Compose {
            const val snapshot = ""
            const val kotlinCompilerVersion = "1.7.0"
            const val version = "1.2.0"
            const val coilVersion = "2.2.0"

            @get:JvmStatic
            val snapshotUrl: String
                get() = "https://androidx.dev/snapshots/builds/$snapshot/artifacts/ui/repository/"

            const val core = "androidx.compose.ui:ui:$version"
            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val layout = "androidx.compose.foundation:foundation-layout:$version"
            const val material = "androidx.compose.material:material:$version"
            const val materialIconsExtended =
                "androidx.compose.material:material-icons-extended:$version"
            const val runtime = "androidx.compose.runtime:runtime:$version"
            const val runtimeLivedata = "androidx.compose.runtime:runtime-livedata:$version"
            const val tooling = "androidx.compose.ui:ui-tooling:$version"
            const val test = "androidx.compose.test:test-core:$version"
            const val uiTest = "androidx.compose.ui:ui-test-junit4:$version"
            const val constraintLayout = "androidx.constraintlayout:constraintlayout-compose:1.0.1"
            const val navigation = "androidx.navigation:navigation-compose:2.5.1"
            const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1"
            const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:1.0.0"
            const val coil = "io.coil-kt:coil-compose:$coilVersion"

            object Accompanist {
                const val pagerVersion = "0.26.3-beta"
                const val pager = "com.google.accompanist:accompanist-pager:$pagerVersion"
                const val pageIndicator = "com.google.accompanist:accompanist-pager-indicators:$pagerVersion"
                const val flowlayout = "com.google.accompanist:accompanist-flowlayout:0.25.0"
            }


        }

        object Camera {
            private const val version = "1.0.2"
            const val core = "androidx.camera:camera-camera2:$version"
            const val lifecycle = "androidx.camera:camera-lifecycle:$version"
            const val cameraXView = "androidx.camera:camera-view:1.0.0-alpha27"
            const val exifinterface = "androidx.exifinterface:exifinterface:1.3.3"
        }

        object Hilt {
            private const val version = "1.0.0"
            const val work = "androidx.hilt:hilt-work:$version"
            const val compiler = "androidx.hilt:hilt-compiler:$version"
        }
    }

    object Mockito {
        private const val version = "2.28.2"
        const val core = "org.mockito:mockito-core:$version"
    }

    object MockK {
        private const val version = "1.10.2"
        const val core = "io.mockk:mockk:$version"
        const val android = "io.mockk:mockk-android:$version"
    }

    object Mdc {
        const val material = "com.google.android.material:material:1.6.1"
        const val composeThemeAdapter =
            "com.google.android.material:compose-theme-adapter:1.0.0-alpha01"
    }

    object Hilt {
        private const val version = "2.42"
        const val library = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-android-compiler:$version"
        const val testing = "com.google.dagger:hilt-android-testing:$version"
        const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
    }

    object AssistedInject {
        private const val version = "0.6.0"
        const val annotationDagger2 =
            "com.squareup.inject:assisted-inject-annotations-dagger2:$version"
        const val processorDagger2 =
            "com.squareup.inject:assisted-inject-processor-dagger2:$version"
    }

    object Kotlin {
        private const val version = "1.7.0"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }

    object Coroutines {
        private const val version = "1.6.2"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    object Retrofit {
        private const val version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:$version"
    }

    object OkHttp {
        private const val version = "4.8.1"
        const val okhttp = "com.squareup.okhttp3:okhttp:$version"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object PlayServices {
        const val location = "com.google.android.gms:play-services-location:20.0.0"
        const val maps = "com.google.android.gms:play-services-maps:18.1.0"
        const val composeMap = "com.google.maps.android:maps-compose:2.7.2"
        const val mapUtils = "com.google.maps.android:android-maps-utils:2.4.0"
        const val auth = "com.google.android.gms:play-services-auth:20.3.0"
        const val reCaptcha = "com.google.android.gms:play-services-recaptcha:17.0.1"
        const val authApiPhone = "com.google.android.gms:play-services-auth-api-phone:18.0.1"
    }

    object Facebook {
        private const val version = "15.0.1"
        const val login = "com.facebook.android:facebook-login:$version"
    }

    object Gson {
        private const val version = "2.8.5"
        const val gson = "com.google.code.gson:gson:$version"
    }

    object Truecaller {
        private const val version = "2.7.0"
        const val sdk = "com.truecaller.android.sdk:truecaller-sdk:$version"
    }

    object Juspay {
        private const val version = "2.1.4-rc.01"
        const val sdk = "in.juspay:hypersdk:$version"
    }

    object Simpl {
        private const val version = "1.1.3"
        const val sdk = "com.simpl.android:zeroClicksdk:$version"
    }

    object Xendit {
        private const val version = "3.2.2"
        const val sdk = "com.xendit:xendit-android:$version"
    }

    object ExoPlayer {
        const val exoPlayer = "com.google.android.exoplayer:exoplayer:${Version.exoPlayer}"
    }
}