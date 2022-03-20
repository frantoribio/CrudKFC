package models;

import models.enums.TipoProducto;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int stock;
    private TipoProducto clase;
    private static int contador = 0;

    public Producto(String nombre, double precio, int stock, TipoProducto clase) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.clase = clase;
        this.id = ++contador;
    }

    public int getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoProducto getClase() {
        return clase;
    }

    public void setClase(TipoProducto clase) {
        this.clase = clase;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Producto.contador = contador;
    }

    @Override
    public String toString() {
        return "id = " + id +
                ", nombre = " + nombre +
                ", precio = " + precio +
                ", stock = " + stock + "\n";
    }
}
