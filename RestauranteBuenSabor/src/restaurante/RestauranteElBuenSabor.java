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

    
}