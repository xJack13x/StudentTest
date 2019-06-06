package com.company;

import java.util.HashMap;
import java.util.Map;

public enum Przedmiot {

    Matematyka ("M"),
    Fizyka ("F"),
    Chemia ("C");

    String nazwaPrzedmiotu;

    private Przedmiot(String n){
        nazwaPrzedmiotu=n;
    }

    public static Przedmiot getByName(String name){
        Map<String, Przedmiot> przedmionty = new HashMap<>();
        for(Przedmiot p : Przedmiot.values()){
            przedmionty.put(p.nazwaPrzedmiotu, p);
        }
        return przedmionty.get(name);
    }

}
