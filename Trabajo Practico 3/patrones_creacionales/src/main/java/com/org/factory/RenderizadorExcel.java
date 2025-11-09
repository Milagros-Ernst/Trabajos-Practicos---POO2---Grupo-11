package com.org.factory;

import com.org.reportes.Reporte;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RenderizadorExcel implements Renderizador {

    @Override
    public Path render(Reporte r, Path destino) throws IOException {
        Files.createDirectories(destino);
        String base = r.getTitulo().replaceAll("\\s+", "_");
        Path archivo = destino.resolve(base + ".xlsx");
        String contenido = "[EXCEL] " + r.getTitulo() + " | " + r.getCuerpoPrincipal();
        Files.writeString(archivo, contenido);
        System.out.println("Renderizado Excel en: " + archivo.toAbsolutePath());
        return archivo;
    }
}
