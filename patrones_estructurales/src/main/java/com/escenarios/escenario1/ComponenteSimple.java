package com.escenarios.escenario1;

public class ComponenteSimple implements Componente {
    public enum Tipo {
        CPU("CPU", 250.0),
        MEMORIA_RAM("Memoria RAM", 80.0),
        DISCO_SSD("Disco SSD", 100.0);
        final String nombre;
        final double precio;
        Tipo(String n, double p) { nombre = n; precio = p; }
    }

    private final Tipo tipo;

    public ComponenteSimple(Tipo tipo) { this.tipo = tipo; }

    @Override
    public double obtenerPrecio() { return tipo.precio; }

    @Override
    public void mostrarDetalle(String indent) {
        System.out.println(indent + tipo.nombre + " - $" + tipo.precio);
    }

    public Tipo getTipo() { return tipo; }
}