# Java OOP Education

This repository contains various sample applications and educational materials for learning Java Object-Oriented Programming (OOP).

implementations.

# udemy education program
「元Microsoftエンジニア直伝｜AI時代に通用するJavaの本質とプロの設計思想~OOP編~」
https://www.udemy.com/course/og-java-oop/

## Features

*   Multiple sample applications demonstrating various OOP concepts.
*   Built with Java and Gradle.
*   Uses Gson for data handling (in some examples).

## Requirements

*   Java 17 or higher (as specified in `app/build.gradle`).

## Installation and Build

1.  Clone the repository:
    ```sh
    git clone <repository-url>
    cd java-oop-education
    ```

2.  Build all sample applications:
    ```sh
    ./gradlew build
    ```
    This command compiles all Java source files within the `app/src/main/java/oop` directory.

## How to Run Specific Sample Applications

Since this project contains multiple independent sample applications, you will need to specify which one to run.

To run a specific application, you can use the `java` command directly after building. For example, if you want to run an application located at `app/src/main/java/oop/chapter_01/MyApplication.java` (assuming `MyApplication` has a `main` method), you would first build the project and then execute:

```sh
java -cp app/build/classes/java/main oop.chapter_01.MyApplication
```

Replace `oop.chapter_01.MyApplication` with the fully qualified name of the class you wish to run.

For the RPG application, you can run it using:

```sh
java -cp app/build/classes/java/main:app/build/resources/main:app/libs/* rpg.App
```

Alternatively, you can run a specific application using Gradle's `run` task with the `-PmainClass` option. This is often more convenient:

```sh
./gradlew run -PmainClass=oop.chapter_01.part01.App_0101
```

Replace `oop.chapter_01.part02.App` with the fully qualified name of the class you wish to run. Note that this requires the `application` plugin to be applied in `app/build.gradle` and the specified class to have a `main` method.

(Note: The `mainClass` in `app/build.gradle` is currently removed to allow all samples to compile. The `-PmainClass` option overrides this setting for the `run` task.)

## License

This project is licensed under the Mozilla Public License Version 2.0.
*   US: https://www.mozilla.org/en-US/MPL/2.0/
*   JP: https://www.mozilla.jp/documents/mpl/2.0/
```
