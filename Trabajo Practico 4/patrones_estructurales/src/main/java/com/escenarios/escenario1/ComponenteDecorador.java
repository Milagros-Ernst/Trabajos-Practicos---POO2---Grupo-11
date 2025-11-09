package com.escenarios.escenario1;

public abstract class ComponenteDecorador implements Componente {
    protected final Componente componente;
    protected final String nombre;
    
    protected ComponenteDecorador(String nombre, Componente componente) {
        this.nombre = nombre;
        this.componente = componente;
    }
    
    @Override
    public void mostrarDetalle(String indent) {
        componente.mostrarDetalle(indent);
    }
    
    @Override
    public double obtenerPrecio() {
        return componente.obtenerPrecio();
    }
}