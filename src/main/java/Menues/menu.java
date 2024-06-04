package Menues;

import Vista.vista;

import java.io.IOException;

public class menu {
    public static void main(String[] args) throws IOException {

        vista view = new vista();
        view.ampliarAgenda();
        view.mostrarAgenda();

    }
}
