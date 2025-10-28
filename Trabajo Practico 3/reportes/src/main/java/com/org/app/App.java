package com.org.app;

import com.org.singleton.GestorConfiguracion;
import com.org.factory.*;
import com.org.reportes.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        try {
            // 1) Cargar configuración (una vez)
            GestorConfiguracion.INSTANCE.cargarDesdeClasspath("app.properties");

            // 2) Usar la config para determinar ruta de salida
            Path destino = Path.of(GestorConfiguracion.INSTANCE.getPathReportes());
            Files.createDirectories(destino);

            // (Opcional) Mostrar datos BD para verificar que cargó
            System.out.println("URL BD: "  + GestorConfiguracion.INSTANCE.getUrlBd());
            System.out.println("USER BD: " + GestorConfiguracion.INSTANCE.getUserBd());

            // 3) Builder del reporte (igual que escenario 2)
            Reporte reporte = new Reporte.Builder(
                    "Ventas Q3",
                    "Este es el cuerpo principal del reporte de Ventas del Q3.")
                .autor("Equipo Finanzas")
                .fecha(LocalDate.now())
                .encabezado("Confidencial")
                .pieDePagina("Documento interno - No distribuir")
                .orientacion(Orientacion.HORIZONTAL)
                .build();

            // 4) Render mediante Factory
            Renderizador rPdf   = RenderizadorFactory.crearRenderizador(Formato.PDF);
            Renderizador rXlsx  = RenderizadorFactory.crearRenderizador(Formato.EXCEL);
            Renderizador rCsv   = RenderizadorFactory.crearRenderizador(Formato.CSV);

            rPdf.render(reporte, destino);
            rXlsx.render(reporte, destino);
            rCsv.render(reporte, destino);

            System.out.println("Listo. Archivos en: " + destino.toAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
