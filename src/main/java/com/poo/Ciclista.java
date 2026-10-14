package com.poo;

public abstract class Ciclista {
     // Atributos privados
    private int identificador;
    private String nombre;
    private int tiempoAcumulado;

    // Constructor
    public Ciclista(int identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.tiempoAcumulado = 0; // Inicializado por defecto
    }

    // Métodos Getter y Setter
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempoAcumulado() {
        return tiempoAcumulado;
    }

    public void setTiempoAcumulado(int tiempoAcumulado) {
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
