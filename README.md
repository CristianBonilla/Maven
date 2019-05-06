# Maven

Es una herramienta de software que sirve para construcción y gestión de proyectos java, creado en el año 2002. Es un estandar en la construcción de los proyectos java, evita descargar los (.jar) para no tener que almacenarlos en el proyecto actual, ya que presenta problemas a la hora de cambiar a otro equipo o que los (.jar) dejan de funcionar y hay que bajarlos nuevamente. Uno de los beneficios es la compilación de proyectos para estructurarlos de forma ordenada por medio de un archivo en formato xml llamado pom.xml.

## Instalación

### Windows

Descargar maven desde la página oficial: [a link](https://maven.apache.org/download.cgi)

* Ir a la configuración avanzada del sistema
* Variables de entorno (tener en cuenta si está JAVA_HOME configurado que es la ruta del JDK descomprimido como variable de entorno o sino incluirlo).
* Crear dos variables de entorno M2_HOME y MAVEN_HOME con la ruta de maven de donde se especificó anteriormente.
* luego editar el Path para agregar una nueva referencia %M2_HOME%\bin, Aceptar (reiniciar si es necesario).
* Abrir el CMD y ejecutar el comando **mvn -v** para visualizar la versión.

### Linux

Verificar si está instalado el JDK antes de proceder, para verificar ejecutar el comando **java -version** en caso que no se reconozca hay que incluirlo.

* ejecutar el comando **sudo apt install maven**, aceptar y continuar.
* ejecutar el comando **mvn -v** para visualizar la versión.

## Creando el proyecto

Dirigirse a la carpeta o ruta específica para proceder con la creación del proyecto, abrir el terminal o línea de comandos con la ruta misma y ejecutar el comando **mvn archetype:generate -DgroupId=com.maven.example -DartifactId=simple-app**

* **mvn archetype:generate**, es el comando para poder crear un nuevo proyecto, es la reciente ya que la anterior era create.
* **-DgroupId=com.maven**, es sobre la estructura que el proyecto va a tener y que se va a diferenciar con otros proyectos.
* **-DartifactId=simple-app**, es el nombre del compilado del proyecto, es un jar o war.
* **-interactiveMode=false**, no saldrán las opciones, las asumirá por defecto.
* **-DarchetypeArtifactId=maven-archetype-quickstart**, especifica que tipo de proyecto se creará, por defecto es java application.
* **-DarchetypeArtifactId=maven-archetype-webapp**, para crear un proyecto tipo web.

## POM.xml

Esta en formato xml, que significan Project Object Model (Modelo de objeto de proyecto), es una pieza fundamental, contiene información sobre el proyecto y detalles de configuración para construir el proyecto. Contiene valores por defecto para la mayoría de proyectos. Se conoce como **Super POM** que es la descripción sobre cómo maven internamente hace la compilación, el empaquetamiento y demás. Un **Minimal POM**, presenta el modelo de la versión, el groupId, artifactId.

## Alcance de la dependencia

Se usa para limitar la transitividad de una dependencia y también para afectar la ruta de clase utilizada para varias tareas de compilación.

* **compile**, Alcance predeterminado, va estar disponible en los .classpaths del proyecto, quiere decir en todas las referencias cuando cargue el proyecto.
* **provided**, Es parecido al **compile**, pero indica que espera a que el JDK provee la librería en tiempo de ejecución.
* **runtime**, No es necesario el tiempo de compilación, pero si para la ejecución, ejemplo si la librería JDBC puede compilarse, pero si no se encuentra no va a funcionar el proyecto.
* **test**, Solo aquellas librerías que se utilizarán para fines de pruebas.
* **system**, Similar a **provided**, pero hay que definir el JAR mas explicita.
* **import**, Tiene que ver con dependencias de tipo pom en una sección de **dependencyManagement**

Las más comunes son **compile**, **provided**, **runtime** y **test**.

### mvn install

Abrir el terminal con la ruta del proyecto creado de java con maven, ejecutar el comando **mvn clean**, después el comando **mvn install**, esto se realiza por cada cambio que se realice en el proyecto si se va usar como dependencia en otro proyecto o reinstalar todas las dependencias.
**mvn install**, es un comando muy importante para poder instalar las dependencias de forma local y que maven lo reconozca para usarlo en otros proyectos.