package com.poo;

public class Contrarelojista extends Ciclista {
    private double velocidadMaxima;

    public Contrarelojista(int identificador, String nombre, double velocidadMaxima) {
        super(identificador, nombre);
        this.velocidadMaxima = velocidadMaxima;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }
//polimorfismo dinamico mediante sobreescritura y es en tiempo de ejecucion 
//compilador por si solo no sabe que metodo implementar hasta que se defina el objeto
    @Override
    public String imprimirTipo() {
        return "Es un Contrarrelojista";
    }

    @Override
    public void imprimirDatos() {
        super.imprimirDatos();
        System.out.println("Velocidad Máxima: " + velocidadMaxima + " km/h");
    }
}