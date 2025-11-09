package com.escenarios.escenario2;

public class MainEscenario2 {
    public static void main(String[] args) {
        ReporteFiscalFacade facade = new ReporteFiscalFacade(
                "jdbc:mysql://localhost:3306/clientes",
                "TOKEN_AFIP_12345"
        );
        facade.generarReportePDF("CLI-001");
    }
}
