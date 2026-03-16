package org.example;

public class BaiePrine implements Item {

    @Override
    public String getName() {
        return "BaiePrine";
    }

    public void effectAfterStatus(Pokemon holder) {

        if (holder.getStatus() != null) {
            holder.setStatus(null);
            holder.setItem(null);
        }

    }

}
