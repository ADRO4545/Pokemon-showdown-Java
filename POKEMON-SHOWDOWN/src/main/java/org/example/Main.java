package org.example;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<String, Type> allTypes = Controller.findAllCoefType();
        Pokemon pikachu = new Pokemon("Pikachu", 100, 10, 10, 10, 10, 10, allTypes.get("Electric"));
        Pokemon squirtle = new Pokemon("Squirtle", 100, 10, 10, 10, 10, 10, allTypes.get("Normal"));
        Attack electric = new Attack ("Electric",10,"speciale", allTypes.get("Electric"));
        System.out.println(pikachu);
        System.out.println(squirtle);
        electric.receiveDamage(pikachu,squirtle,allTypes);
        System.out.println(squirtle.getHp());




    }
}