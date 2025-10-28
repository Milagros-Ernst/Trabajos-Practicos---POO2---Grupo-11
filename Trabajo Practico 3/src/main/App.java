package main;
/**
 * Clase principal que prueba el funcionamiento del patrón Singleton.
 */
public class App {
    public static void main(String[] args) {

        // Se obtienen dos referencias al mismo gestor de configuración
        ConfiguracionApp config1 = ConfiguracionApp.getInstancia();
        ConfiguracionApp config2 = ConfiguracionApp.getInstancia();

        // Se verifica que ambas variables apunten al mismo objeto
        System.out.println("¿Es la misma instancia?: " + (config1 == config2));

        // Se muestran los valores iniciales
        System.out.println("URL de la base de datos: " + config1.getUrlBaseDatos());
        System.out.println("Usuario: " + config1.getUsuarioBaseDatos());
        System.out.println("Ruta de reportes: " + config1.getRutaReportes());

        // Se cambia la ruta desde una referencia
        config1.setRutaReportes("C:/nuevos_reportes");

        // Se verifica que el cambio se refleje también en la otra
        System.out.println("Nueva ruta vista desde config2: " + config2.getRutaReportes());
    }
}
