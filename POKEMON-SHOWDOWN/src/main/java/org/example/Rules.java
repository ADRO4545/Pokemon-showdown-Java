package org.example;

public class Rules {

    /**
     * 
     * @param pokemon1
     * @param pokemon2
     * @return true if pokemon1 begin, false if pokemon2 begin
     */

    public boolean whoBegin(Pokemon pokemon1, Pokemon pokemon2) {
        if (pokemon1.getSpeed() > pokemon2.getSpeed()) {
            return true;
        } else {
            return false;
        }

    }

}
