package com.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VelocistaTest {

    private Velocista velocista;

    @BeforeEach
    void setUp() {
        velocista = new Velocista(101, "Stiven Franco", 800.0, 70.5);
    }

    @Test
    void constructorInicializaAtributos() {
        // Valida que el constructor asigne identificador, nombre, tiempo acumulado, potencia promedio y velocidad de sprint
        assertEquals(101, velocista.getIdentificador());
        assertEquals("Stiven Franco", velocista.getNombre());
        assertEquals(0, velocista.getTiempoAcumulado());
        assertEquals(800.0, velocista.getPotenciaPromedio());
        assertEquals(70.5, velocista.getVelocidadPromedioSprint());
    }

    @Test
    void getterSetterPotenciaPromedio() {
        // Valida que la potencia promedio se pueda cambiar y recuperar correctamente
        velocista.setPotenciaPromedio(900.0);
        assertEquals(900.0, velocista.getPotenciaPromedio());
    }

    @Test
    void getterSetterVelocidadPromedioSprint() {
        // Valida que la velocidad promedio en sprint se pueda cambiar y recuperar correctamente
        velocista.setVelocidadPromedioSprint(75.0);
        assertEquals(75.0, velocista.getVelocidadPromedioSprint());
    }

    @Test
    void imprimirTipoRetornaEspera() {
        // Valida que imprimirTipo retorne la cadena específica de la clase Velocista
        assertEquals("Es un Velocista", velocista.imprimirTipo());
    }

    @Test
    void esInstanciaDeCiclista() {
        // Valida polimorfismo: un Velocista es una instancia de su clase padre Ciclista
        assertInstanceOf(Ciclista.class, velocista);
    }

    @Test
    void potenciaInvalidaLanzaExcepcion() {
        // Valida que se lance IllegalArgumentException al crear con potencia menor o igual a cero
        assertThrows(IllegalArgumentException.class, () -> new Velocista(1, "A", 0, 70));
        assertThrows(IllegalArgumentException.class, () -> new Velocista(1, "A", -100, 70));
    }

    @Test
    void velocidadSprintInvalidaLanzaExcepcion() {
        // Valida que se lance IllegalArgumentException al crear con velocidad de sprint menor o igual a cero
        assertThrows(IllegalArgumentException.class, () -> new Velocista(1, "A", 800, 0));
        assertThrows(IllegalArgumentException.class, () -> new Velocista(1, "A", 800, -5));
    }
}
