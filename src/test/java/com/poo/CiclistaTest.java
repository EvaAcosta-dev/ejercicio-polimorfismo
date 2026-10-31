package com.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CiclistaTest {

    private CiclistaDePrueba ciclista;

    private static class CiclistaDePrueba extends Ciclista {
        public CiclistaDePrueba(int identificador, String nombre) {
            super(identificador, nombre);
        }

        @Override
        public String imprimirTipo() {
            return "Tipo de prueba";
        }
    }

    @BeforeEach
    void setUp() {
        ciclista = new CiclistaDePrueba(1, "Juan Perez");
    }

    @Test
    void constructorInicializaAtributos() {
        // Valida que el constructor asigne correctamente identificador, nombre y tiempo acumulado (0 por defecto)
        assertEquals(1, ciclista.getIdentificador());
        assertEquals("Juan Perez", ciclista.getNombre());
        assertEquals(0, ciclista.getTiempoAcumulado());
    }

    @Test
    void getterSetterIdentificador() {
        // Valida que el identificador se pueda asignar y recuperar mediante sus getter y setter
        ciclista.setIdentificador(42);
        assertEquals(42, ciclista.getIdentificador());
    }

    @Test
    void getterSetterNombre() {
        // Valida que el nombre se pueda cambiar y recuperar correctamente
        ciclista.setNombre("Maria Gomez");
        assertEquals("Maria Gomez", ciclista.getNombre());
    }

    @Test
    void getterSetterTiempoAcumulado() {
        // Valida que el tiempo acumulado se pueda asignar y recuperar mediante sus getter y setter
        ciclista.setTiempoAcumulado(150);
        assertEquals(150, ciclista.getTiempoAcumulado());
    }

    @Test
    void imprimirTipoRetornaValorEsperado() {
        // Valida que el método abstracto imprimirTipo retorne la cadena definida en la subclase de prueba
        assertEquals("Tipo de prueba", ciclista.imprimirTipo());
    }

    @Test
    void identificadorInvalidoLanzaExcepcion() {
        // Valida que se lance IllegalArgumentException al crear con id 0 o negativo, o al setear id negativo
        assertThrows(IllegalArgumentException.class, () -> new CiclistaDePrueba(0, "Juan"));
        assertThrows(IllegalArgumentException.class, () -> new CiclistaDePrueba(-5, "Juan"));
        assertThrows(IllegalArgumentException.class, () -> ciclista.setIdentificador(-1));
    }

    @Test
    void nombreInvalidoLanzaExcepcion() {
        // Valida que se lance IllegalArgumentException al crear con nombre nulo o vacío, o al setear nombre nulo
        assertThrows(IllegalArgumentException.class, () -> new CiclistaDePrueba(1, null));
        assertThrows(IllegalArgumentException.class, () -> new CiclistaDePrueba(1, "   "));
        assertThrows(IllegalArgumentException.class, () -> ciclista.setNombre(null));
    }

    @Test
    void tiempoNegativoLanzaExcepcion() {
        // Valida que se lance IllegalArgumentException al intentar asignar un tiempo acumulado negativo
        assertThrows(IllegalArgumentException.class, () -> ciclista.setTiempoAcumulado(-10));
    }
}
