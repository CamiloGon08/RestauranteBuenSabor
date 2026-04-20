
public class Imprimir {
    // ── Constantes de formato ────────────────────────────────────────────
    private static final String SEPARADOR_DOBLE  = "========================================";
    private static final String SEPARADOR_SIMPLE = "----------------------------------------";
    private static final String FORMATO_ITEM     = "%-20s x%-6d $%,.0f%n";
    private static final String FORMATO_LINEA    = "%-27s $%,.0f%n";

    // ── Constructor privado: esta clase no debe instanciarse ─────────────
    private Imprimir() {}

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
}