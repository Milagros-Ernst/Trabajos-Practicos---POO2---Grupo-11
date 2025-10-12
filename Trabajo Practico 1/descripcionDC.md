# Gestión de Pedidos de una Tienda Online

Este diagrama de clases representa el funcionamiento general de una tienda virtual. Muestra las clases principales que intervienen en el proceso de compra y venta de productos, desde la publicación por parte de un vendedor hasta la generación de la factura y el envío al cliente.

## Clases de Usuario

La clase Usuario es la clase base del sistema. Contiene los atributos y métodos comunes como nombre, apellido, DNI, mail y teléfono, además de las operaciones para iniciar y cerrar sesión.
De ella heredan tres tipos de usuarios:

- **Administrador:** encargado de la gestión del sistema. Puede crear y bloquear usuarios, además de generar reportes de ventas dentro de un rango de fechas.
- **Cliente:** representa al comprador dentro del sistema. Puede registrarse, gestionar su carrito de compras y realizar pedidos.
- **Vendedor:** se encarga de publicar productos, administrar sus publicaciones y mantener actualizado el stock y los precios. También puede consultar las ventas realizadas.

Cada usuario tiene asociada una Dirección, que almacena los datos de localización (provincia, ciudad, calle, código postal y nota adicional).

## Clases del Proceso de Venta

- **Producto:** representa los artículos que pueden ser publicados y vendidos. Contiene información básica como nombre, precio y stock, junto con métodos para modificar su precio o cantidad disponible.
- **Publicación:** creada por un vendedor, describe la oferta de un producto en la tienda. Incluye datos como título, descripción, estado, precio y stock, y métodos para pausar o finalizar la publicación.
- **Carrito:** pertenece a un cliente y contiene los productos seleccionados antes de concretar una compra. Permite agregar, quitar y calcular el total de los productos cargados.
- **Pedido:** representa la orden concreta de compra realizada por un cliente. Registra la lista de productos, la fecha y el estado del pedido, además de métodos para confirmarlo, cancelarlo o actualizar su estado.
- **Pago:** almacena los datos del pago de un pedido, como monto, fecha y estado. Posee métodos para procesar y actualizar el estado del pago.
- **Método de Pago:** define el tipo de medio utilizado (tarjeta, transferencia, efectivo, etc.) y puede estar asociado a varios pagos.
- **Envío:** gestiona la entrega del pedido al cliente. Incluye las fechas de envío y llegada, el estado y métodos para calcular el costo o actualizar su estado.
- **Factura:** se genera a partir de un pedido confirmado y un pago procesado. Registra la fecha de emisión y el total de la operación, e incluye un método para generar la factura.
- **Dirección:** se utiliza tanto para identificar el domicilio del usuario como para especificar el destino del envío. Contiene los datos de ubicación y un método para actualizar la dirección registrada.

## Relaciones Principales

- Un **vendedor crea publicaciones** y cada **publicación ofrece un producto.**
- Un **cliente posee un carrito** y **realiza pedidos** a partir de los productos agregados.
- Cada **pedido contiene varios productos**, tiene **asociado un envío, un pago y genera una factura.**
- Un **pago utiliza un método de pago.**
- Un **envío tiene una dirección** de destino.
- El **administrador gestiona usuarios** y **supervisa las operaciones del sistema.**

## Objetivo del Modelo

El modelo busca representar de manera estructurada el funcionamiento de una tienda virtual, describiendo el ciclo completo de compra y venta: desde la publicación de productos por parte de los vendedores, la selección y pedido de los clientes, hasta el procesamiento del pago, la generación de la factura y la entrega final del pedido.
Además, permite la administración general del sistema, garantizando la correcta gestión de usuarios, ventas y reportes.
