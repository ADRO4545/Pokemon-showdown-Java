package org.example;

public class BaiePrine implements Item {

    @Override
    public String getName() {
        return "BaiePrine";
    }

    public void effectAfterStatus(Pokemon p){

        if(p.getStatus()!=null){
            p.setStatus(null);
            p.setItem(null);
        }


    }


}
