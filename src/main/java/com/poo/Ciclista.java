package com.poo;

public abstract class Ciclista {
     // Atributos privados
    private int identificador;
    private String nombre;
    private int tiempoAcumulado;

    // Constructor
    public Ciclista(int identificador, String nombre) {
        if (identificador <= 0) {
            throw new IllegalArgumentException("El identificador debe ser mayor que 0");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        this.identificador = identificador;
        this.nombre = nombre;
        this.tiempoAcumulado = 0;
    }

    // Métodos Getter y Setter
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        if (identificador <= 0) {
            throw new IllegalArgumentException("El identificador debe ser mayor que 0");
        }
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        this.nombre = nombre;
    }

    public int getTiempoAcumulado() {
        return tiempoAcumulado;
    }

    public void setTiempoAcumulado(int tiempoAcumulado) {
        if (tiempoAcumulado < 0) {
            throw new IllegalArgumentException("El tiempo acumulado no puede ser negativo");
        }
        this.tiempoAcumulado = tiempoAcumulado;
    }

    // Métodos específicos
    public abstract String imprimirTipo();

    public void imprimirDatos() {
        System.out.println("Identificador: " + identificador);
        System.out.println("Nombre: " + nombre);
        System.out.println("Tiempo Acumulado: " + tiempoAcumulado +"min");
        System.out.println("Tipo: " + imprimirTipo());
    }
}
