## Trabajo Pratico 3

### Requerimiento 3 – Gestor de Configuración Global  

---

### 1. ¿Qué patrón de diseño creacional elegiste?  

Se eligió el patrón Singleton

---

### 2. ¿Por qué este patrón es la solución adecuada para este requerimiento?  
Este patrón es el más adecuado porque el requerimiento plantea la necesidad de contar con una sola fuente de configuración global que sea compartida por todos los módulos del sistema.  

El Singleton garantiza que solo exista una única instancia del gestor de configuración en memoria y que todos los componentes accedan a la misma información.  
De esta forma se evitan duplicaciones, inconsistencias y sobrecarga innecesaria de objetos.  

En este caso, la configuración (por ejemplo, la URL de la base de datos, el usuario y la ruta de salida de reportes) es información global que no debe repetirse ni modificarse en diferentes partes del programa.  

---

### 3. ¿Cómo garantizaste la unicidad de la instancia?  
La unicidad se garantiza mediante los siguientes elementos en la clase `GestorConfiguracion`:  

- **Constructor privado:** impide que otras clases puedan crear nuevas instancias del objeto.  
- **Atributo estático final `INSTANCE`:** se crea automáticamente cuando la clase se carga en memoria, asegurando una única instancia (instanciación ansiosa).  
- **Método estático `getInstance()`:** devuelve siempre la misma referencia (`INSTANCE`) para acceder al objeto único.  
