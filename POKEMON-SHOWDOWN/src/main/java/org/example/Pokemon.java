package org.example;

import org.example.status.Statut;
import java.util.ArrayList;

public class Pokemon {
    private String name;
    private double hp;
    private int maxHp;
    private int speed;

    private int specialAttack;
    private int classicAttack;

    private int specialDefense;
    private int specialDefenseMax;
    private int classicDefense;
    int classicDefenseMax;
    private ArrayList<Attack> listAttacks = new ArrayList<>();

    private Type type;
    private Type type2;
    private Statut statut; // null = pas de statut
    private Status status;

    public void addListAttacks(Attack a) {
        if (this.listAttacks.size() < 4) {
            this.listAttacks.add(a);
        }
    }

    public Pokemon(String name,
                   double hp,
                   int maxHp,
                   int speed,
                   int specialAttack,
                   int classicAttack,
                   int specialDefense,
                   int specialDefenseMax,
                   int classicDefense,
                   int classicDefenseMax,
                   Type type,
                   Type type2,
                   Status status
    ) {
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
        this.speed = speed;
        this.specialAttack = specialAttack;
        this.classicAttack = classicAttack;
        this.specialDefense = specialDefense;
        this.specialDefenseMax = specialDefenseMax;
        this.classicDefense = classicDefense;
        this.classicDefenseMax = classicDefenseMax;
        this.type = type;
        this.type2 = type2;
        this.status = status;
    }

    public Pokemon(String name, double hp, int maxHp, int speed, int specialAttack,
                   int classicAttack, int specialDefense,
                   int specialDefenseMax,
                   int classicDefense,
                   int classicDefenseMax, Type type, Status status) {

        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
        this.speed = speed;
        this.specialAttack = specialAttack;
        this.classicAttack = classicAttack;
        this.specialDefense = specialDefense;
        this.specialDefenseMax = specialDefenseMax;
        this.classicDefense = classicDefense;
        this.classicDefenseMax = classicDefenseMax;
        this.type = type;
        this.status = status;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getHp() {
        return hp;
    }

    public double getMaxHp() {
        return maxHp;
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

    public int getSpecialDefenseMax() {
        return specialDefenseMax;
    }

    public int getClassicDefense() {
        return classicDefense;
    }

    public int getClassicDefenseMax() {
        return classicDefenseMax;
    }

    public Type getType() {
        return type;
    }

    public Type getType2() {
        return type2;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public Status getStatus() {
        return status;
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

    public void setStatus(Status status) {
        this.status = status;
    }

    public ArrayList<Attack> getListAttacks() {
        return listAttacks;
    }

    public String toString() {
        return "Pokemon [name=" + name +
                ", hp=" + hp +
                ", speed=" + speed +
                ", specialAttack=" + specialAttack +
                ", classicAttack=" + classicAttack +
                ", specialDefense=" + specialDefense +
                ", classicDefense=" + classicDefense +
                ", type=" + type.getName() +
                (type2 != null ? ", type2=" + type2.getName() : "") +
                "]";
    }
}
