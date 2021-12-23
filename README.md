Introduction
============
The repository contains example projects , which are integrated with the sealights maven
 and gardle plugins. 
 * example-java8 - java8 specific stuff: streams, lambdas etc.
 * example-junit5 - a combination of JUnit5 and JUnit4 tests.
 * example-junit-only - JUnit4 tests, some using the PowerMock.
 * example-junit-testng - a combination of JUnit4 and TestNG tests
 * example-testng-only - TestNG tests, some using the PowerMock (only for Maven plugin).

Build types
=========== 
Any example project may be built individually. 
 
All examples may be built all together from the root project.

By default the example projects are built without sealights.

Build with sealights
--------------------
Similar to a regular build, the build with sealights may be done for all the examples together
 or to a single example. 
 
When all the examples are built together the same application name is used for all the projects. 
 
When a single example is built, its own application name is used.

For both plugins all the plugin parameters are defined in the root project and they are inherited by 
the examples.

Each example redefines the **appName** plugin parameter.

Maven examples
==============
**Profiles**
1. The default profile executes just a regular build without sealights plugin.
 The maven command is executed in the same way for either root project or any sub-project.
2. The profile **'sl'** executes a build of a sub-project as an individual application. 
It is intended for a subproject build and so is not effective if applied to the root project.
See the Examples section for usage.
3. The profile **'sl-all'** executes a build of all sub-projects with the same application name. 
It is intended for root recursive build of the root project. 
When it is applied to the sub-project, it works same as the **'sl'** profile.
See the Examples section for usage.

**Plugin Parameters** 
1. The plugin parameters are defined in the pom of the root project; 
the sub-projects poms contain only **appName** parameter.
2. Build number should be provided as system property _'-Dsl.build={build value}_ 
on any build with _'sl'_ or _'sl-all'_ profile.

**Examples**
1. Build all projects as a single application. Run from the root project directory:

   _mvn clean install -Psl-all -Dsl.build=12345_
2. Build a particular project from the root project directory:

   _mvn clean install -f example-java8 -Psl -Dsl.build=12345_  
   
3. Build a particular project from the project directory:
   
   _mvn clean install -Psl -Dsl.build=12345_  
   
Gradle examples
===============
**Build parameters**
1. By default the regular build is executed.
2. The option **'-P sl'** or **'-Psl'** stands for build with the sealights plugin for either root or sub-project.
See the Examples section for usage.
3. The option **'-P all'** or **'-Pall'** stands for build with the sealights plugin of all projects as a single application. 
It is affective only together with **'-P sl'**.
See the Examples section for usage.

**JUnit5 support**
1. The system property **'-Djunit5=true'** should be provided for build of a project with junit5 tests. 
This property is needed for any build - with or without sealights options.
See the Examples section for usage.
2. Project with junit5 demands the min gradle version 4.6. 
If the default gradle version on the path is less than 4.6, the explicit path to the gradle 4.6 should be used 
in the build command. See the Examples section for usage.

**Plugin Parameters** 
1. The plugin parameters are defined in the build.gradle of the root project; the sub-projects build.gradle contain only **appName** parameter.
2. Build number should be provided as system property _'-Dsl.build={build value}'_ on any build with _'-P sl'_ option.

**Examples**
1. Build all projects with sealights as a single application. Run from the root project directory:

    _/path/to/gradle-4.6/gradle build test -P sl -P all -Djunit5=true -Dsl.build=12345_
2. Same as above example, but with the default gradle version 4.6 or higher. Run from the root project directory:
    
    _gradle build test -P sl -P all -Djunit5=true -Dsl.build=12345_
3. Build a particular project with sealights **should be run from the subproject directory**:

   _gradle build test -P sl -Dsl.build=12345_
 4. Build a particular project with sealights and junit5 tests:
 
    _/path/to/gradle-4.6/gradle build test -P sl -Djunit5=true -Dsl.build=12345_
   