# PRUEBA APPGATE

## Resumen de codificación
---
El código se encuentra documentado y la generación del Documento se realizó con JavaDoc.

## El framework
---
### BDD
---
Se utiliza BDD como framework de automatización para la automatización de los escenarios de prueba, la idea es escribir las pruebas antes de escribir el código fuente, pero en lugar de pruebas unitarias, lo que haremos será escribir pruebas que verifiquen que el comportamiento del código es correcto desde el punto de vista de negocio. Tras escribir las pruebas escribimos el código fuente de la funcionalidad que haga que estas pruebas pasen correctamente.
A partir de aquí, en lugar de describir en 'lenguaje natural' lo que tiene que hacer esa nueva funcionalidad, vamos a usar un lenguaje que nos va a permitir describir todas nuestras funcionalidades de una misma forma, un lenguaje específico para BDD.

### Gherkin
---
Se utiliza Gherkin como lenguaje de desarrollo de las funcionalidades dado que es un lenguaje comprensible por humanos y por ordenadores, con el vamos a definir el comportamiento de la página que vamos a automatizar.
Se trata de un lenguaje fácil de leer, fácil de entender y fácil de escribir. Utilizar Gherkin nos va a permitir crear una documentación viva a la vez que automatizamos los tests, haciéndolo además con un lenguaje que puede entender negocio.
Lo bueno de Gherkin es que para empezar a hacer BDD sólo nos hace falta conocer 5 palabras, con las que construiremos sentencias con las que vamos a describir las funcionalidades:
+ Feature: Indica el nombre de la funcionalidad que vamos a probar. Debe ser un título claro y explícito. Incluimos aquí una descripción en forma de historia de usuario: “Como [rol] quiero [característica] para que [los beneficios]”. Sobre esta descripción empezaremos a construir nuestros escenarios de prueba.
+ Scenario: Describe cada escenario que vamos a probar.
+	Given: Provee contexto para el escenario en que se va a ejecutar el test, tales como punto donde se ejecuta el test, o prerrequisitos en los datos. Incluye los pasos necesarios para poner al sistema en el estado que se desea probar.
+	When: Especifica el conjunto de acciones que lanzan el test. La interacción del usuario que acciona la funcionalidad que deseamos testear.
+	Then: Especifica el resultado esperado en el test. Observamos los cambios en el sistema y vemos si son los deseados.
Lo normal es probar distintos escenarios para comprobar una determinada funcionalidad. De esta forma vamos a pasar de nuestras historias de usuario a pruebas de comportamiento automatizables.

### Cucumber
---
Se utiliza cucumber como herramienta para automatizar las pruebas en BDD. Cucumber nos va a permitir ejecutar descripciones funcionales en texto plano como pruebas de software automatizadas. Totalmente compatible con el lenguaje Gherkin.

### Serenity BDD
---
Serenity es una librería de código abierto que ayuda a escribir pruebas de aceptación automatizadas de mayor calidad y de manera más eficiente.

### Rest-Assured
---
Rest-Assured es un Java DSL (Domain Specific Language) construido sobre la capa HTTP Builder que permite simplificar la construcción de test sobre una API REST. Ofrece una serie de características bastante útiles como sintaxis DSL, validación Xpath, usar JsonPath, registrar parsers para MIME-Types, file upload, verificar cabeceras HTTP o cookies.

### Gestor de dependencias
---
Se crea el proyecto sobre Gradle, se apoya en Groovy y en un DSL (Domain Specific Language) para trabajar con un lenguaje sencillo y claro a la hora de construir el build. Dispone de una gran flexibilidad que permite trabajar con ella utilizando otros lenguajes y no solo Java. Dispone por otro lado de un sistema de gestión de dependencias sólido.

### Patrón de diseño
---
El proyecto se montó sobre el patrón de diseño Page Object Model (POM) (aunque para este ejercicio no se realizó automatización de capa UI), con la siguiente estructura:
+ src/main/java – en esta carpeta se tiene los paquetes de: exceptions, models y utils
+ src/main/resources - en esta carpeta se tiene el archivo: Jenkinsfile
+ src/test/java - en esta carpeta se tiene los paquetes de: stepdefinitions y testrunners
+ src/test/resources - en esta carpeta se tiene los paquetes de: features

### Herramienta de automatización
---
Se utiliza el IDE de IntelliJ para el desarrollo de la automatización. IntelliJ es una plataforma de desarrollo, diseñada para ser extendida de forma indefinida a través de plug-ins. Fue concebida desde sus orígenes para convertirse en una plataforma de integración de herramientas de desarrollo. No tiene en mente un lenguaje específico, sino que es un IDE genérico, aunque goza de mucha popularidad entre la comunidad de desarrolladores del lenguaje Java usando el plug-in JDT que viene incluido en la distribución estándar del IDE.
Proporciona herramientas para la gestión de espacios de trabajo, escribir, desplegar, ejecutar y depurar aplicaciones.

### Configuración entorno de trabajo con gradle
---
Se debe de descargar gradle y crear una variable de entorno GRADLE_HOME con valor C:\gradle-7.1 (Ruta donde se almacenó el gradle) y en el path se debe de añadir %GRADLE_HOME%\bin

### Ejecución de las pruebas
---
Para la ejecución del proyecto luego de descargado se debe de abrir una línea de comando en la raíz de dicho proyecto y ejecutar el siguiente comando: gradle clean test aggregate
clean: se encarga de limpiar la carpeta donde se alojan ejecuciones anteriores
test: se encarga de ejecutar las pruebas
aggregate: se encarga de crear el reporte luego de finalizada la ejecución

### Visualización reporte
---
Luego de finalizada la ejecución del proyecto se va a la raiz de proyecto y se abre el siguiente archivo "\target\site\serenity\index.html" 

### CI/CD
---
+ El proyecto se encuentra alojando en un repositorio Github "https://github.com/seaalvar/appgateprueba"
+ Se creó un servidor Jenkins (local) en donde se creó una tarea llamada appgateprueba en la que se puede ejecutar el proyecto de forma automática.
+ También se creó un pipeline el cual se conecta al archivo Jenkinsfile del proyecto en donde se administra el entorno de integración continua
+ Se configuró el servidor jenkins para que se ejecute automáticamente una vez se realice cualquier cambio dentro del repositorio de código.