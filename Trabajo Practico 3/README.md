# Trabajo Práctico 3 - Documento de Justificación

## **Requerimiento 1 – Motor de Renderizado**

### ¿Qué patrón de diseño creacional eligieron?
Para el motor de renderizado se eligió el patrón `Factory Method`.

### ¿Por qué este patrón es la solución adecuada para este problema? 
El patrón `Factory Method` resulta adecuado porque desacopla el código cliente del proceso de creación de los objetos, haciendo que el sistema sea más flexible y extensible.  
Gracias a este patrón, si en el futuro se requiere incorporar un nuevo tipo de renderizador, se puede agregar una nueva clase que implemente la interfaz `Renderizador` y registrarla en la fábrica sin alterar el resto del código. 

### ¿Qué problema(s) evita (ej. acoplamiento, violación del principio Abierto/Cerrado)?
El uso de este patrón evita el **acoplamiento** directo entre el cliente y las clases concretas de renderizado, ya que el cliente solo interactúa con la interfaz común.  
Además, previene la violación del **Principio Abierto/Cerrado (OCP)**, permitiendo extender el comportamiento del sistema sin modificar código existente.


## **Requerimiento 2 – Construcción de Reportes**

### ¿Qué patrón de diseño creacional eligieron?
Para la construcción de reportes se eligió el patrón `Builder`.

### ¿Por qué este patrón es la solución adecuada?
El patrón `Builder` es adecuado porque el objeto `Reporte` posee varios atributos opcionales y obligatorios.  
Utilizar un constructor tradicional con muchos parámetros haría el código poco legible y difícil de mantener.  
Con este patrón, la creación del objeto se realiza paso a paso mediante métodos encadenados, mejorando la claridad lo cual permite que cada instancia de `Reporte` sea construida de manera flexible según las necesidades del usuario.

### ¿Qué problemas específicos del "constructor" resuelve?
El patrón `Builder` resuelve el problema del **constructor telescópico**, evitando la creación de múltiples constructores sobrecargados y la necesidad de pasar valores nulos para parámetros opcionales.


## **Requerimiento 3 – Gestor de Configuración Global**

### ¿Qué patrón de diseño creacional elegiste?  
Se eligió el patrón `Singleton`.

### ¿Por qué este patrón es la solución adecuada para este requerimiento?  
Este patrón es el más adecuado porque el sistema necesita un único punto de acceso global a la configuración, asegurando que todos los módulos compartan los mismos parámetros, como la URL de la base de datos, el usuario o la ruta de salida de los reportes.  
El `Singleton` facilita la administración centralizada de estos datos y evita inconsistencias, ya que todos los componentes acceden a la misma instancia.

### ¿Cómo garantizaste la unicidad de la instancia?  
La unicidad se garantizó mediante una instancia estática creada de forma *eager*, definida como  
`public static final GestorConfiguracion INSTANCE`.

El constructor de la clase es privado, impidiendo que se creen nuevas instancias desde fuera.  
Además, se proporciona un método público (`getInstance()`) que devuelve siempre la misma referencia.

Con este enfoque se asegura que solo exista un único objeto en memoria y que cualquier acceso a la configuración utilice la misma instancia compartida en toda la aplicación.
