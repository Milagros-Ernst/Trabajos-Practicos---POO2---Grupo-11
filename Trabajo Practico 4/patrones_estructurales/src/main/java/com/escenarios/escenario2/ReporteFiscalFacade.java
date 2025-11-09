package com.escenarios.escenario2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

 // permite generar el reporte fiscal con una única llamada
public class ReporteFiscalFacade {

    private final String urlBD;
    private final String tokenAFIP;

    public ReporteFiscalFacade(String urlBD, String tokenAFIP) {
        this.urlBD = urlBD;
        this.tokenAFIP = tokenAFIP;
    }

    public Path generarReportePDF(String idCliente) {
        System.out.println();
        ConectorDB conector = new ConectorDB(urlBD);
        Path reporte;
        try {
            conector.conectar();
            String cuit = new LectorDeDatos(conector).obtenerCUIT(idCliente);

            ServicioWebAFIP afip = new ServicioWebAFIP();
            afip.autenticar(tokenAFIP);
            DatosFiscales datos = afip.obtenerDatosFiscales(cuit);

            Montos montos = new ProcesadorDeImpuestos().calcular(datos);
            reporte = new RenderizadorPDF().generar(montos, cuit);

        } finally {
            conector.cerrar();
        }
        System.out.println("Reporte generado: " + reporte.toAbsolutePath());
        System.out.println("-------------------------------------------\n");
        return reporte;
    }



    /* Clases internas */
    static class ConectorDB {
        private final String url;
        private boolean conectado = false;

        ConectorDB(String url) { this.url = url; }

        void conectar() {
            System.out.println("[ConectorDB] Conectado a " + url);
            conectado = true;
        }

        void cerrar() {
            if (conectado) {
                System.out.println("[ConectorDB] Conexión cerrada");
                conectado = false;
            }
        }

        boolean isConectado() { return conectado; }
    }

    static class LectorDeDatos {
        private final ConectorDB conector;

        LectorDeDatos(ConectorDB conector) { this.conector = conector; }

        String obtenerCUIT(String idCliente) {
            if (!conector.isConectado()) throw new IllegalStateException("BD no conectada.");
            System.out.println("[LectorDeDatos] Obteniendo CUIT de cliente " + idCliente);
            return "20-12345678-9"; // Simulado
        }
    }

    static class ServicioWebAFIP {
        private boolean autenticado = false;

        void autenticar(String token) {
            if (token == null || token.isBlank()) throw new IllegalArgumentException("Token inválido.");
            autenticado = true;
            System.out.println("[ServicioWebAFIP] Autenticación exitosa");
        }

        DatosFiscales obtenerDatosFiscales(String cuit) {
            if (!autenticado) throw new IllegalStateException("No autenticado.");
            System.out.println("[ServicioWebAFIP] Obteniendo datos fiscales de " + cuit);
            return new DatosFiscales(cuit, 1_000_000, 0.21, 150_000);
        }
    }

    static record DatosFiscales(String cuit, double baseImponible, double alicuotaIva, double deducciones) { }

    static record Montos(double subtotal, double iva, double total) { }

    static class ProcesadorDeImpuestos {
        Montos calcular(DatosFiscales d) {
            System.out.println("[ProcesadorDeImpuestos] Calculando montos...");
            double base = Math.max(0, d.baseImponible() - d.deducciones());
            double iva = base * d.alicuotaIva();
            return new Montos(base, iva, base + iva);
        }
    }

    static class RenderizadorPDF {
        Path generar(Montos m, String cuit) {
            try {
                Path carpeta = Path.of("src", "main", "java", "com", "escenarios", "escenario2", "reportes");
                Files.createDirectories(carpeta);

                Path out = carpeta.resolve("reporte-" + cuit + ".pdf");
                String contenido = """
                    REPORTE FISCAL
                    ====================================
                    CUIT: %s

                    Subtotal: $%.2f
                    IVA:      $%.2f
                    TOTAL:    $%.2f

                    (Documento generado automáticamente)
                    """.formatted(cuit, m.subtotal(), m.iva(), m.total());

                Files.writeString(out, contenido);
                System.out.println("[RenderizadorPDF] PDF generado en " + out.toAbsolutePath());
                return out;

            } catch (IOException e) {
                throw new RuntimeException("Error al generar PDF", e);
            }
        }
    }
}

