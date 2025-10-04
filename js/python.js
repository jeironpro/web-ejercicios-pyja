function normalizarCadena(cadena) {
    return cadena
        .normalize("NFD")
        .replace(/[\u0300-\u036f]/g, "")
        .toLowerCase()
        .replace(/\s+/g, "-")
        .replace(/[^a-z0-9-]/g, "");
}

let numPagina = 1;
const ordenamientoNivel = ["fácil", "medio", "dificil"];
const ordenamientoParadigma = ["Elementos básicos", "Programación orientada a objetos"]

fetch("json/python.json")
    .then((response) => response.json())
    .then((data) => {
        const contenedor = document.querySelector("main");
        const ejerciciosPorPagina = 10;
        let paginaActual = 1;

        const ordenNivel = new Map(ordenamientoNivel.map((nivel, i) => [nivel, i]));
        const ordenParadigma = new Map(ordenamientoParadigma.map((paradigma, i) => [paradigma, i]));

        data.sort((a, b) => ordenNivel.get(a.nivel) - ordenNivel.get(b.nivel));
        data.sort((a, b) => ordenParadigma.get(a.paradigma) - ordenParadigma.get(b.paradigma));

        const totalPaginas = Math.ceil(data.length / ejerciciosPorPagina);

        function formatearEjemploTexto(texto) {
            if (Array.isArray(texto)) {
                return texto.join("\n");
            }
            return texto;
        }

        // Función que muestra los ejercicios de una página concreta
        function mostrarPagina(pagina) {
            numPagina = pagina;
            contenedor.innerHTML = ""; // limpiar contenido antes de mostrar la nueva página
            paginaActual = pagina;

            const inicio = (pagina - 1) * ejerciciosPorPagina;
            const fin = inicio + ejerciciosPorPagina;
            const ejerciciosPagina = data.slice(inicio, fin);

            ejerciciosPagina.forEach((ejercicio, i) => {
                const articulo = document.createElement("article");
                articulo.classList.add("ejercicio");

                const indice = String(inicio + i + 1).padStart(2, "0");

                articulo.innerHTML = `
                    <h2 class="titulo-ejercicio">${indice} - ${ejercicio.titulo}</h2>
                    <div class="detalles-ejercicio">
                        <span class="dificultad nivel-${normalizarCadena(ejercicio.nivel)}">Nivel ${ejercicio.nivel}</span>
                        <span class="tipo ${normalizarCadena(ejercicio.tipo)}">${ejercicio.tipo}</span>
                    </div>
                    <p>${ejercicio.enunciado}</p>
                    <div class="tareas-programa">
                        <p><strong>El programa debe:</strong></p>
                        <ul>${ejercicio.tareas.map((t) => `<li>${t}</li>`).join("")}</ul>
                    </div>
                    <div class="pistas">
                        Pistas:
                        <ul>${ejercicio.pistas.map((p) => `<li>${p}</li>`).join("")}</ul>
                    </div>
                `;

                if (ejercicio.ejemplo) {
                    const ejemploDiv = document.createElement("div");
                    ejemploDiv.classList.add("ejemplo-codigo");

                    const entradaHTML = ejercicio.ejemplo.entrada
                        ? `<p><strong>Entrada:</strong></p><pre>${formatearEjemploTexto(
                            ejercicio.ejemplo.entrada
                        )}</pre><br>`
                        : "";

                    const salidaHTML = ejercicio.ejemplo.salida
                        ? `<p><strong>Salida:</strong></p><pre>${formatearEjemploTexto(
                            ejercicio.ejemplo.salida
                        )}</pre>`
                        : "";

                    ejemploDiv.innerHTML = `
                ${entradaHTML}
                ${salidaHTML}
            `;
                    articulo.appendChild(ejemploDiv);
                }

                contenedor.appendChild(articulo);
            });

            // Actualizar controles de paginación
            actualizarPaginacion();
        }

        // Paginación del header de la pagina
        document.getElementById("anterior-pagina").addEventListener("click", () => {
            if (numPagina <= 1) {
                numPagina = 11;
            }

            if (numPagina > 1) {
                numPagina--;
                mostrarPagina(numPagina);
            }
        });

        document.getElementById("siguiente-pagina").addEventListener("click", () => {
            if (numPagina >= 10) {
                numPagina = 0;
            }
            
            if (numPagina < 10) {
                numPagina++;
                mostrarPagina(numPagina);
            }
        });

        // Crear los botones de paginación debajo del contenedor principal
        const paginacionDiv = document.createElement("div");
        paginacionDiv.id = "paginacion";
        paginacionDiv.style.marginTop = "20px";
        paginacionDiv.style.textAlign = "center";
        contenedor.after(paginacionDiv);


        // Función que crea o actualiza los botones de paginación
        function actualizarPaginacion() {
            paginacionDiv.innerHTML = "";

            // Botones de páginas numeradas
            for (let i = 1; i <= totalPaginas; i++) {
                const btnPagina = document.createElement("button");
                btnPagina.textContent = i;

                if (i === paginaActual) {
                    btnPagina.disabled = true;
                    btnPagina.style.fontWeight = "bold";
                }

                btnPagina.onclick = () => mostrarPagina(i);
                paginacionDiv.appendChild(btnPagina);
            }
        }

        // Mostrar la primera página al cargar
        mostrarPagina(1);
    })
    .catch((error) => console.error("Error al cargar ejercicios:", error));
