# Gestión de Pedidos de una Tienda Online

Este diagrama de clases representa el sistema de gestión de pedidos de una tienda online. Muestra las clases principales que intervienen en el proceso de compra, desde la publicación de productos hasta la entrega al cliente.

## Clases de Usuario

La clase **Usuario** es la clase base y de ella heredan tres tipos de usuarios:

- **Administrador:** puede gestionar usuarios, generar reportes, eliminar productos y aprobar vendedores.  
- **Cliente:** puede realizar pedidos dentro del sistema.  
- **Vendedor:** publica productos y puede modificar su stock disponible.

## Clases del Proceso de Venta

- **Producto:** almacena la información básica de los artículos (id, nombre, descripción, precio y stock) y cuenta con métodos para dar de alta, baja o modificar productos.  
- **Carrito:** representa el conjunto de productos seleccionados antes de generar un pedido. Tiene métodos para agregar o eliminar productos.  
- **Pedido:** representa una orden concreta realizada por un cliente, con atributos de estado y fecha. Incluye un método para cambiar su estado.  
- **Venta:** se genera a partir de un pedido y tiene fecha de venta y método para calcular el total.  
- **Factura:** se emite a partir de una venta e incluye un método para generarla y registrar la fecha de emisión.  
- **Pago:** registra el monto, la fecha y el estado del pago. Está vinculado a un método de pago.  
- **Método de Pago:** define el tipo de medio usado para el pago (tarjeta, transferencia, etc.).  
- **Envío:** se genera a partir de un pedido, con fecha y método para calcular el costo de envío.  
- **Domicilio:** representa la dirección de destino del envío, con datos como provincia, ciudad, calle y código postal.

## Relaciones Principales

- Un **vendedor publica productos**.  
- Un **cliente realiza pedidos**.  
- Un **pedido pertenece a un carrito** y **genera una venta**.  
- Una **venta genera una factura** y **tiene un pago asociado**.  
- Un **pago utiliza uno o varios métodos de pago**.  
- Un **pedido genera un envío**, y cada **envío tiene un domicilio**.  
- Un **administrador gestiona usuarios y productos**.

## Objetivo del Modelo

El modelo busca representar de forma ordenada cómo se gestionan los pedidos en una tienda online, describiendo las relaciones entre clientes, pedidos, pagos, envíos y productos, junto con las funciones de los distintos tipos de usuarios que intervienen en el sistema.
