package com.poo;

public class Velocista extends Ciclista {
    private double potenciaPromedio;
    private double velocidadPromedioSprint;

    public Velocista(int identificador, String nombre, double potenciaPromedio, double velocidadPromedioSprint) {
        super(identificador, nombre);
        if (potenciaPromedio <= 0) {
            throw new IllegalArgumentException("La potencia promedio debe ser mayor que 0");
        }
        if (velocidadPromedioSprint <= 0) {
            throw new IllegalArgumentException("La velocidad promedio en sprint debe ser mayor que 0");
        }
        this.potenciaPromedio = potenciaPromedio;
        this.velocidadPromedioSprint = velocidadPromedioSprint;
    }

    public double getPotenciaPromedio() {
        return potenciaPromedio;
    }

    public void setPotenciaPromedio(double potenciaPromedio) {
        this.potenciaPromedio = potenciaPromedio;
    }

    public double getVelocidadPromedioSprint() {
        return velocidadPromedioSprint;
    }

    public void setVelocidadPromedioSprint(double velocidadPromedioSprint) {
        this.velocidadPromedioSprint = velocidadPromedioSprint;
    }

    @Override
    public String imprimirTipo() {
        return "Es un Velocista";
    }
    
    @Override
    public void imprimirDatos() {
        super.imprimirDatos();
        System.out.println("Potencia promedio: " + potenciaPromedio + " watts");
        System.out.println("Velocidad promedio en sprint: " + velocidadPromedioSprint + " km/h");
    }
}
