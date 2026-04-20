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

}