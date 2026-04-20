

public class Datos {

   // ── Constantes del restaurante ───────────────────────────────────────
    public static final String NOMBRE_RESTAURANTE    = "El Buen Sabor";
    public static final String DIRECCION             = "Calle 15 #8-32, Valledupar";
    public static final String NIT                   = "900.123.456-7";

    // ── Constantes del negocio ───────────────────────────────────────────
    public static final double TASA_IVA              = 0.19;
    public static final double TASA_PROPINA          = 0.10;
    public static final double TASA_DESCUENTO        = 0.05;
    public static final double UMBRAL_PROPINA        = 50_000.0;
    public static final int    MINIMO_PARA_DESCUENTO = 3;

    // ── Menú del restaurante ─────────────────────────────────────────────
    private static final Producto[] menu = {
        new Producto("Bandeja Paisa",       32_000),
        new Producto("Sancocho de Gallina", 28_000),
        new Producto("Arepa con Huevo",      8_000),
        new Producto("Jugo Natural",         7_000),
        new Producto("Gaseosa",              4_500),
        new Producto("Cerveza Poker",        6_000),
        new Producto("Agua Panela",          3_500),
        new Producto("Arroz con Pollo",     25_000),
    };

    // ── Estado de la mesa activa ─────────────────────────────────────────
    private static int     numeroMesa         = 0;
    private static boolean mesaActiva         = false;
    private static double  totalUltimaFactura = 0.0;
    private static int     numeroFactura      = 1;

    // ── Constructor privado: esta clase no debe instanciarse ─────────────
    private Datos() {}

    // ── Getters y setters del menú ───────────────────────────────────────

    public static Producto[] getMenu() {
        return menu;
    }

    public static int getTamanioMenu() {
        return menu.length;
    }

    // ── Getters y setters del estado de mesa ─────────────────────────────

    public static int getNumeroMesa() {
        return numeroMesa;
    }

    public static void setNumeroMesa(int mesa) {
        if (mesa >= 0) {
            numeroMesa = mesa;
        }
    }

    public static boolean isMesaActiva() {
        return mesaActiva;
    }

    public static void setMesaActiva(boolean activa) {
        mesaActiva = activa;
    }

    // ── Getters y setters de facturación ─────────────────────────────────

    public static double getTotalUltimaFactura() {
        return totalUltimaFactura;
    }

    public static void setTotalUltimaFactura(double total) {
        if (total >= 0) {
            totalUltimaFactura = total;
        }
    }

    public static int getNumeroFactura() {
        return numeroFactura;
    }

    public static void setNumeroFactura(int numero) {
        if (numero > 0) {
            numeroFactura = numero;
        }
    }

    public static void incrementarNumeroFactura() {
        numeroFactura++;
    }

}
