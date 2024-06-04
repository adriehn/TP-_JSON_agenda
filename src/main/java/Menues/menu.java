package Menues;

import Vista.vista;

import java.io.IOException;
import java.util.Scanner;

public class menu {
    public static void main(String[] args) throws IOException {
        vista view = new vista();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        view.loadAgenda();
        view.mostrarAgenda();


        while (!salir) {
            view.mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    view.ampliarAgenda();
                    break;
                case 2:
                    view.mostrarAgenda();
                    break;
                case 3:
                    view.saveAgenda();
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción del 1 al 3.");
            }
        }

    }

}
