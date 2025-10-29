package com.org.reportes;

import java.time.LocalDate;

public class Reporte {
    // Atributos
    private final String titulo;
    private final String cuerpoPrincipal;
    private final String encabezado;
    private final String pieDePagina;
    private final LocalDate fecha;
    private final String autor;
    private final Orientacion orientacion;

    private Reporte(Builder b) {
        this.titulo = b.titulo;
        this.cuerpoPrincipal = b.cuerpoPrincipal;
        this.encabezado = b.encabezado;
        this.pieDePagina = b.pieDePagina;
        this.fecha = b.fecha;
        this.autor = b.autor;
        this.orientacion = b.orientacion;
    }

    // Builder 
    public static class Builder {
        private final String titulo;
        private final String cuerpoPrincipal;

        private String encabezado;
        private String pieDePagina;
        private LocalDate fecha;
        private String autor;
        private Orientacion orientacion = Orientacion.VERTICAL;

        public Builder(String titulo, String cuerpoPrincipal) {
            if (titulo == null || titulo.isBlank())
                throw new IllegalArgumentException("titulo requerido");
            if (cuerpoPrincipal == null || cuerpoPrincipal.isBlank())
                throw new IllegalArgumentException("cuerpoPrincipal requerido");
            this.titulo = titulo;
            this.cuerpoPrincipal = cuerpoPrincipal;
        }

        public Builder encabezado(String v){ this.encabezado = v; return this; }
        public Builder pieDePagina(String v){ this.pieDePagina = v; return this; }
        public Builder fecha(LocalDate v){ this.fecha = v; return this; }
        public Builder autor(String v){ this.autor = v; return this; }
        public Builder orientacion(Orientacion v){ this.orientacion = v; return this; }

        public Reporte build(){ return new Reporte(this); }
    }

    // Getters
    public String getTitulo() { return titulo; }
    public String getCuerpoPrincipal() { return cuerpoPrincipal; }
    public String getEncabezado() { return encabezado; }
    public String getPieDePagina() { return pieDePagina; }
    public LocalDate getFecha() { return fecha; }
    public String getAutor() { return autor; }
    public Orientacion getOrientacion() { return orientacion; }
}
