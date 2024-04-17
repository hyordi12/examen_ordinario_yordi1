package com.example.consolas;

import java.io.Serializable;

public class Producto implements Serializable {
    private String nombre;
    private String descripcion;
    private int imagenResId;
    private double precio;

    public Producto(String nombre, String descripcion, int imagenResId, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenResId = imagenResId;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getImagenResId() {
        return imagenResId;
    }

    public double getPrecio() {
        return precio;
    }

    // Opcional: Método para establecer el precio, útil si necesitas actualizar el precio después de crear el objeto
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

