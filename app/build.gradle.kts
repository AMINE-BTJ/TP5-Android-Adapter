plugins {
    alias(libs.plugins.android.application)
}

android {
    flavorDimensionList+="role";
    namespace = "com.example.myapplication"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 24
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures{
        viewBinding=true;
        buildConfig=true;
    }
    productFlavors{
        create("student"){
            dimension="role";
            applicationIdSuffix=".student";
            versionNameSuffix="-student";
        }
        create("admin"){
            dimension="role";
            applicationIdSuffix=".admin";
            versionNameSuffix="-admin";
        }
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}