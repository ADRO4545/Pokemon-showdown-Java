package org.example;

import java.util.HashMap;

public class Type{
private String name;

public Type(String name){
    this.name=name;
}

public String getName(){
    return this.name;
}

public double findCoefType(Pokemon defender, HashMap<String, HashMap<String, Double>> typeCombination){
    String typeDefender=defender.getType().getName();
    return typeCombination.get(this.name).get(typeDefender);
    }

}