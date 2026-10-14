package com.poo;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String nombreEquipo;
    private String pais;
    private static int tiempoTotalEquipo = 0;
    private final List<Ciclista> ciclistas;

    public Equipo(String nombreEquipo, String pais) {
        this.nombreEquipo = nombreEquipo;
        this.pais = pais;
        this.ciclistas = new ArrayList<>();
    }

    protected String getNombreEquipo() {
        return nombreEquipo;
    }

    protected void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    protected String getPais() {
        return pais;
    }

    protected void setPais(String pais) {
        this.pais = pais;
    }

    protected static int getTiempoTotalEquipo() {
        return tiempoTotalEquipo;
    }

    protected static void setTiempoTotalEquipo(int tiempoTotalEquipo) {
        Equipo.tiempoTotalEquipo = tiempoTotalEquipo;
    }
    
    protected void añadirCiclista(Ciclista ciclista) {
        ciclistas.add(ciclista);
    }

    protected void listarNombresCiclistas() {
        for (Ciclista ciclista : ciclistas) {
            System.out.println("- " + ciclista.getNombre());
        }
    }

    protected void calcularTotalTiempos() {
        int total = 0;
        for (Ciclista ciclista : ciclistas) {
            total += ciclista.getTiempoAcumulado();
        }
        tiempoTotalEquipo = total;
    }

    protected void imprimirDatosEquipo() {
        System.out.println("Equipo: " + nombreEquipo);
        System.out.println("País: " + pais);
        System.out.println("Tiempo total acumulado: " + tiempoTotalEquipo + " minutos");
    }

    protected void imprimirDatosCiclistaPorId(int id) {
        boolean encontrado = false;
        for (Ciclista ciclista : ciclistas) {
            if (ciclista.getIdentificador() == id) {
                ciclista.imprimirDatos();
                System.out.println(ciclista.imprimirTipo());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No existe un ciclista con el ID " + id + " en este equipo.");
        }
    }
}