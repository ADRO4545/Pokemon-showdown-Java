package org.example;

public class Pokemon {
    private String name;
    private int hp;
    private int speed;

    private int specialAttack;
    private int classicAttack;

    private int specialDefense;
    private int classicDefense;

    // private Type type;

    public Pokemon(String name,
            int hp,
            int speed,
            int specialAttack,
            int classicAttack,
            int specialDefense,
            int classicDefense
    // Type type
    ) {
        this.name = name;
        this.hp = hp;
        this.speed = speed;
        this.specialAttack = specialAttack;
        this.classicAttack = classicAttack;
        this.specialDefense = specialDefense;
        this.classicDefense = classicDefense;
        // this.type = type;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getHp() {
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

    // public Type getType() {
    // return type;
    // }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
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

    // public void setType(Type type) {
    // this.type = type;
    // }

    public String toString() {
        return "Pokemon [name=" + name +
                ", hp=" + hp +
                ", speed=" + speed +
                ", specialAttack=" + specialAttack +
                ", classicAttack=" + classicAttack +
                ", specialDefense=" + specialDefense +
                ", classicDefense=" + classicDefense + "]";
    }
}
