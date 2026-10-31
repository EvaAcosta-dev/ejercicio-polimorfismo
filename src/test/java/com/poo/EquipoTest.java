package com.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EquipoTest {

    private Equipo equipo;

    @BeforeEach
    void setUp() {
        equipo = new Equipo("Los Malayas", "Colombia");
        Equipo.setTiempoTotalEquipo(0);
    }

    @Test
    void constructorInicializaAtributos() {
        // Valida que el constructor asigne correctamente nombre del equipo, país y tiempo total (0 por defecto)
        assertEquals("Los Malayas", equipo.getNombreEquipo());
        assertEquals("Colombia", equipo.getPais());
        assertEquals(0, Equipo.getTiempoTotalEquipo());
    }

    @Test
    void añadirYListarCiclistas() {
        // Valida que se pueda añadir un ciclista al equipo sin lanzar excepciones
        Ciclista ciclista = new Velocista(1, "Stiven Franco", 800.0, 70.5);
        equipo.añadirCiclista(ciclista);
        assertNotNull(ciclista);
    }

    @Test
    void calcularTotalTiempos() {
        // Valida que calcularTotalTiempos sume correctamente los tiempos acumulados de todos los ciclistas del equipo
        Ciclista v = new Velocista(1, "Stiven Franco", 800.0, 70.5);
        v.setTiempoAcumulado(320);
        Ciclista e = new Escalador(2, "Lauren Sofia", 25.0f, 15.5f);
        e.setTiempoAcumulado(340);
        Ciclista c = new Contrarelojista(3, "Eva Maria", 65.0);
        c.setTiempoAcumulado(310);

        equipo.añadirCiclista(v);
        equipo.añadirCiclista(e);
        equipo.añadirCiclista(c);
        equipo.calcularTotalTiempos();

        assertEquals(970, Equipo.getTiempoTotalEquipo());
    }

    @Test
    void imprimirDatosEquipoNoLanzaExcepcion() {
        // Valida que el método imprimirDatosEquipo se ejecute sin lanzar excepciones
        assertNotNull(equipo);
        equipo.imprimirDatosEquipo();
    }

    @Test
    void imprimirDatosCiclistaPorIdEncontrado() {
        // Valida que se pueda buscar e imprimir los datos de un ciclista existente por su identificador
        Ciclista v = new Velocista(101, "Stiven Franco", 800.0, 70.5);
        equipo.añadirCiclista(v);
        equipo.imprimirDatosCiclistaPorId(101);
    }

    @Test
    void nombreEquipoInvalidoLanzaExcepcion() {
        // Valida que se lance IllegalArgumentException al crear el equipo con nombre nulo o vacío
        assertThrows(IllegalArgumentException.class, () -> new Equipo(null, "Colombia"));
        assertThrows(IllegalArgumentException.class, () -> new Equipo("   ", "Colombia"));
    }

    @Test
    void paisInvalidoLanzaExcepcion() {
        // Valida que se lance IllegalArgumentException al crear el equipo con país nulo o vacío
        assertThrows(IllegalArgumentException.class, () -> new Equipo("Los Malayas", null));
        assertThrows(IllegalArgumentException.class, () -> new Equipo("Los Malayas", ""));
    }
}
