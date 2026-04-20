public class proceso{

    
    private proceso() {}

    /**
    * Calcula la suma de (precio x cantidad) de todos los productos pedidos.
    */
    public static double calcularSubtotal() {
        double subtotal = 0.0;
        for (Producto producto : Datos.getMenu()) {
            if (producto.getCantidad() > 0) {
                subtotal += producto.getPrecio() * producto.getCantidad();
            }
        }
        return subtotal;
    }

     /**
     * Cuenta cuántos productos distintos tienen al menos una unidad pedida.
     */
    public static int contarProductosPedidos() {
        int contador = 0;
        for (Producto producto : Datos.getMenu()) {
            if (producto.getCantidad() > 0) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Aplica descuento del 5% cuando se pidieron más de
     * MINIMO_PARA_DESCUENTO productos distintos.
     */
    public static double aplicarDescuento(double subtotal, int productosDistintos) {
        if (productosDistintos > Datos.MINIMO_PARA_DESCUENTO) {
            return subtotal - (subtotal * Datos.TASA_DESCUENTO);
        }
        return subtotal;
    }

    /**
     * Calcula el IVA sobre la base imponible recibida.
     */
    public static double calcularIva(double baseImponible) {
        return baseImponible * Datos.TASA_IVA;
    }

    /**
     * Calcula la propina del 10% sobre el total con IVA
     * cuando este supera el UMBRAL_PROPINA.
     */
    public static double calcularPropina(double totalConIva) {
        if (totalConIva > Datos.UMBRAL_PROPINA) {
            return totalConIva * Datos.TASA_PROPINA;
        }
        return 0.0;
    }

    /**
     * Hace el cálculo completo de la factura y actualiza el estado global.
     * Retorna el total final (subtotal +/- descuento + IVA + propina).
     */
    public static double calcularTotalFactura() {
        double subtotal           = calcularSubtotal();
        int    productosDistintos = contarProductosPedidos();
        double baseImponible      = aplicarDescuento(subtotal, productosDistintos);
        double iva                = calcularIva(baseImponible);
        double totalConIva        = baseImponible + iva;
        double propina            = calcularPropina(totalConIva);
        double totalFinal         = totalConIva + propina;

        Datos.setMesaActiva(true);
        Datos.setTotalUltimaFactura(totalFinal);
        return totalFinal;
    }

}