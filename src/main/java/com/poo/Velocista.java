package com.poo;

public class Velocista extends Ciclista implements Competible {
    private double potenciaPromedio;
    private double velocidadPromedioSprint;

    public Velocista(int identificador, String nombre, double potenciaPromedio, double velocidadPromedioSprint) {
        super(identificador, nombre);
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
        public int calcularPuntosEtapa() {
            // Un velocista gana puntos extra si su velocidad de sprint es alta
            if (velocidadPromedioSprint > 65.0) {
                return PUNTOS_BASE_PARTICIPACION + 50;
            }
            return PUNTOS_BASE_PARTICIPACION + 20;
        }
 
        @Override
        public boolean verificarClasificacion(int tiempoMaximo) {
            // Verifica si el tiempo acumulado está dentro del límite permitido
            return getTiempoAcumulado() <= tiempoMaximo;
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
