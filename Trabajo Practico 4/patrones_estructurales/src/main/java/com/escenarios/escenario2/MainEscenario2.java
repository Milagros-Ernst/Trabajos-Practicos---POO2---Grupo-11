package com.escenarios.escenario2;

import java.nio.file.Path;

public class MainEscenario2 {
    public static void main(String[] args) {
        ReporteFiscalFacade facade = new ReporteFiscalFacade(
                "jdbc:mysql://localhost:3306/clientes",
                "TOKEN_AFIP_12345"
        );
        Path reporte = facade.generarReportePDF("CLI-001");
    }
}
