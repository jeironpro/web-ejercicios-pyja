function normalizarCadena(texto) {
  return texto
    .normalize("NFD")
    .replace(/[\u0300-\u036f]/g, "")
    .toLowerCase()
    .replace(/\s+/g, "-")
    .replace(/[^a-z0-9-]/g, "");
}

fetch("json/python.json")
  .then((response) => response.json())
  .then((data) => {
    const contenedor = document.querySelector("main");
    const ejerciciosPorPagina = 10;
    let paginaActual = 1;
    const totalPaginas = Math.ceil(data.length / ejerciciosPorPagina);

    function formatearEjemploTexto(texto) {
      if (Array.isArray(texto)) {
        return texto.join("\n");
      }
      return texto;
    }

    // Función que muestra los ejercicios de una página concreta
    function mostrarPagina(pagina) {
      contenedor.innerHTML = ""; // limpiar contenido antes de mostrar la nueva página
      paginaActual = pagina;

      const inicio = (pagina - 1) * ejerciciosPorPagina;
      const fin = inicio + ejerciciosPorPagina;
      const ejerciciosPagina = data.slice(inicio, fin);

      ejerciciosPagina.forEach((ejercicio) => {
        const articulo = document.createElement("article");
        articulo.classList.add("ejercicio");

        articulo.innerHTML = `
          <h2 class="titulo-ejercicio">${ejercicio.id} - ${
          ejercicio.titulo
        }</h2>
          <div class="detalles-ejercicio">
            <span class="dificultad nivel-${normalizarCadena(
              ejercicio.nivel
            )}">Nivel ${ejercicio.nivel}</span>
            <span class="tipo ${normalizarCadena(ejercicio.tipo)}">${
          ejercicio.tipo
        }</span>
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

    // Crear los botones de paginación debajo del contenedor principal
    const paginacionDiv = document.createElement("div");
    paginacionDiv.id = "paginacion";
    paginacionDiv.style.marginTop = "20px";
    paginacionDiv.style.textAlign = "center";
    contenedor.after(paginacionDiv);

    // Función que crea o actualiza los botones de paginación
    function actualizarPaginacion() {
      paginacionDiv.innerHTML = "";

      // Botón "Anterior"
      const btnAnterior = document.createElement("button");
      btnAnterior.textContent = "Anterior";
      btnAnterior.disabled = paginaActual === 1;
      btnAnterior.onclick = () => mostrarPagina(paginaActual - 1);
      paginacionDiv.appendChild(btnAnterior);

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

      // Botón "Siguiente"
      const btnSiguiente = document.createElement("button");
      btnSiguiente.textContent = "Siguiente";
      btnSiguiente.disabled = paginaActual === totalPaginas;
      btnSiguiente.onclick = () => mostrarPagina(paginaActual + 1);
      paginacionDiv.appendChild(btnSiguiente);
    }

    // Mostrar la primera página al cargar
    mostrarPagina(1);
  })
  .catch((error) => console.error("Error al cargar ejercicios:", error));
