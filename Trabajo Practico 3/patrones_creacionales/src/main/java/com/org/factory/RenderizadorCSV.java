package com.org.factory;

import com.org.reportes.Reporte;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RenderizadorCSV implements Renderizador {

    @Override
    public Path render(Reporte r, Path destino) throws IOException {
        Files.createDirectories(destino);
        String base = r.getTitulo().replaceAll("\\s+", "_");
        Path archivo = destino.resolve(base + ".csv");
        String encabezados = "titulo,autor,fecha,orientacion,encabezado,pie,cuerpo";
        String fila = String.join(",",
                quote(r.getTitulo()),
                quote(r.getAutor()),
                quote(String.valueOf(r.getFecha())),
                quote(String.valueOf(r.getOrientacion())),
                quote(r.getEncabezado()),
                quote(r.getPieDePagina()),
                quote(r.getCuerpoPrincipal())
        );
        Files.writeString(archivo, encabezados + System.lineSeparator() + fila);
        System.out.println("Renderizado CSV en: " + archivo.toAbsolutePath());
        return archivo;
    }

    private String quote(String s) {
        if (s == null) return "";
        return "\"" + s.replace("\"", "\"\"") + "\"";
    }
}
