public class Proceso {

public static double hacerTodo(){
    private Proceso() {}

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

}