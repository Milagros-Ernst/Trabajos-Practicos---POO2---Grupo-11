## Trabajo Pratico 3
Requerimiento 3 – Gestor de Configuración Global

Patrón utilizado: Singleton

Se eligio el patron singleton para la resolucion de este requerimiento. Ya que el problema plantea la necesidad de tener una sola fuente de configuración compartida por toda la aplicación.

El Singleton garantiza que exista una única instancia del gestor de configuración en memoria y que todos los módulos accedan a la misma información.

La unicidad se garantiza con tres elementos principales dentro de la clase ConfiguracionApp:

Constructor privado: impide que otras clases puedan crear nuevas instancias del objeto.

Atributo estático instancia: guarda la única instancia posible del gestor de configuración.

Método estático getInstancia(): crea la instancia solo la primera vez que se llama y luego devuelve siempre la misma.

Con esta estructura, no importa desde qué módulo se invoque getInstancia(), siempre se trabaja con el mismo objeto de configuración.