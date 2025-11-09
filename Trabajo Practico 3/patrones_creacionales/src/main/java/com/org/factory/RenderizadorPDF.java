package com.org.factory;

import com.org.reportes.Reporte;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RenderizadorPDF implements Renderizador {

    @Override
    public Path render(Reporte r, Path destino) throws IOException {
        Files.createDirectories(destino);
        String base = r.getTitulo().replaceAll("\\s+", "_");
        Path archivo = destino.resolve(base + ".pdf");
        String contenido = """
                [PDF]
                Título: %s
                Autor: %s
                Fecha: %s
                Encabezado: %s
                Orientación: %s

                %s

                Pie: %s
                """.formatted(
                r.getTitulo(),
                r.getAutor(),
                r.getFecha(),
                r.getEncabezado(),
                r.getOrientacion(),
                r.getCuerpoPrincipal(),
                r.getPieDePagina()
        );
        Files.writeString(archivo, contenido);
        System.out.println("Renderizado PDF en: " + archivo.toAbsolutePath());
        return archivo;
    }
}
