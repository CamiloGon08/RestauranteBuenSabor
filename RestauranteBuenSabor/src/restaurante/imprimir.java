
public class imprimir {
    // ── Constantes de formato ────────────────────────────────────────────
    private static final String SEPARADOR_DOBLE  = "========================================";
    private static final String SEPARADOR_SIMPLE = "----------------------------------------";
    private static final String FORMATO_ITEM     = "%-20s x%-6d $%,.0f%n";
    private static final String FORMATO_LINEA    = "%-27s $%,.0f%n";

    // ── Constructor privado: esta clase no debe instanciarse ─────────────
    private imprimir() {}

    // ── Carta ────────────────────────────────────────────────────────────

    /**
     * Muestra el menú completo del restaurante con precios.
     */
    public static void mostrarCarta() {
        System.out.println(SEPARADOR_DOBLE);
        System.out.println("    RESTAURANTE " + Datos.NOMBRE_RESTAURANTE);
        System.out.println("    --- NUESTRA CARTA ---");
        System.out.println(SEPARADOR_DOBLE);

        Producto[] menu = Datos.getMenu();
        for (int i = 0; i < menu.length; i++) {
            System.out.printf(
                "%d. %-22s $%,.0f%n",
                i + 1,
                menu[i].getNombre(),
                menu[i].getPrecio()
            );
        }

        System.out.println(SEPARADOR_DOBLE);
    }

     /**
     * Muestra los productos del pedido actual con su subtotal parcial.
     */
    public static void mostrarPedido() {
        System.out.println("--- PEDIDO ACTUAL ---");

        double subtotal = 0.0;
        for (Producto producto : Datos.getMenu()) {
            if (producto.getCantidad() > 0) {
                double parcial = producto.getPrecio() * producto.getCantidad();
                System.out.printf(
                    FORMATO_ITEM,
                    producto.getNombre(),
                    producto.getCantidad(),
                    parcial
                );
                subtotal += parcial;
            }
        }

        System.out.println(SEPARADOR_SIMPLE);
        System.out.printf(FORMATO_LINEA, "Subtotal:", subtotal);
    }


    /**
     * Imprime el encabezado del restaurante y el número de factura.
     *
     * @param esResumen true para agregar el sufijo "(RESUMEN)" al número
     */
    private static void imprimirEncabezado(boolean esResumen) {
        System.out.println(SEPARADOR_DOBLE);
        System.out.println("    RESTAURANTE " + Datos.NOMBRE_RESTAURANTE);
        System.out.println("    " + Datos.DIRECCION);
        System.out.println("    NIT: " + Datos.NIT);
        System.out.println(SEPARADOR_DOBLE);

        if (esResumen) {
            System.out.printf("FACTURA No. %03d (RESUMEN)%n", Datos.getNumeroFactura());
        } else {
            System.out.printf("FACTURA No. %03d%n", Datos.getNumeroFactura());
        }

        System.out.println(SEPARADOR_SIMPLE);
    }

    /**
     * Imprime cada producto del pedido con cantidad y valor parcial.
     */
    private static void imprimirDetalleProductos() {
        for (Producto producto : Datos.getMenu()) {
            if (producto.getCantidad() > 0) {
                System.out.printf(
                    FORMATO_ITEM,
                    producto.getNombre(),
                    producto.getCantidad(),
                    producto.getPrecio() * producto.getCantidad()
                );
            }
        }
        System.out.println(SEPARADOR_SIMPLE);
    }

    /**
     * Imprime subtotal, IVA, propina (si aplica) y total final.
     * Reutiliza los métodos de cálculo de Proceso para no duplicar lógica.
     */
    private static void imprimirTotales() {
        double subtotal           = proceso.calcularSubtotal();
        int    productosDistintos = proceso.contarProductosPedidos();
        double baseImponible      = proceso.aplicarDescuento(subtotal, productosDistintos);
        double iva                = proceso.calcularIva(baseImponible);
        double totalConIva        = baseImponible + iva;
        double propina            = proceso.calcularPropina(totalConIva);
        double totalFinal         = totalConIva + propina;

        System.out.printf(FORMATO_LINEA, "Subtotal:",  baseImponible);
        System.out.printf(FORMATO_LINEA, "IVA (19%):", iva);

        if (propina > 0) {
            System.out.printf(FORMATO_LINEA, "Propina (10%):", propina);
        }

        System.out.println(SEPARADOR_SIMPLE);
        System.out.printf(FORMATO_LINEA, "TOTAL:", totalFinal);
        System.out.println(SEPARADOR_DOBLE);
    }

    /**
     * Imprime el pie de página de agradecimiento.
     */
    private static void imprimirPieDePagina() {
        System.out.println("Gracias por su visita!");
        System.out.println("El Buen Sabor - Valledupar");
        System.out.println(SEPARADOR_DOBLE);
    }


}