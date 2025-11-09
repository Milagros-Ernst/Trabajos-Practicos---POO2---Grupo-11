package com.escenarios.escenario1;

public class MainEscenario1 {
    private static Gabinete crearPcBase() {
        // Placa Madre con sus componentes
        PlacaMadre placa = new PlacaMadre("Placa madre ASUS", 150);
        placa.agregar(new ComponenteSimple(ComponenteSimple.Tipo.CPU));
        placa.agregar(new ComponenteSimple(ComponenteSimple.Tipo.MEMORIA_RAM));
        placa.agregar(new ComponenteSimple(ComponenteSimple.Tipo.MEMORIA_RAM));

        // Gabinete que contiene placa y SSD
        Gabinete g = new Gabinete("Gabinete ASUS", 120);
        g.agregar(placa);
        g.agregar(new ComponenteSimple(ComponenteSimple.Tipo.DISCO_SSD));
        return g;
    }

    public static void main(String[] args) {
        System.out.println("== Ensamblaje de Computadoras ==");

        // PC Base
        Gabinete pcBase = crearPcBase();
        System.out.println("\n- PC Base -");
        pcBase.mostrarDetalle("");
        System.out.println("Precio total: $" + String.format("%.2f", pcBase.obtenerPrecio()));

        // PC con Garantía Extendida
        Gabinete pcBase2 = crearPcBase(); // NUEVA instancia base
        Componente pcGarantia = new GarantiaExtendida(pcBase2);
        System.out.println("\n- PC con Garantía Extendida -");
        pcGarantia.mostrarDetalle("");
        System.out.println("Precio total: $" + String.format("%.2f", pcGarantia.obtenerPrecio()));

        // PC con Garantía + Instalación
        Gabinete pcBase3 = crearPcBase();
        Componente pcFull = new ServicioInstalacion(new GarantiaExtendida(pcBase3));
        System.out.println("\n- PC con Garantía + Instalación -");
        pcFull.mostrarDetalle("");
        System.out.println("Precio total: $" + String.format("%.2f", pcFull.obtenerPrecio()));

        // SSD Individual con Garantía
        Componente ssdConGarantia = new GarantiaExtendida(
                new ComponenteSimple(ComponenteSimple.Tipo.DISCO_SSD)
        );
        System.out.println("\n- SSD Individual con Garantía -");
        ssdConGarantia.mostrarDetalle("");
        System.out.println("Precio total: $" + String.format("%.2f", ssdConGarantia.obtenerPrecio()));
    }
}
