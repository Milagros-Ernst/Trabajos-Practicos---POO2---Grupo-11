### Escenario 1 – Ensamblaje de computadoras

#### 1. Identificación del patrón  
- **Composite:** Permite tratar de forma uniforme componentes simples y compuestos mediante la interfaz `Componente`.  
  Las clases hoja (`CPU`, `MemoriaRAM`, `DiscoSSD`) y los compuestos (`PlacaMadre`, `Gabinete`) permiten la composición recursiva y el cálculo agregado del precio total.  
- **Decorator:** Permite agregar responsabilidades dinámicamente sobre cualquier `Componente` sin recurrir a herencia múltiple o combinatoria.  
  Los decoradores (`GarantiaExtendida`, `ServicioInstalacion`) envuelven a los componentes y agregan comportamientos o costos extra, pudiendo apilarse libremente.

#### 2. Justificación de la elección  
- El patrón **Composite** es apropiado porque modela una **estructura parte–todo** y posibilita operaciones uniformes (`getPrecio()`, `imprimir()`) sin distinguir tipos concretos.  
  El cliente (`CarritoCompras`) puede trabajar con un solo componente o con una estructura completa sin modificar su lógica.  
  Además, permite incorporar reglas estructurales (por ejemplo, que una `PlacaMadre` contenga al menos una CPU y una RAM).  
- El patrón **Decorator** evita crear subclases para cada combinación de extras, cumpliendo con el **principio de abierto/cerrado.**
  Al ser combinable, permite agregar funcionalidades adicionales en tiempo de ejecución de forma flexible y extensible.

**Conclusión.**  
La combinación **Composite + Decorator** resuelve eficazmente la gestión jerárquica de componentes y la extensión dinámica de funcionalidades, garantizando un diseño **mantenible y escalable**.

---

### Escenario 2 – Generación de reporte fiscal 

#### 1. Identificación del patrón  
- **Facade:** Se aplicó para **unificar y simplificar el acceso** a los subsistemas internos.  
  La clase `ReporteFiscalFacade` actúa como un **punto de entrada único**, ofreciendo el método `generarReportePDF(idCliente)` que coordina internamente los módulos:  
  `ConectorDB → LectorDeDatos → ServicioWebAFIP → ProcesadorDeImpuestos → RenderizadorPDF`.

#### 2. Justificación de la elección  
- El patrón **Facade** reduce el **acoplamiento** entre la interfaz de usuario y los subsistemas, al encapsular la complejidad y ofrecer una **interfaz clara y sencilla**.  
- Permite **modificar o sustituir** cualquier componente interno (por ejemplo, el renderizador PDF o el servicio AFIP) sin afectar a las capas externas.  
- Facilita el **mantenimiento**, la **legibilidad** y la **reutilización**, concentrando la lógica orquestadora en un solo lugar.

**Conclusión.**  
El patrón **Facade** cumple su propósito de **ocultar la complejidad interna** detrás de una interfaz simple y coherente, logrando un sistema **desacoplado, fácil de usar y de mantener**.

### Escenario 3 – Integración de API de Logística

#### 1. Identificación del patrón  
- **Adapter:** Se aplicó para **compatibilizar la interfaz interna** `IServicioEnvio` con la clase externa `ApiLogisticaVeloz` proveniente del SDK del nuevo proveedor de envíos.  
  La clase `LogisticaVelozAdapter` actúa como un **intermediario** que traduce las llamadas internas a las operaciones del SDK:
  - `calcularCosto(String cp)` → `cotizarEnvio(int cpDestino)`  
  - `obtenerTiempoEstimado(String cp)` → usa los días de la `Cotizacion`  
  - `despacharPedido(String dir, String cp, String id)` → `enviarPaquete(DatosEnvio)`  
  Además, realiza la conversión de tipos entre `String` e `int`, y construye los objetos requeridos por la librería externa.

#### 2. Justificación de la elección  
- El patrón **Adapter** resuelve el **problema de incompatibilidad de interfaces** sin modificar el código fuente del SDK externo.  
- Permite mantener intacta la **interfaz interna** usada por todo el sistema, evitando cambios en las capas de presentación o negocio.  
- **Reduce el acoplamiento**, ya que el sistema no depende directamente del SDK de LogísticaVeloz.  
- Facilita la **extensibilidad**, permitiendo integrar nuevos proveedores de envío mediante nuevos adapters sin alterar el código existente.  
- Cumple con el principio **Open/Closed**, ya que la funcionalidad se amplía a través del adapter sin modificar clases previas.

**Conclusión.**  
El patrón **Adapter** permitió **integrar de forma transparente** la API de LogísticaVeloz con el sistema de E-Commerce, estandarizando las operaciones de envío, reduciendo el acoplamiento y garantizando una estructura flexible y mantenible.
