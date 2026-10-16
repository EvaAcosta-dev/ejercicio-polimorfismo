package com.poo;

public interface Competible {
// Las variables en una interfaz son siempre public static final (constantes)
    int PUNTOS_BASE_PARTICIPACION = 10;

    // Métodos abstractos que obligatoriamente deben implementar las clases
    int calcularPuntosEtapa();
    boolean verificarClasificacion(int tiempoMaximo);
}
