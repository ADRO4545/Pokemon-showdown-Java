package org.example;

public class Status {
    private String name;
    private double coefDamage;
    private double coefclassicAttack;
    private double coefSpeed;


    public Status(String name, double coefDamage, double coefclassicAttack, double coefSpeed ) {
        this.name = name;
        this.coefDamage = coefDamage;
        this.coefclassicAttack = coefclassicAttack;
        this.coefSpeed = coefSpeed;

    }

    public String getName() {
        return name;
    }

    public double getCoefDamage() {
        return coefDamage;
    }

    public double getCoefclassicAttack() {
        return coefclassicAttack;
    }

    public double getCoefSpeed() {
        return coefSpeed;
    }

    public void setName(String name) {
        this.name=name;
    }




}
