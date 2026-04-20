public class Utilidades {
    
 
    private Utilidades() {}

    // ── Métodos auxiliares ───────────────────────────────────────────────

    /**
     * Indica si el pedido actual tiene al menos un producto.
     * Solo consulta — no modifica ningún estado global.
     */
    public static boolean pedidoTieneProductos() {
        for (Producto producto : Datos.getMenu()) {
            if (producto.getCantidad() > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Reinicia el pedido actual y el estado de la mesa
     * para atender un nuevo cliente.
     */
    public static void reiniciarMesa() {
        for (Producto producto : Datos.getMenu()) {
            producto.reiniciarCantidad();
        }
        Datos.setTotalUltimaFactura(0.0);
        Datos.setMesaActiva(false);
        Datos.setNumeroMesa(0);
    }

}