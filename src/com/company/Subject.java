package com.company;

import java.util.HashMap;
import java.util.Map;

public enum Subject {

    Matematyka ("M"),
    Fizyka ("F"),
    Chemia ("C");

    public String nameSubject;

    private Subject(String n){
        nameSubject=n;
    }

    public static Subject getByName(String name){
        Map<String, Subject> subjects = new HashMap<>();
        for(Subject p : Subject.values()){
            subjects.put(p.nameSubject, p);
        }
        return subjects.get(name);
    }

}
