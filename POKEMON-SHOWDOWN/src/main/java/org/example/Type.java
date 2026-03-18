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
        if (defender == null) return 1.0;

        Double coef = this.efficiencies.get(defender.getName());
        if (coef == null) return 1.0;

        return coef;
    }






}