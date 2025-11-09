package com.escenarios.escenario1;

public class PlacaMadre extends ComponenteCompuesto {
    private final double precio;
    
    public PlacaMadre(String nombre, double precio) {
        super(nombre);
        this.precio = precio;
    }
    
    @Override
    public double obtenerPrecio() {
        return precio + super.obtenerPrecio();
    }
}