# Restaurante El Buen Sabor — Sistema de Facturación

## Descripción
Sistema de facturación por consola para el Restaurante El Buen Sabor,
desarrollado en Java. El proyecto fue refactorizado aplicando principios
de Código Limpio (Clean Code) según Robert C. Martin.

## Estructura del proyecto
El sistema está compuesto por 6 clases:

- **Producto** — Representa un ítem del menú con nombre, precio y cantidad
- **Datos** — Almacén central del estado del restaurante y constantes del negocio
- **proceso** — Lógica de cálculo financiero de la factura
- **utilidades** — Métodos auxiliares del sistema
- **imprimir** — Presentación en consola de carta, pedido y facturas
- **RestauranteElBuenSabor** — Punto de entrada del sistema

## Funcionalidades
- Ver carta del restaurante con precios
- Agregar productos al pedido por mesa
- Ver pedido actual con subtotal
- Generar factura con IVA (19%), descuento (5%) y propina (10%)
- Reiniciar mesa para nuevo cliente

## Reglas del negocio
- Se aplica **5% de descuento** si se piden más de 3 productos distintos
- Se aplica **IVA del 19%** sobre el subtotal con descuento
- Se aplica **propina del 10%** si el total con IVA supera $50.000

## Malas prácticas corregidas
Se identificaron y corrigieron **34 malas prácticas** distribuidas en:

| Archivo | Falencias corregidas |
|---|---|
| Datos.java | #1 al #6 — God Object, arrays paralelos, sin encapsulamiento |
| proceso.java | #7 al #15 — Lógica duplicada, magic numbers, método monolítico |
| utilidades.java | #16 al #20 — Efectos secundarios ocultos, código muerto |
| imprimir.java | #21 al #25 — Cálculo duplicado, copy-paste masivo, hardcoding |
| RestauranteElBuenSabor.java | #26 al #30 — main monolítico, variables zombi |
| Todos los archivos | #31 al #34 — Formato, indentación, llaves |

## Principios aplicados
- **SRP** — Single Responsibility Principle
- **DRY** — Don't Repeat Yourself
- **Encapsulamiento** — Campos privados con getters y setters
- **Nombres significativos** — Identificadores que revelan intención
- **Funciones pequeñas** — Métodos con una sola responsabilidad
- **Sin efectos secundarios** — Métodos que no modifican estado oculto
- **Sin código muerto** — Variables y métodos no usados eliminados
- **Formato consistente** — Indentación y estilo uniformes

## Referencias
- Robert C. Martin — *Clean Code: A Handbook of Agile Software Craftsmanship*. Prentice Hall, 2009.
- Shahan Chowdhury — *The Clean Code Handbook*. FreeCodeCamp, Enero 2025.

## Autor
Camilo Andrés González García
Ingeniería de Sistemas e Informática
Universidad Popular del Cesar
Asignatura: Programación de Computadores III — SS462 — Cuarto Semestre
Docente: Ing. Alfredo David Bautista Romero