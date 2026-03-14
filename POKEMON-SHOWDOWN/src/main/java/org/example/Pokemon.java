package org.example;

import java.util.ArrayList;

public class Pokemon {
    private String name;
    private double hp;
    private int speed;

    private int specialAttack;
    private int classicAttack;

    private int specialDefense;
    private int classicDefense;

    private ArrayList<Attack> listAttacks = new ArrayList<>();

    private Type type;
    private Type type2;

    public void addListAttacks(Attack a) {
        if (this.listAttacks.size() < 4) {
            this.listAttacks.add(a);
        }
    }

    public Pokemon(String name,
                   double hp,
                   int speed,
                   int specialAttack,
                   int classicAttack,
                   int specialDefense,
                   int classicDefense,
                   Type type,
                   Type type2
    ) {
        this.name = name;
        this.hp = hp;
        this.speed = speed;
        this.specialAttack = specialAttack;
        this.classicAttack = classicAttack;
        this.specialDefense = specialDefense;
        this.classicDefense = classicDefense;
        this.type = type;
        this.type2 = type2;
    }

    public Pokemon(String name, double hp, int speed, int specialAttack,
                   int classicAttack, int specialDefense,
                   int classicDefense, Type type) {

        this.name = name;
        this.hp = hp;
        this.speed = speed;
        this.specialAttack = specialAttack;
        this.classicAttack = classicAttack;
        this.specialDefense = specialDefense;
        this.classicDefense = classicDefense;
        this.type = type;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getHp() {
        return hp;
    }

    public int getSpeed() {
        return speed;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public int getClassicAttack() {
        return classicAttack;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public int getClassicDefense() {
        return classicDefense;
    }

    public Type getType() {
        return type;
    }

    public Type getType2() {
        return type2;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public void setClassicAttack(int classicAttack) {
        this.classicAttack = classicAttack;
    }

    public void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }

    public void setClassicDefense(int classicDefense) {
        this.classicDefense = classicDefense;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setType2(Type type2) {
        this.type2 = type2;
    }


    public String toString() {
        return "Pokemon [name=" + name +
                ", hp=" + hp +
                ", speed=" + speed +
                ", specialAttack=" + specialAttack +
                ", classicAttack=" + classicAttack +
                ", specialDefense=" + specialDefense +
                ", classicDefense=" + classicDefense +
                ", type=" + type.getName() + "]";
    }
}


