package com.org.singleton;

import java.io.InputStream;
import java.util.Properties;

public enum GestorConfiguracion {
    INSTANCE;

    private String pathReportes;
    private String urlBd;
    private String userBd;

    public void cargarDesdeClasspath(String resourceName) {
        try (InputStream in = Thread.currentThread()
                                    .getContextClassLoader()
                                    .getResourceAsStream(resourceName)) {
            if (in == null) {
                throw new IllegalArgumentException("No se encontró el recurso: " + resourceName);
            }
            Properties p = new Properties();
            p.load(in);

            this.pathReportes = valueOrThrow(p, "pathReportes");
            this.urlBd = p.getProperty("urlBd");  // opcional para el TP
            this.userBd = p.getProperty("userBd"); // opcional para el TP

        } catch (Exception e) {
            throw new RuntimeException("Error cargando configuración: " + resourceName, e);
        }
    }

    private static String valueOrThrow(Properties p, String key) {
        String v = p.getProperty(key);
        if (v == null || v.isBlank()) {
            throw new IllegalStateException("Propiedad requerida faltante: " + key);
        }
        return v;
    }

    // Getters públicos (sin setters: inmutable luego de cargar)
    public String getPathReportes() { return pathReportes; }
    public String getUrlBd() { return urlBd; }
    public String getUserBd() { return userBd; }
}
