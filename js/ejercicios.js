// Renderiza la colección de ejercicios (Python o Java) cargando el JSON indicado en window.CONFIG.jsonUrl.
// Se usa desde python.html y java.html; el bloque UML solo se muestra cuando el ejercicio lo define.

const normalizarCadena = (cadena) => {
    return cadena
        .normalize("NFD")
        .replace(/[\u0300-\u036f]/g, "")
        .toLowerCase()
        .replace(/\s+/g, "-")
        .replace(/[^a-z0-9-]/g, "");
};

let numPagina = 1;
const ordenamientoNivel = ["fácil", "medio", "dificil"];
const ordenamientoParadigma = ["Elementos básicos", "Programación orientada a objetos"];

fetch(window.CONFIG.jsonUrl)
    .then((response) => response.json())
    .then((datos) => {
        const contenedorEjercicios = document.querySelector("#contenedor-ejercicios");
        const ejerciciosPorPagina = 10;
        let paginaActual = 1;

        const ordenNivel = new Map(ordenamientoNivel.map((nivel, i) => [nivel, i]));
        const ordenParadigma = new Map(ordenamientoParadigma.map((paradigma, i) => [paradigma, i]));

        datos.sort((a, b) => ordenNivel.get(a.nivel) - ordenNivel.get(b.nivel));
        datos.sort((a, b) => ordenParadigma.get(a.paradigma) - ordenParadigma.get(b.paradigma));

        const totalPaginas = Math.ceil(datos.length / ejerciciosPorPagina);

        const formatearEjemploTexto = (texto) => {
            if (Array.isArray(texto)) {
                return texto.join("\n");
            }
            return texto;
        };

        const mostrarPagina = (pagina) => {
            numPagina = pagina;
            contenedorEjercicios.replaceChildren();
            paginaActual = pagina;

            const inicio = (pagina - 1) * ejerciciosPorPagina;
            const fin = inicio + ejerciciosPorPagina;
            const ejerciciosPagina = datos.slice(inicio, fin);

            ejerciciosPagina.forEach((ejercicio, i) => {
                const articulo = document.createElement("article");
                articulo.classList.add("ejercicio");

                const indice = String(inicio + i + 1).padStart(2, "0");

                // Titulo
                const h2 = document.createElement("h2");
                h2.classList.add("titulo-ejercicio");
                h2.textContent = `${indice} - ${ejercicio.titulo}`;
                articulo.appendChild(h2);

                // Detalles
                const divDetalles = document.createElement("div");
                divDetalles.classList.add("detalles-ejercicio");

                const spanNivel = document.createElement("span");
                spanNivel.classList.add("dificultad", `nivel-${normalizarCadena(ejercicio.nivel)}`);
                spanNivel.textContent = `Nivel ${ejercicio.nivel}`;
                divDetalles.appendChild(spanNivel);

                const spanTipo = document.createElement("span");
                spanTipo.classList.add("tipo", normalizarCadena(ejercicio.tipo));
                spanTipo.textContent = ejercicio.tipo;
                divDetalles.appendChild(spanTipo);

                articulo.appendChild(divDetalles);

                // Enunciado
                const pEnunciado = document.createElement("p");
                pEnunciado.textContent = ejercicio.enunciado;
                articulo.appendChild(pEnunciado);

                // Tareas
                if (ejercicio.tareas && ejercicio.tareas.length > 0) {
                    const divTareas = document.createElement("div");
                    divTareas.classList.add("tareas-programa");

                    const pTareas = document.createElement("p");
                    const strongTareas = document.createElement("strong");
                    strongTareas.textContent = "El programa debe:";
                    pTareas.appendChild(strongTareas);
                    divTareas.appendChild(pTareas);

                    const ulTareas = document.createElement("ul");
                    ejercicio.tareas.forEach(tarea => {
                        const li = document.createElement("li");
                        li.textContent = tarea;
                        ulTareas.appendChild(li);
                    });
                    divTareas.appendChild(ulTareas);
                    articulo.appendChild(divTareas);
                }

                // Pistas
                if (ejercicio.pistas && ejercicio.pistas.length > 0) {
                    const divPistas = document.createElement("div");
                    divPistas.classList.add("pistas");
                    divPistas.appendChild(document.createTextNode("Pistas:"));

                    const ulPistas = document.createElement("ul");
                    ejercicio.pistas.forEach(pista => {
                        const li = document.createElement("li");
                        li.textContent = pista;
                        ulPistas.appendChild(li);
                    });
                    divPistas.appendChild(ulPistas);
                    articulo.appendChild(divPistas);
                }

                // Ejemplo Code
                if (ejercicio.ejemplo) {
                    const divEjemplo = document.createElement("div");
                    divEjemplo.classList.add("ejemplo-codigo");

                    if (ejercicio.ejemplo.entrada) {
                        const pEntrada = document.createElement("p");
                        const strongEntrada = document.createElement("strong");
                        strongEntrada.textContent = "Entrada:";
                        pEntrada.appendChild(strongEntrada);
                        divEjemplo.appendChild(pEntrada);

                        const preEntrada = document.createElement("pre");
                        preEntrada.textContent = formatearEjemploTexto(ejercicio.ejemplo.entrada);
                        divEjemplo.appendChild(preEntrada);

                        divEjemplo.appendChild(document.createElement("br"));
                    }

                    if (ejercicio.ejemplo.salida) {
                        const pSalida = document.createElement("p");
                        const strongSalida = document.createElement("strong");
                        strongSalida.textContent = "Salida:";
                        pSalida.appendChild(strongSalida);
                        divEjemplo.appendChild(pSalida);

                        const preSalida = document.createElement("pre");
                        preSalida.textContent = formatearEjemploTexto(ejercicio.ejemplo.salida);
                        divEjemplo.appendChild(preSalida);
                    }

                    articulo.appendChild(divEjemplo);
                }

                // UML
                if (ejercicio.uml) {
                    const divUml = document.createElement("div");
                    divUml.classList.add("uml-diagrama");

                    const imgUml = document.createElement("img");
                    imgUml.src = ejercicio.uml;
                    imgUml.alt = "Diagrama UML del ejercicio";
                    divUml.appendChild(imgUml);

                    articulo.appendChild(divUml);
                }

                contenedorEjercicios.appendChild(articulo);
            });

            actualizarPaginacion();
        };

        // Event Listeners Paginación Header
        const btnAnterior = document.getElementById("anterior-pagina");
        const btnSiguiente = document.getElementById("siguiente-pagina");

        if (btnAnterior) {
            btnAnterior.addEventListener("click", () => {
                if (numPagina <= 1) {
                    numPagina = totalPaginas + 1;
                }

                if (numPagina > 1) {
                    numPagina--;
                    mostrarPagina(numPagina);
                }
            });
        }

        if (btnSiguiente) {
            btnSiguiente.addEventListener("click", () => {
                if (numPagina >= totalPaginas) {
                    numPagina = 0;
                }

                if (numPagina < totalPaginas) {
                    numPagina++;
                    mostrarPagina(numPagina);
                }
            });
        }

        // Paginación Inferior
        let paginacionDiv = document.getElementById("paginacion");
        if (!paginacionDiv) {
            paginacionDiv = document.createElement("div");
            paginacionDiv.id = "paginacion";
            contenedorEjercicios.parentNode.appendChild(paginacionDiv);
        }

        const actualizarPaginacion = () => {
            paginacionDiv.replaceChildren();

            for (let i = 1; i <= totalPaginas; i++) {
                const btnPagina = document.createElement("button");
                btnPagina.textContent = i;

                if (i === paginaActual) {
                    btnPagina.disabled = true;
                }

                btnPagina.addEventListener("click", () => mostrarPagina(i));
                paginacionDiv.appendChild(btnPagina);
            }
        };

        mostrarPagina(1);
    })
    .catch((error) => console.error("Error al cargar ejercicios:", error));
