package Clases;

import Controller.Contacto;
import ExcepcionesPersonalizadas.Miexcepciones;
import Vista.vista;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Agenda {

    static private List<Contacto> listaContactos = new ArrayList<>();
    private final String FILE_PATH = "src/main/resources/agenda.json";
    private Gson gson = new Gson();

    public void guardarContacto(vista view) {
        String desicion = "s";
        while (desicion == "s") {
            try {
                crearContacto(view);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            desicion = view.cargarOtro();
            if (desicion.equals("s")) {
                guardarContacto(view);
            }
        }
    }

    public void guardarContacto2(vista view) {

        try {
            crearContacto(view);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            String desicion = view.cargarOtro();
            if (desicion.equals("s")) {
                guardarContacto(view);
            }
        }
    }


    public void crearContacto(vista view) {
        String nombre = view.pedirNombre();
        String email = view.pedirEmail();
        String telefono = view.pedirTelefono();
        Contacto c = new Contacto(nombre, telefono, email);
        listaContactos.add(c);

    }

    public void listarContactos() {
        for (Contacto c : listaContactos) {
            System.out.println(c.toString());
        }
    }

    public boolean trycatch(String atributo) {
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

    ///Metodos para leer archivo

    public void cargarContactosPublico() {
        cargarContactos();
    }
    private void cargarContactos() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<ArrayList<Contacto>>() {
            }.getType();
            listaContactos = gson.fromJson(reader, listType);
            if (listaContactos == null) {
                listaContactos = new ArrayList<>();
            }
        } catch (FileNotFoundException e) {
            listaContactos = new ArrayList<>();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void guardarAgendaPublico() {
        guardarAgenda();
    }

    private void guardarAgenda ()
    {
        try (Writer writer = new FileWriter(FILE_PATH)){
            gson.toJson(listaContactos,writer);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }





}




