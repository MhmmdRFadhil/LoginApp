plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
    id("com.google.devtools.ksp")
    id("androidx.navigation.safeargs")
}

android {
    namespace = "com.ryz.loginapp"
    compileSdk = (ConfigData.compileSdkVersion)

    defaultConfig {
        applicationId = "com.ryz.loginapp"
        minSdk = (ConfigData.minSdkVersion)
        targetSdk = (ConfigData.targetSdkVersion)
        versionCode = (ConfigData.versionCode)
        versionName = (ConfigData.versionName)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        javaCompileOptions {
            annotationProcessorOptions {
                arguments += mapOf(
                    "room.schemaLocation" to "$projectDir/schemas",
                    "room.incremental" to "true",
                    "room.expandProjection" to "true"
                )
            }
        }

        ksp {
            arg("room.schemaLocation", "$projectDir/schemas")
        }
    }

    buildTypes {
        debug {
            isDebuggable = true
            isMinifyEnabled = false
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        flavorDimensions.add("api")

        productFlavors {
            create("dev") {
                this.dimension = "api"
                buildConfigField("String", "BASE_URL", "\"https://reqres.in/\"")
            }
            create("prod") {
                this.dimension = "api"
                buildConfigField("String", "BASE_URL", "\"https://reqres.in/\"")
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        buildConfig = true
        viewBinding = true
    }
}

dependencies {
    implementation(Dependencies.Deps.core)
    implementation(Dependencies.Deps.appCompat)
    implementation("com.google.android.material:material:1.11.0")
    implementation(Dependencies.Deps.constraintLayout)

    // VIEW MODEL
    implementation(Dependencies.Deps.lifecycleLiveData)
    implementation(Dependencies.Deps.lifecycleViewModel)

    // DAGGER HILT
    implementation(Dependencies.Deps.hiltAndroid)
    kapt(Dependencies.Deps.hiltCompiler)

    // ROOM
    implementation(Dependencies.Deps.roomRuntime)
    implementation(Dependencies.Deps.roomKtx)
    ksp(Dependencies.Deps.roomCompiler)

    // RETROFIT
    implementation(Dependencies.Deps.okHttpLoggingInterceptor)
    implementation(Dependencies.Deps.retrofitConverterGson)
    implementation(Dependencies.Deps.retrofit)

    // NAVIGATION GRAPH
    implementation(Dependencies.Deps.navigationFragment)
    implementation(Dependencies.Deps.navigationUi)

    // PAGING
    implementation(Dependencies.Deps.paging)

    // GLIDE
    implementation(Dependencies.Deps.glide)
    ksp(Dependencies.Deps.glideCompiler)

    // SMART SNACK BAR & TOAST
    implementation(Dependencies.Deps.smartSnackBar)
    implementation(Dependencies.Deps.smartToast)
    kapt(Dependencies.Deps.smartToastCompiler)

    // LOTTIE
    implementation(Dependencies.Deps.lottie)

    // TESTING
    testImplementation(Dependencies.Deps.jUnit)
    androidTestImplementation(Dependencies.Deps.jUnitTest)
    androidTestImplementation(Dependencies.Deps.espresso)
}