import java.util.Scanner;

public class RestauranteElBuenSabor {

    private static final String  SEPARADOR = "========================================";
    private static final Scanner entrada   = new Scanner(System.in);

    // ── Punto de entrada ─────────────────────────────────────────────────

    public static void main(String[] args) {
        imprimirBienvenida();
        ejecutarMenuPrincipal();
        entrada.close();
    }

    private static void ejecutarMenuPrincipal() {
        boolean activo = true;
        while (activo) {
            mostrarOpciones();
            int opcion = leerEntero("Seleccione una opcion: ");
            activo = procesarOpcion(opcion);
        }
    }

    private static void mostrarOpciones() {
        System.out.println("1. Ver carta");
        System.out.println("2. Agregar producto al pedido");
        System.out.println("3. Ver pedido actual");
        System.out.println("4. Generar factura");
        System.out.println("5. Nueva mesa");
        System.out.println("0. Salir");
        System.out.println(SEPARADOR);
    }

    private static boolean procesarOpcion(int opcion) {
        switch (opcion) {
            case 1  -> verCarta();
            case 2  -> agregarProducto();
            case 3  -> verPedido();
            case 4  -> generarFactura();
            case 5  -> nuevaMesa();
            case 0  -> { System.out.println("Hasta luego!"); return false; }
            default -> System.out.println("Opcion no valida. Seleccione entre 0 y 5.");
        }
        return true;
    }

    // ── Opciones del menú ────────────────────────────────────────────────

    private static void verCarta() {
        Imprimir.mostrarCarta();
        System.out.println();
    }

    private static void agregarProducto() {
        System.out.println("--- AGREGAR PRODUCTO ---");
        int numero   = leerEntero("Numero de producto (1-" + Datos.getTamanioMenu() + "): ");
        int cantidad = leerEntero("Cantidad: ");

        if (!numeroProductoValido(numero)) {
            System.out.println("Producto no existe. La carta tiene "
                + Datos.getTamanioMenu() + " productos.");
            System.out.println();
            return;
        }

        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser un valor positivo.");
            System.out.println();
            return;
        }

        if (!Datos.isMesaActiva()) {
            registrarNumeroDeMesa();
        }

        Producto producto = Datos.getMenu()[numero - 1];
        producto.agregarCantidad(cantidad);
        System.out.println("Producto agregado: " + producto.getNombre() + " x" + cantidad);
        System.out.println();
    }

    private static void verPedido() {
        System.out.println();
        if (Utilidades.pedidoTieneProductos()) {
            Imprimir.mostrarPedido();
        } else {
            System.out.println("No hay productos en el pedido actual.");
            System.out.println("Use la opcion 2 para agregar productos.");
        }
        System.out.println();
    }

    private static void generarFactura() {
        System.out.println();
        if (!Utilidades.pedidoTieneProductos()) {
            System.out.println("No hay productos en el pedido.");
            System.out.println("Use la opcion 2 para agregar productos primero.");
            System.out.println();
            return;
        }
        Proceso.calcularTotalFactura();
        Imprimir.imprimirFacturaCompleta();
        System.out.println();
    }

    private static void nuevaMesa() {
        System.out.println();
        Utilidades.reiniciarMesa();
        System.out.println("Mesa reiniciada. Lista para nuevo cliente.");
        System.out.println();
    }

}