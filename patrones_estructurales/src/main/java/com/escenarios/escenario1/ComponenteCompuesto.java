package com.escenarios.escenario1;

import java.util.ArrayList;
import java.util.List;

public abstract class ComponenteCompuesto implements Componente {
    protected final String nombre;
    protected final List<Componente> componentes;

    protected ComponenteCompuesto(String nombre) {
        this.nombre = nombre;
        this.componentes = new ArrayList<>();
    }

    public void agregar(Componente c) {
        componentes.add(c);
    }

    public void quitar(Componente c) {
        componentes.remove(c);
    }

    @Override
    public void mostrarDetalle(String indent) {
        System.out.printf("%s%s%n", indent, nombre);
        for (Componente c : componentes) {
            c.mostrarDetalle(indent + "  ");
        }
    }

    @Override
    public double obtenerPrecio() {
        return componentes.stream()
                .mapToDouble(Componente::obtenerPrecio)
                .sum();
    }
}