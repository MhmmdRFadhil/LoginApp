object Dependencies {
    object BuildPlugin {
        val hilt by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Versions.daggerVersion}" }
        val navigation by lazy { "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navVersion}" }
    }

    object Deps {
        val core by lazy { "androidx.core:core-ktx:${Versions.coreVersion}" }
        val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompatVersion}" }
        val material by lazy { "com.google.android.material:material:${Versions.materialVersion}" }
        val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constrainVersion}" }
        val jUnit by lazy { "junit:junit:${Versions.jUnitVersion}" }
        val jUnitTest by lazy { "androidx.test.ext:junit:${Versions.jUnitTestVersion}" }
        val espresso by lazy { "androidx.test.espresso:espresso-core:${Versions.espressoVersion}" }

        // LIFECYCLE
        val lifecycleViewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModelVersion}" }
        val lifecycleLiveData by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.viewModelVersion}" }

        // DAGGER HILT
        val hiltAndroid by lazy { "com.google.dagger:hilt-android:${Versions.daggerVersion}" }
        val hiltCompiler by lazy { "com.google.dagger:hilt-compiler:${Versions.daggerVersion}" }

        // ROOM
        val roomRuntime by lazy { "androidx.room:room-runtime:${Versions.roomVersion}" }
        val roomCompiler by lazy { "androidx.room:room-compiler:${Versions.roomVersion}" }
        val roomKtx by lazy { "androidx.room:room-ktx:${Versions.roomVersion}" }

        // RETROFIT
        val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}" }
        val retrofitConverterGson by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}" }

        // OKHTTP
        val okHttpLoggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpLoggingVersion}" }

        //NAVIGATION
        val navigationFragment by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}" }
        val navigationUi by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}" }

        // PAGING
        val paging by lazy { "androidx.paging:paging-runtime-ktx:${Versions.pagingVersion}" }

        // GLIDE
        val glide by lazy { "com.github.bumptech.glide:glide:${Versions.glideVersion}" }
        val glideCompiler by lazy { "com.github.bumptech.glide:compiler:${Versions.glideVersion}" }

        // SMART SNACK BAR
        val smartSnackBar by lazy { "io.github.vincent-series:smart-snackbar:${Versions.smartSnackBarVersion}" }

        // SMART TOAST
        val smartToast by lazy { "io.github.vincent-series:smart-toast:${Versions.smartToastVersion}" }
        val smartToastCompiler by lazy { "io.github.vincent-series:annotation-compiler:${Versions.smartToastCompiler}" }

        // LOTTIE
        val lottie by lazy { "com.airbnb.android:lottie:${Versions.lottieVersion}" }
    }
}