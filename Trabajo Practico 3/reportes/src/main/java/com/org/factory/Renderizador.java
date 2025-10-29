package com.org.factory;

import com.org.reportes.Reporte;
import java.nio.file.Path;

public interface Renderizador {
    Path render(Reporte reporte, Path destino) throws Exception;
}