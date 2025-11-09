package com.escenarios.escenario1;

public class Gabinete extends ComponenteCompuesto {
    private final double precio;
    
    public Gabinete(String nombre, double precio) {
        super(nombre);
        this.precio = precio;
    }
    
    @Override
    public double obtenerPrecio() {
        return precio + super.obtenerPrecio();
    }
}