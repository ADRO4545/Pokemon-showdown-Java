package org.example;

import java.util.HashMap;

public class Type {
    private String name;
    private HashMap<String, Double> efficiencies = new HashMap<>();


    public Type(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addEfficiency(String defenderTypeName, Double coef){
        efficiencies.put(defenderTypeName,coef);
    }

    public double getCoef(Type defender){
        return this.efficiencies.get(defender.getName());
    }






}