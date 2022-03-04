package view;

import model.Hippodrome;

public class Menu {

    public static void main(String[] args) {
        Hippodrome hippodrome = new Hippodrome();

        MenuView menuView = new MenuView();
        while (true) {
            menuView.choixMenu();
        }
    }

}
