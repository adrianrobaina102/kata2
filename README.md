# Kata 2 - Entrada, salida y carga de datos

## Objetivo de la Entrega
El objetivo de esta entrega es construir un programa capaz de leer un conjunto de datos (dataset de videojuegos en formato CSV) desde distintos tipos de entrada (`InputStream`), transformar cada fila en una entidad de dominio estructurada, calcular un resumen de frecuencias (estadísticas por género), y escribir el resultado en un destino de salida (`OutputStream`). Todo esto manteniendo una arquitectura limpia y separando la lógica de negocio de los orígenes y destinos de los datos.

## Vídeo Explicativo
- **Enlace al vídeo (YouTube):** https://youtu.be/aKuGQkpJe2U
- **Duración aproximada:** 6:22

## Requisitos y Entorno
- **JDK:** Oracle OpenJDK 27
- **Gestor de dependencias:** Maven
- **IDE:** IntelliJ IDEA
- **Dependencias externas:** Ninguna. Se han utilizado las librerías estándar de Java para la gestión de I/O (`java.io.*`) y red (`java.net.*`).

## Estructura del Proyecto
El código se organiza bajo el paquete `software.ulpgc.katas`, separando claramente las responsabilidades:

- **Paquete `model` (Dominio):**
    - `VideoGame`: Clase inmutable modelada como *record* que representa una fila del dataset.
    - `Genre`: *Enum* para tipar fuertemente los géneros de los videojuegos.
    - `GenreStats`: *Record* que encapsula las estadísticas (frecuencias) calculadas.

- **Paquete `io` (Entrada/Salida):**
    - `VideoGameLoader`: Interfaz para la carga de datos.
    - `UrlVideoGameLoader` / `FileVideoGameLoader`: Implementaciones que leen los datos desde una URL y desde un archivo local físico, respectivamente.
    - `VideoGameSummaryWriter`: Interfaz para la escritura de resultados.
    - `StreamVideoGameSummaryWriter`: Implementación que recibe un `OutputStream` (flexibilidad para apuntar a consola, memoria o fichero) y formatea la salida.

- **Clases Principales:**
    - `Main`: Clase de ejecución orquestando la carga por URL.
    - `Main2`: Clase de ejecución orquestando la carga por archivo local (demostrando la variación de origen de datos).

## Flujo Git y Proceso de Repetición
- **Ramas:** Rama de producción `master` y rama de evolución funcional `develop`.
- **Iteraciones (Commits atómicos):** Para reducir la fricción técnica, la kata se desarrolló de forma iterativa en bloques:
    - *Bloque 1:* Arquitectura base, entidades y carga de datos desde URL.
    - *Bloque 2:* Cálculo de estadísticas y escritura redirigida a consola.
    - *Bloque 3 (Variación):* Creación de un nuevo origen de datos con `FileVideoGameLoader` leyendo un fichero local, sin alterar la lógica de transformación.
- **Integración:** Se realizó la integración de `develop` hacia `master` mediante un merge limpio al finalizar todos los bloques.

## Compilación y Ejecución
1. Abrir el proyecto en IntelliJ IDEA.
2. Esperar a que el IDE indexe y descargue las dependencias de Maven del `pom.xml`.
3. Navegar a `src/main/java/software/ulpgc/katas/Main.java` (prueba con URL) o a `Main2.java` (prueba con fichero local).
4. Ejecutar la clase pulsando el atajo Shift + F10 (o clic derecho > Run 'Main.main()' / 'Main2.main()').

## Verificación y Clonado Limpio
Para verificar la reproducibilidad e independencia del proyecto fuera del entorno original:
1. Copiar la URL HTTPS del repositorio público en GitHub.
2. En IntelliJ IDEA, seleccionar File > New > Project from Version Control...
3. Pegar la URL, elegir un directorio destino limpio y hacer clic en Clone.
4. Abrir la clase `Main` o `Main2` y ejecutarla para validar que compila e imprime la salida correctamente desde cero.