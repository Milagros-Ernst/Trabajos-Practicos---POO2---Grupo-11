package com.escenarios.escenario3;

class ApiLogisticaVeloz {
    float cotizar(int cp) { return 1500 + (cp % 100) * 10; }
    int estimarDias(int cp) { return 2 + (cp % 3); }
    String enviar(String dir, int cp, String ref) {
        return "LV-" + Math.abs((dir + cp + ref).hashCode());
    }
}

public class LogisticaVelozAdapter implements IServicioEnvio {
    private final ApiLogisticaVeloz api = new ApiLogisticaVeloz();

    @Override
    public float calcularCosto(String codigoPostal) {
        return api.cotizar(parsearCP(codigoPostal));
    }

    @Override
    public String obtenerTiempoEstimado(String codigoPostal) {
        return api.estimarDias(parsearCP(codigoPostal)) + " días";
    }

    @Override
    public String despacharPedido(String direccion, String codigoPostal, String idPedido) {
        return api.enviar(direccion, parsearCP(codigoPostal), idPedido);
    }

    private int parsearCP(String cp) {
        return Integer.parseInt(cp.replaceAll("\\D+", ""));
    }
}
