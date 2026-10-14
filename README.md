# Kata 2 - Entrada, salida y carga de datos

## Objetivo de la Entrega
Construir un programa capaz de leer un dataset en formato CSV desde distintos tipos de entrada (`InputStream`), transformar los datos en entidades de dominio, calcular estadísticas mediante lógica separada, y escribir el resultado en un destino de salida (`OutputStream`). Todo esto manteniendo una arquitectura limpia y modular.

## Vídeo Explicativo
- **Enlace al vídeo (YouTube):** https://youtu.be/aKuGQkpJe2U
- **Duración aproximada:** 6:22

> **Nota de Refactorización (Post-Vídeo):**
> En la demostración grabada se muestra una versión funcional inicial (usando `Files.readAllLines` y un único destino de salida por consola). Tras la grabación, se realizó una refactorización final para alinearse estrictamente con la rúbrica:
> 1. Se implementó el uso explícito de `FileInputStream` en la lectura local física.
> 2. Se instanció el escritor con dos destinos de salida simultáneos (consola mediante `System.out` y fichero mediante `FileOutputStream`).

## Entorno y Requisitos
- **JDK:** Oracle OpenJDK 27 | **Gestor:** Maven | **IDE:** IntelliJ IDEA
- **Dependencias:** Ninguna externa. Uso exclusivo de las librerías estándar de Java (`java.io.*` y `java.net.*`).

## Estructura del Proyecto
El código se organiza bajo el paquete `software.ulpgc.katas`, separando responsabilidades:

- **Paquete `model` (Dominio):** Entidades modeladas como *records* inmutables, *enums* para tipar categorías, y clases de estado (`GenreStats`) para encapsular los resultados.
- **Paquete `io` (Entrada/Salida):** Interfaces genéricas (`...Reader`, `...Writer`) y sus implementaciones para procesar datos desde URL o fichero físico, y formatear la salida a través de un `OutputStream`.
- **Paquete `control` (Lógica de Negocio):** Clases (`...Analyzer`) encargadas de procesar las colecciones y calcular estadísticas. *(Nota sobre evolución arquitectónica: Este patrón de separación se introdujo en la Iteración 2; en la Iteración 1 base, la lógica de frecuencia se mantuvo en la orquestación principal y se encapsuló en `GenreStats`).*
- **Clases Principales:** `Main` (orquesta la carga remota) y `Main2` (orquesta la carga local y demuestra la escritura en múltiples destinos).

## Práctica Deliberada (Iteraciones)
Para cumplir con el requisito de asimilación de conceptos, la arquitectura se ha aplicado desde cero a distintos dominios, aislados en ramas independientes:
- **Rama `master`:** Iteración 1 - Dataset de Videojuegos (Principal, demostrada en vídeo).
- **Rama `iteration-2`:** Iteración 2 - Dataset de Empleados.
- **Rama `iteration-3`:** Iteración 3 - Dataset de Flores Iris.

## Flujo Git y Proceso de Desarrollo
- **Ramas base:** Rama de producción `master` y rama de evolución funcional `develop`.
- **Desarrollo iterativo:** Para reducir la fricción técnica, el código se desarrolló mediante commits atómicos en bloques lógicos (primero la arquitectura base y entidades, luego el cálculo de estadísticas, y finalmente las variaciones de lectura local y escritura múltiple).
- **Integración:** Se realizaron integraciones hacia las ramas principales mediante merges limpios asegurando la estabilidad funcional.

## Ejecución Rápida y Verificación
1. Clonar el repositorio y abrir en IntelliJ IDEA.
2. Esperar a que el IDE indexe y descargue las dependencias del `pom.xml`.
3. Navegar a `Main` (URL) o `Main2` (Fichero local) de la iteración deseada.
4. Ejecutar la clase (Shift + F10) para validar que compila e imprime la salida correctamente.