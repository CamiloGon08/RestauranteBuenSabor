


public class Producto {
    
    private final String nombre;
    private final double precio;
    private int cantidad;

    public Producto(String nombre, double precio) {
        this.nombre   = nombre;
        this.precio   = precio;
        this.cantidad = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad >= 0) {
            this.cantidad = cantidad;
        }
    }

    public void agregarCantidad(int unidades) {
        if (unidades > 0) {
            this.cantidad += unidades;
        }
    }

    public void reiniciarCantidad() {
        this.cantidad = 0;
    }
   




}
