package com.escenarios.escenario1;

public class GarantiaExtendida implements Componente {
    private final Componente componente;

    public GarantiaExtendida(Componente componente) { this.componente = componente; }

    @Override
    public double obtenerPrecio() {
        return componente.obtenerPrecio() * 1.10; // +10%
    }

    @Override
    public void mostrarDetalle(String indent) {
        componente.mostrarDetalle(indent);
        System.out.println(indent + "+ Garantía Extendida (+10%)");
    }
}
