package Clases;

import Controller.Contacto;
import ExcepcionesPersonalizadas.Miexcepciones;
import Vista.vista;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

    static private List<Contacto> lista = new ArrayList<>();
    static vista view = new vista();

    public static void guardarContacto() {

        try{
            crearContacto();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
          String desicion = view.cargarOtro();
            if (desicion.equals("s"))
            {
                guardarContacto();
            }
        }
    }

    public void crearContacto()
    {
        String nombre =view.pedirNombre();
        String email = view.pedirEmail();
        String telefono = view.pedirTelefono();
        Contacto c = new Contacto(nombre, telefono, email);
        lista.add(c);

    }

    public static void listarContactos() {
        for (Contacto c : lista) {
            System.out.println(c.toString());
        }
    }
    public static boolean trycatch(String atributo) {
        boolean check = false;
        try {
            check = checkEmptyInput(atributo);
        } catch (Miexcepciones e) {
            System.err.println("Error: " + e.getMessage());
        }
        return check;
    }
    public static boolean checkEmptyInput(String input) throws Miexcepciones {
        if (input == null || input.trim().isEmpty()) {
            throw new Miexcepciones("El dato no puede estar vacío.");
        }
        return true;
    }

}




