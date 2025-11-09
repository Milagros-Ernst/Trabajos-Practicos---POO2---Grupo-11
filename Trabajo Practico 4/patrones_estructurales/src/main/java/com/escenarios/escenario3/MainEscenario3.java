package com.escenarios.escenario3;

public class MainEscenario3 {
    public static void main(String[] args) {
        IServicioEnvio envio = new LogisticaVelozAdapter();

        String cp = "3300";
        System.out.println("Costo: $" + envio.calcularCosto(cp));
        System.out.println("Tiempo estimado: " + envio.obtenerTiempoEstimado(cp));
        System.out.println("Tracking: " + envio.despacharPedido("Av. Siempre Viva 742", cp, "PED-001"));
    }
}
