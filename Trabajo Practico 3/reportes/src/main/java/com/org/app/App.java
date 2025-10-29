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
            // accedemos a la configuración (singleton)
            GestorConfiguracion config = GestorConfiguracion.INSTANCE;

            // usamos la configuración
            Path destino = Path.of(config.getPathReportes());
            
            // creamos el directorio si no existe (usa la ruta configurada)
            Files.createDirectories(destino); 

            // mostramos los datos de la configuración Singleton
            System.out.println("URL BD: " + config.getUrlBd());
            System.out.println("Usuario: " + config.getUserBd());
            System.out.println("Ruta de salida: " + destino.toAbsolutePath());

            // construcción del Reporte (Builder)
            // Se usa el método encadenado
            Reporte reporte = new Reporte.Builder(
                    "Ventas T-4",
                    "Este es el cuerpo principal del reporte de Ventas del Trimestre 4.")
                .autor("Equipo Finanzas")
                .fecha(LocalDate.now())
                .encabezado("Confidencial - Acceso Restringido")
                .pieDePagina("Documento interno - No distribuir")
                .orientacion(Orientacion.HORIZONTAL)
                .build();

            // Renderizado (Factory Method)
            // el cliente pide el objeto Renderizador por formato pdf, excel y csv    
            Renderizador rPdf  = RenderizadorFactory.crearRenderizador(Formato.PDF);
            Renderizador rXlsx = RenderizadorFactory.crearRenderizador(Formato.EXCEL);
            Renderizador rCsv  = RenderizadorFactory.crearRenderizador(Formato.CSV);

            // simulación de renderizado
            rPdf.render(reporte, destino);
            rXlsx.render(reporte, destino);
            rCsv.render(reporte, destino);

        } catch (Exception e) {
            System.err.println("ERROR FATAL en la aplicación:");
            e.printStackTrace();
        }
    }
}