package org.example;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Pokemon pikachu = new Pokemon("Pikachu", 100, 10, 10, 10, 10, 10, new Type("Fire"));
        Pokemon squirtle = new Pokemon("Squirtle", 100, 10, 10, 10, 10, 10, new Type("Normal"));
        Attack electric = new Attack ("Electric",10,"speciale", new Type("Fire"));
        System.out.println(pikachu);
        System.out.println(squirtle);
        HashMap<String, HashMap<String, Double>> typeCombination=Controller.findAllCoefType();
        electric.receiveDamage(pikachu,squirtle,typeCombination);
        System.out.println(squirtle.getHp());




    }
}