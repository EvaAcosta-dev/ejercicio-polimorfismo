package com.poo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Equipo equipo = new Equipo("Los Malayas", "Colombia");

        Velocista velocista = new Velocista(101, "Stiven Franco", 800.0, 70.5);
        velocista.setTiempoAcumulado(320);

        Escalador escalador = new Escalador(102, "Lauren Sofia", 25.0f, 15.5f);
        escalador.setTiempoAcumulado(340);

        Contrarelojista contrarelojista = new Contrarelojista(103, "Eva Maria", 65.0);
        contrarelojista.setTiempoAcumulado(310);

        equipo.añadirCiclista(velocista);
        equipo.añadirCiclista(escalador);
        equipo.añadirCiclista(contrarelojista);

        System.out.println("\n--- NOMBRES DE LOS INTEGRANTES ---");
        equipo.listarNombresCiclistas();

        System.out.println("\n--- RESUMEN DEL EQUIPO ---");
        equipo.calcularTotalTiempos();
        equipo.imprimirDatosEquipo();

        // Implementación de la búsqueda por teclado
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngrese el ID del ciclista que desea buscar: ");
        int idIngresado = sc.nextInt();
        
        System.out.println("\n--- RESULTADO DE LA BÚSQUEDA ---");
        equipo.imprimirDatosCiclistaPorId(idIngresado);

        sc.close();
    }
}