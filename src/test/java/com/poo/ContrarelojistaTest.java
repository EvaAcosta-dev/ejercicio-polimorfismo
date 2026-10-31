package com.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContrarelojistaTest {

    private Contrarelojista contrarelojista;

    @BeforeEach
    void setUp() {
        contrarelojista = new Contrarelojista(101, "Eva Maria", 65.0);
    }

    @Test
    void constructorInicializaAtributos() {
        // Valida que el constructor asigne identificador, nombre, tiempo acumulado (0 por defecto) y velocidad máxima
        assertEquals(101, contrarelojista.getIdentificador());
        assertEquals("Eva Maria", contrarelojista.getNombre());
        assertEquals(0, contrarelojista.getTiempoAcumulado());
        assertEquals(65.0, contrarelojista.getVelocidadMaxima());
    }

    @Test
    void getterSetterVelocidadMaxima() {
        // Valida que la velocidad máxima se pueda cambiar y recuperar correctamente
        contrarelojista.setVelocidadMaxima(70.5);
        assertEquals(70.5, contrarelojista.getVelocidadMaxima());
    }

    @Test
    void imprimirTipoRetornaEspera() {
        // Valida que imprimirTipo retorne la cadena específica de la clase Contrarelojista
        assertEquals("Es una Contrarrelojista", contrarelojista.imprimirTipo());
    }

    @Test
    void esInstanciaDeCiclista() {
        // Valida polimorfismo: un Contrarelojista es una instancia de su clase padre Ciclista
        assertInstanceOf(Ciclista.class, contrarelojista);
    }

    @Test
    void imprimirDatosNoLanzaExcepcion() {
        // Valida que el método imprimirDatos se ejecute sin lanzar excepciones
        assertNotNull(contrarelojista);
        contrarelojista.imprimirDatos();
    }

    @Test
    void velocidadMaximaNegativaLanzaExcepcion() {
        // Valida que se lance IllegalArgumentException al crear con velocidad negativa o al setearla negativa
        assertThrows(IllegalArgumentException.class, () -> new Contrarelojista(101, "Eva", -5.0));
        assertThrows(IllegalArgumentException.class, () -> contrarelojista.setVelocidadMaxima(-1.0));
    }
}
