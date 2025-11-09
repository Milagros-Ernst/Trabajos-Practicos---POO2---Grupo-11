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