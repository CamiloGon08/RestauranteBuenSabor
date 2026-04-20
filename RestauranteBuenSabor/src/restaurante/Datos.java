

public class Datos {

   public static final String NOMBRE_RESTAURANTE  = "El Buen Sabor";
    public static final String DIRECCION           = "Calle 15 38-32, Valledupar";
    public static final String NIT                 = "900.123.456-7";

    public static final double TASA_IVA              = 0.19;
    public static final double TASA_PROPINA          = 0.10;
    public static final double TASA_DESCUENTO        = 0.05;
    public static final double UMBRAL_PROPINA        = 50.000;
    public static final int    MINIMI_PARA_DESCUENTO = 3;

    private static final producto[] menu={
        new producto("Bandeja Paisa",       32.000),
        new producto("Sancocho de Gallina", 28.000),
        new producto("Arepa con Huevo",     8.000),
        new producto("Jugo Natural",        7.000),
        new producto("Gaseosa",             4.500),
        new producto("Cerveza Poker",       6.000),
        new producto("Agua Panela",         3.500),
        new producto("Arroz con Pollo",     25.000)
    };
    private static int     numeroMesa         = 0;
    private static boolean mesaActiva         = false;
    private static double  totalUltimaFactura = 0.0;
    private static int     numeroFactura      = 1;

    private Datos(){}

    
}
