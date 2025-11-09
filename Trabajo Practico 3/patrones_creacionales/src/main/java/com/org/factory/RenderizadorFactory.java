package com.org.factory;

public class RenderizadorFactory {

    public static Renderizador crearRenderizador(Formato formato) {
        return switch (formato) {
            case PDF -> new RenderizadorPDF();
            case EXCEL -> new RenderizadorExcel();
            case CSV -> new RenderizadorCSV();
        };
    }
}
