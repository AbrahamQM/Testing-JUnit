package Stubs;

import java.util.ArrayList;

public class Combinado {
    private ArrayList<String> ingredientes = new ArrayList();

    public Combinado(){
        //Suposición de datos obtenidos desde un objeto o una bbdd que pueda ser CubaLibre
//        ingredientes.add("Ron");
//        ingredientes.add("Cola");
//        ingredientes.add("Lima");
//        ingredientes.add("Hielo");

        //Simulamos unos datos que nos da una bbdd de la que no sabemos los valores
        int valor = (int)(Math.random() * 100);

        for(int i = 0; i <= valor; i++){
            ingredientes.add(String.valueOf(i));
        }

    }

    public ArrayList<String> getIngredientes(){
        return ingredientes;
    }

    public int contarIngredientes(){
        return ingredientes.size();
    }
}
