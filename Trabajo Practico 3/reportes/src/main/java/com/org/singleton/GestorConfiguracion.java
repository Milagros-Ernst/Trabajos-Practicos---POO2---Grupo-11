package com.org.singleton;

public class GestorConfiguracion {

    // instancia Eager, se crea en el momento de la carga de la clase
    public static final GestorConfiguracion INSTANCE = new GestorConfiguracion(); 

    // atributos de configuración
    private final String urlBd;
    private final String userBd;
    private final String pathReportes;

    private GestorConfiguracion() {
        // inicializamos los valores fijos para simular la carga del archivo.
        this.urlBd = "jdbc:mysql://localhost:3306/datos_financieros_prod";
        this.userBd = "usuario_reportes_prod";
        this.pathReportes = "reportes_generados";
    }
    
    // método alternativo para acceder a la instancia
    public static GestorConfiguracion getInstance() {
        return INSTANCE;
    }
    
    // getters
    public String getUrlBd() {
        return urlBd;
    }

    public String getUserBd() {
        return userBd;
    }

    public String getPathReportes() {
        return pathReportes;
    }
}