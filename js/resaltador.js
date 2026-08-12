// Resaltador de sintaxis ligero y sin dependencias para Python y Java.
// Expone window.resaltarCodigo(codigo, lenguaje) que devuelve HTML con spans.
// Clases CSS: tok-comentario, tok-cadena, tok-palabra, tok-numero, tok-builtin, tok-anotacion.

const RESALTADOR = (() => {
    const escapeHtml = (texto) =>
        texto.replace(/&/g, "&amp;").replace(/</g, "&lt;").replace(/>/g, "&gt;");

    const patrones = (re, cls) => ({ re: new RegExp(re, "g"), cls });

    const LENGUAJES = {
        python: [
            patrones(/#[^\n]*/, "tok-comentario"),
            patrones(/"""[\s\S]*?"""|'''[\s\S]*?'''|"(?:\\.|[^"\\\n])*"|'(?:\\.|[^'\\\n])*'/, "tok-cadena"),
            patrones(/@[\w.]+/, "tok-anotacion"),
            patrones(/\b(def|class|return|if|elif|else|for|while|break|continue|pass|import|from|as|in|not|and|or|None|True|False|try|except|finally|with|lambda|global|nonlocal|raise|yield|del|assert|is|print)\b/, "tok-palabra"),
            patrones(/\b(int|float|str|bool|list|dict|set|tuple|range|len|input|sum|min|max|sorted|enumerate|zip|map|filter|ord|chr|abs|round|type|open|isinstance|isspace|join|split|strip|lower|upper|replace|startswith|endswith|find|count|keys|values|items|append|extend|pop|insert)\b/, "tok-builtin"),
            patrones(/\b\d+(?:\.\d+)?\b/, "tok-numero"),
        ],
        java: [
            patrones(/\/\/[^\n]*|\/\*[\s\S]*?\*\//, "tok-comentario"),
            patrones(/"(?:\\.|[^"\\\n])*"/, "tok-cadena"),
            patrones(/@[\w.]+/, "tok-anotacion"),
            patrones(/\b(public|private|protected|class|interface|extends|implements|static|final|void|int|double|float|long|short|byte|boolean|char|String|new|if|else|for|while|do|switch|case|default|break|continue|return|this|super|try|catch|finally|throw|throws|import|package|abstract|enum|instanceof|true|false|null|var|record)\b/, "tok-palabra"),
            patrones(/\b(System|Math|Integer|Double|Float|Long|Boolean|Character|Object|StringBuilder|BufferedReader|InputStreamReader|IOException|RuntimeException|print|println|printf|readLine|parseInt|parseDouble)\b/, "tok-builtin"),
            patrones(/\b\d+(?:\.\d+)?[fFdDlL]?\b/, "tok-numero"),
        ],
    };

    const tokenizar = (codigo, lenguaje) => {
        const reglas = LENGUAJES[lenguaje] || [];
        let html = "";
        let i = 0;

        while (i < codigo.length) {
            let coincidencia = null;
            for (const regla of reglas) {
                regla.re.lastIndex = i;
                const m = regla.re.exec(codigo);
                if (m && m.index === i) {
                    coincidencia = { texto: m[0], cls: regla.cls };
                    break;
                }
            }

            if (coincidencia) {
                html += `<span class="${coincidencia.cls}">${escapeHtml(coincidencia.texto)}</span>`;
                i += coincidencia.texto.length;
            } else {
                html += escapeHtml(codigo[i]);
                i += 1;
            }
        }

        return html;
    };

    return {
        resaltarCodigo: (codigo, lenguaje) => tokenizar(codigo, lenguaje),
    };
})();

window.resaltarCodigo = RESALTADOR.resaltarCodigo;
