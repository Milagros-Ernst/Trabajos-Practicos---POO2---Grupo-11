/**
 * Clase que guarda la configuración general de la aplicación.
 * Aplica el patrón Singleton para asegurar una sola instancia.
 */
public final class ConfiguracionApp {

    // Atributo estático que guarda la única instancia
    private static ConfiguracionApp instancia;

    // Atributos con los datos de configuración global
    private String urlBaseDatos;
    private String usuarioBaseDatos;
    private String rutaReportes;

    // Constructor privado: evita crear nuevas instancias
    private ConfiguracionApp() {
        this.urlBaseDatos = "jdbc:mysql://localhost:3306/empresa";
        this.usuarioBaseDatos = "root";
        this.rutaReportes = "C:/reportes";
    }

    // Método que devuelve la única instancia del gestor
    public static ConfiguracionApp getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracionApp();
        }
        return instancia;
    }

    // Métodos para obtener y modificar los valores de configuración
    public String getUrlBaseDatos() { return urlBaseDatos; }
    public void setUrlBaseDatos(String urlBaseDatos) { this.urlBaseDatos = urlBaseDatos; }

    public String getUsuarioBaseDatos() { return usuarioBaseDatos; }
    public void setUsuarioBaseDatos(String usuarioBaseDatos) { this.usuarioBaseDatos = usuarioBaseDatos; }

    public String getRutaReportes() { return rutaReportes; }
    public void setRutaReportes(String rutaReportes) { this.rutaReportes = rutaReportes; }
}
