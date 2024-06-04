package Vista;

import Clases.Agenda;

import java.util.Scanner;

public class vista {

    Scanner scanner = new Scanner(System.in);


    public void ampliarAgenda() {
        Agenda.guardarContacto();
    }

    public String pedirNombre() {
        System.out.println("Ingrese el nombre");
        String nombre = scanner.nextLine();
        if (!Agenda.trycatch(nombre)) {
            System.out.println("Reintente ingresar el dato.");
            nombre = pedirNombre();
        }
        return nombre;
    }

    public String pedirEmail() {
        System.out.println("Ingrese el email");
        String email = scanner.nextLine();
        if (!Agenda.trycatch(email)) {
            System.out.println("Reintente ingresar el dato.");
            email = pedirEmail();
        }
        return email;
    }

    public String pedirTelefono() {
        System.out.println("Ingrese el telefono");
        String telefono = scanner.nextLine();
        if (!Agenda.trycatch(telefono)) {
            System.out.println("Reintente ingresar el dato.");
            telefono = pedirTelefono();
        }
        return telefono;
    }


    public void mostrarAgenda() {
        Agenda.listarContactos();
    }


    public String cargarOtro() {
        System.out.println("Desea crear otro ? s/n");
        return scanner.nextLine();
    }

}
