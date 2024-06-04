package Vista;

import Clases.Agenda;

import java.util.Scanner;

public class vista {

    Scanner scanner = new Scanner(System.in);
    Agenda agenda = new Agenda();

    public void ampliarAgenda() {
        agenda.guardarContacto(this);
    }

    public String pedirNombre() {
        System.out.println("Ingrese el nombre");
        String nombre = scanner.nextLine();
        if (!agenda.trycatch(nombre)) {
            System.out.println("Reintente ingresar el dato.");
            nombre = pedirNombre();
        }
        return nombre;
    }

    public String pedirEmail() {
        System.out.println("Ingrese el email");
        String email = scanner.nextLine();
        if (!agenda.trycatch(email)) {
            System.out.println("Reintente ingresar el dato.");
            email = pedirEmail();
        }
        return email;
    }

    public String pedirTelefono() {
        System.out.println("Ingrese el telefono");
        String telefono = scanner.nextLine();
        if (!agenda.trycatch(telefono)) {
            System.out.println("Reintente ingresar el dato.");
            telefono = pedirTelefono();
        }
        return telefono;
    }

    public void loadAgenda ()
    {
        agenda.cargarContactosPublico();
    }

    public void saveAgenda()
    {
        agenda.guardarAgendaPublico();
    }
    public void mostrarAgenda() {
        agenda.listarContactos();
    }
    public static void mostrarMenu() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Agendar contacto");
        System.out.println("2. Ver contactos");
        System.out.println("3. Salir");
        System.out.print("Opción: ");
    }
    public String cargarOtro() {
        System.out.println("Desea crear otro ? s/n");
        return scanner.nextLine();
    }
}
