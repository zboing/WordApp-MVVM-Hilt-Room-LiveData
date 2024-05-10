plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.github.wordapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.github.wordapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")

    val hilt_version = "2.48"
    implementation("com.google.dagger:hilt-android:$hilt_version")
    //annotationProcessor("com.google.dagger:hilt-android-compiler:$hilt_version")
    kapt ("com.google.dagger:hilt-android-compiler:$hilt_version")
    //kapt ("com.google.dagger:dagger-compiler:$hilt_version")

    val room_version = "2.6.1"
    implementation("androidx.room:room-runtime:$room_version")
    // Kotlin Extensions and Coroutines support for Room
    implementation ("androidx.room:room-ktx:$room_version")
    //annotationProcessor("androidx.room:room-compiler:$room_version")
    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:$room_version")
    // To use Kotlin Symbol Processing (KSP)
    //ksp("androidx.room:room-compiler:$room_version")

    val lifecycle_version = "2.7.0"
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    kapt ("androidx.lifecycle:lifecycle-compiler:$lifecycle_version")

    implementation ("com.afollestad.material-dialogs:core:3.3.0")
    implementation ("com.afollestad.material-dialogs:input:3.3.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}