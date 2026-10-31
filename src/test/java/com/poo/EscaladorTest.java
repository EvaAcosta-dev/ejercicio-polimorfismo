package com.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EscaladorTest {

    private Escalador escalador;

    @BeforeEach
    void setUp() {
        escalador = new Escalador(102, "Lauren Sofia", 25.0f, 15.5f);
    }

    @Test
    void constructorInicializaAtributos() {
        // Valida que el constructor asigne identificador, nombre, tiempo acumulado, aceleración promedio y grado de rampa
        assertEquals(102, escalador.getIdentificador());
        assertEquals("Lauren Sofia", escalador.getNombre());
        assertEquals(0, escalador.getTiempoAcumulado());
        assertEquals(25.0f, escalador.getAceleracionPromedio());
        assertEquals(15.5f, escalador.getGradoRampa());
    }

    @Test
    void getterSetterAceleracionPromedio() {
        // Valida que la aceleración promedio se pueda cambiar y recuperar correctamente
        escalador.setAceleracionPromedio(30.0f);
        assertEquals(30.0f, escalador.getAceleracionPromedio());
    }

    @Test
    void getterSetterGradoRampa() {
        // Valida que el grado de rampa se pueda cambiar y recuperar correctamente
        escalador.setGradoRampa(20.0f);
        assertEquals(20.0f, escalador.getGradoRampa());
    }

    @Test
    void imprimirTipoRetornaEspera() {
        // Valida que imprimirTipo retorne la cadena específica de la clase Escalador
        assertEquals("Es una Escaladora", escalador.imprimirTipo());
    }

    @Test
    void esInstanciaDeCiclista() {
        // Valida polimorfismo: un Escalador es una instancia de su clase padre Ciclista
        assertInstanceOf(Ciclista.class, escalador);
    }

    @Test
    void aceleracionInvalidaLanzaExcepcion() {
        // Valida que se lance IllegalArgumentException al crear con aceleración menor o igual a cero
        assertThrows(IllegalArgumentException.class, () -> new Escalador(1, "A", 0, 10));
        assertThrows(IllegalArgumentException.class, () -> new Escalador(1, "A", -5, 10));
    }

    @Test
    void gradoRampaNegativoLanzaExcepcion() {
        // Valida que se lance IllegalArgumentException al crear con grado de rampa negativo
        assertThrows(IllegalArgumentException.class, () -> new Escalador(1, "A", 10, -1));
    }
}
