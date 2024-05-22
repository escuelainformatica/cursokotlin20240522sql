# cursokotlin20240522sql

## modificar el primer gradle.

* modificar el primer gradle build.gradle.kts (Project) y agregar
id("com.google.devtools.ksp") version "1.9.23-1.0.20" apply false

* ir a libs.versions.toml y revisar la siguiente version
kotlin = "1.9.23"

Luego agrege en versions:
roomRuntime = "2.6.1"
Y en libraries:
androidx-room-runtime = { module = "androidx.room:room-runtime", version.ref = "roomRuntime" }

* Y sincronice.

* editar el otro build.gradle.kts (Module:app) y agregar

en plugins agregar
```
    id("com.google.devtools.ksp")
```

Modificar la version del compilador:
```
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.13"
    }
```

dentro de dependencies:
```
    val room_version = "2.6.1"

    implementation(libs.androidx.room.runtime)
    annotationProcessor("androidx.room:room-compiler:$room_version")

    // To use Kotlin annotation processing tool (kapt)
    //kapt("androidx.room:room-compiler:$room_version")
    // To use Kotlin Symbol Processing (KSP)
    ksp("androidx.room:room-compiler:$room_version")

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$room_version")

    // optional - RxJava2 support for Room
    implementation("androidx.room:room-rxjava2:$room_version")

    // optional - RxJava3 support for Room
    implementation("androidx.room:room-rxjava3:$room_version")

    // optional - Guava support for Room, including Optional and ListenableFuture
    implementation("androidx.room:room-guava:$room_version")

    // optional - Test helpers
    testImplementation("androidx.room:room-testing:$room_version")

    // optional - Paging 3 Integration
    implementation("androidx.room:room-paging:$room_version")
```

# Probar el codigo
Si quiero probarlo en el emulador y quiero acceder a las carpetas, necesito una version del emulador especial que no sea google play
Si quiero trabajar en una maquina real, necesito permisos de desarrollador (o a veces permisos root)

