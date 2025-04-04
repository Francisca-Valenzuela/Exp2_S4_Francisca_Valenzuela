# Sistema de Venta de Entradas - Teatro Moro

Este proyecto simula un sistema de venta de entradas para el Teatro Moro, donde los usuarios pueden elegir asientos, aplicar descuentos según su edad y recibir un resumen de la compra. El sistema está desarrollado en Java.

## Requisitos

- Java 8 o superior.

## Funcionalidades

### Menú Principal
Al iniciar el programa, se despliega un menú con las siguientes opciones:
1. Comprar entrada
2. Salir

### Compra de Entrada
1. El usuario selecciona una zona (A, B, C) y un número de asiento.
2. El sistema valida la selección de zona y asiento.
3. Se solicita la edad del usuario para aplicar un descuento:
   - 10% de descuento para estudiantes (edad <= 18 años).
   - 15% de descuento para personas mayores de 60 años.
4. El sistema calcula el precio final con el descuento y muestra un resumen de la compra.

### Resumen de la Compra
El sistema muestra los siguientes detalles después de la compra:
- Ubicación del asiento
- Precio base de la entrada
- Descuento aplicado
- Precio final a pagar

### Ciclos Iterativos
El programa permite realizar múltiples compras sin reiniciar el sistema.

### Manejo de Errores
El sistema maneja entradas inválidas para zonas, asientos y edades, asegurando una experiencia de usuario fluida.
