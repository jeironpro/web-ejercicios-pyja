# web-ejercicios-pyja

Sitio web estático de portafolio que recopila ejercicios de programación en Python y Java. Cada ejercicio incluye su enunciado, tareas a resolver, pistas y un ejemplo de entrada y salida; los ejercicios de Java orientados a objetos incorporan además su diagrama UML. Parte de los ejercicios cuentan con una solucion de ejemplo que se puede consultar desde la propia pagina.

El sitio esta construido con HTML, CSS y JavaScript puro, sin frameworks ni paso de compilacion: los ejercicios se cargan desde archivos JSON y basta con servir la carpeta con cualquier servidor HTTP estatico.

## Contenido

- 100 ejercicios de Python (`json/python.json`).
- 100 ejercicios de Java (`json/java.json`).
- Diagramas UML en SVG para los ejercicios de Java (`img/uml/`).
- Soluciones de ejemplo para 57 ejercicios, distribuidas en `soluciones/` (6 de Python y 51 de Java).

## Funcionalidades

- Pagina de inicio con acceso a las colecciones de Python y Java.
- Listado paginado (10 ejercicios por pagina), ordenado primero por paradigma y despues por nivel de dificultad.
- Etiquetas de nivel (facil, medio, dificil) y de tipo (elementos basicos, programacion orientada a objetos).
- Boton "Ver solucion" en cada ejercicio: abre una modal con el codigo de la solucion resaltado con sintaxis, numeros de linea y cierre con ESC, clic en el fondo o en el boton de cerrar.
- Los ejercicios que aun no tienen solucion muestran el aviso "Solucion proximamente".
- Cabecera fija con efecto de desplazamiento y diseno adaptable a moviles.

## Estructura del proyecto

```
.
├── index.html              Pagina de inicio con acceso a las colecciones
├── python.html             Coleccion de ejercicios de Python
├── java.html               Coleccion de ejercicios de Java
├── css/
│   └── styles.css          Estilos de todas las paginas
├── js/
│   ├── script.js           Efecto de desplazamiento de la cabecera
│   ├── ejercicios.js       Renderizado, paginacion y modal de soluciones
│   └── resaltador.js       Resaltado de sintaxis para Python y Java
├── json/
│   ├── python.json         Ejercicios de Python
│   ├── java.json           Ejercicios de Java
│   └── soluciones.json     Manifest que asocia cada ejercicio con sus archivos de solucion
├── img/                    Logos de los lenguajes y diagramas UML
├── soluciones/
│   ├── python/             Soluciones de Python (una carpeta por ejercicio)
│   └── java/               Soluciones de Java (una carpeta por ejercicio)
│       └── Entrada.java   Utilidad compartida de lectura de la entrada estandar
└── scripts/
    └── generar-soluciones.py   Regenera json/soluciones.json a partir de soluciones/
```

## Formato de los ejercicios

Cada ejercicio de `json/python.json` y `json/java.json` contiene:

- `id`: identificador numerico de dos digitos.
- `titulo`: titulo del ejercicio.
- `nivel`: facil, medio o dificil.
- `tipo`: elemento basico o programacion orientada a objetos.
- `enunciado`: descripcion del problema.
- `tareas`: lista de requisitos que debe cumplir el programa.
- `pistas`: sugerencias para resolverlo.
- `ejemplo`: entrada y salida de ejemplo.
- `uml` (solo ejercicios de Java): ruta al diagrama UML en SVG.

## Como ejecutar el sitio

El sitio requiere un servidor HTTP local porque los datos se cargan con `fetch` (abrir los archivos HTML directamente no funciona). Desde la raiz del proyecto:

```bash
python3 -m http.server 8000
```

Y abrir `http://localhost:8000` en el navegador.

## Como agregar una solucion

1. Crear la carpeta de la solucion en `soluciones/python/` o `soluciones/java/` con el nombre `<id>_<slug>`, donde `<id>` coincide con el campo `id` del ejercicio (por ejemplo, `02_cifrado_escalonado`).
2. Regenerar el manifest:

```bash
python3 scripts/generar-soluciones.py
```

3. Confirmar los cambios.

El manifest `json/soluciones.json` se genera a partir de las carpetas presentes en `soluciones/`; los ejercicios sin carpeta muestran "Solucion proximamente" en el sitio.

Las soluciones de Java que leen datos del usuario usan una utilidad compartida, `soluciones/java/Entrada.java` (un unico archivo para todas). Al ser comun, no se incluye en el manifest ni se muestra en la modal, que muestra unicamente los archivos propios de cada solucion.

## Licencia

Este proyecto esta bajo la licencia MIT. Consulta el archivo [LICENSE](LICENSE) para mas detalles.
