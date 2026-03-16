package org.example;

public class Restes implements Item {
    public String getName() {
        return "Restes";
    }

    public void effectEndTour(Pokemon holder) {
            double healthvalue = holder.getMaxHp() * 0.08;
            holder.setHp(holder.getHp() + healthvalue);
         if (holder.getHp()>holder.getMaxHp()){
            holder.setHp(holder.getMaxHp());
        }
    }
}

