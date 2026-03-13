package org.example;

public class Main {
    public static void main(String[] args) {
        Pokemon pikachu = new Pokemon("Pikachu", 100, 10, 10, 10, 10, 10);
        Pokemon squirtle = new Pokemon("Squirtle", 100, 10, 10, 10, 10, 10);
        System.out.println(pikachu);
        System.out.println(squirtle);

        Attack thunderbolt = new Attack("Thunderbolt", 90, "Special");
        thunderbolt.attack(pikachu, squirtle);
        System.out.println(squirtle);
    }
}