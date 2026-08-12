#!/usr/bin/env python3
"""Genera json/soluciones.json a partir del directorio de soluciones del sitio.

Uso:
    python3 scripts/generar-soluciones.py [--origen DIR]

Por defecto lee el directorio "soluciones/" de la raíz del proyecto y escribe
"json/soluciones.json". Cada carpeta de solución debe llamarse "<id>_<slug>",
donde <id> coincide con el campo "id" de los ejercicios en json/python.json y
json/java.json (p. ej. "02_cifrado_escalonado").
"""

import argparse
import json
import os
import sys

RAIZ = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))


def listar_soluciones(origen):
    """Devuelve {lenguaje: {id: [rutas relativas, ordenadas]}}."""
    soluciones = {}
    if not os.path.isdir(origen):
        sys.exit(f"El directorio de origen no existe: {origen}")

    for lenguaje in sorted(os.listdir(origen)):
        dir_lenguaje = os.path.join(origen, lenguaje)
        if not os.path.isdir(dir_lenguaje):
            continue
        soluciones[lenguaje] = {}
        for categoria in sorted(os.listdir(dir_lenguaje)):
            dir_categoria = os.path.join(dir_lenguaje, categoria)
            if not os.path.isdir(dir_categoria):
                continue
            for carpeta in sorted(os.listdir(dir_categoria)):
                dir_carpeta = os.path.join(dir_categoria, carpeta)
                if not os.path.isdir(dir_carpeta):
                    continue
                id_ejercicio = carpeta.split("_", 1)[0]
                archivos = sorted(os.listdir(dir_carpeta))
                soluciones[lenguaje][id_ejercicio] = [
                    os.path.relpath(os.path.join(dir_carpeta, archivo), RAIZ)
                    for archivo in archivos
                ]
    return soluciones


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--origen", default=os.path.join(RAIZ, "soluciones"),
                        help="Directorio con las soluciones (default: soluciones/)")
    args = parser.parse_args()

    soluciones = listar_soluciones(args.origen)
    destino = os.path.join(RAIZ, "json", "soluciones.json")
    with open(destino, "w", encoding="utf-8") as f:
        json.dump(soluciones, f, ensure_ascii=False, indent=2)

    total = sum(len(ids) for ids in soluciones.values())
    print(f"Manifest generado: {destino}")
    for lenguaje, ids in soluciones.items():
        print(f"  {lenguaje}: {len(ids)} soluciones")
    print(f"  total: {total}")


if __name__ == "__main__":
    main()
