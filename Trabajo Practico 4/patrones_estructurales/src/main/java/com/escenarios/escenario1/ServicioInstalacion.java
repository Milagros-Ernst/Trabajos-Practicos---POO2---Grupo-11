package com.escenarios.escenario1;

public class ServicioInstalacion implements Componente {
    private final Componente componente;

    public ServicioInstalacion(Componente componente) { this.componente = componente; }

    @Override
    public double obtenerPrecio() {
        return componente.obtenerPrecio() + 50.0; // +$50
    }

    @Override
    public void mostrarDetalle(String indent) {
        componente.mostrarDetalle(indent);
        System.out.println(indent + "+ Servicio de Instalación (+$50)");
    }
}
