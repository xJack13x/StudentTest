package com.company;

import java.util.HashMap;
import java.util.Map;

public class Dziennik {

    private static Map<Integer, Student> studenci = new HashMap<>();

    public static void dodajStudenta(Integer id, String imie, String nazwisko) throws IllegalArgumentException{
        if(id == null )
            id = wygenerujIdentyfikator(studenci);

        if(studenci.containsKey(id)){
            throw new IllegalArgumentException("Student o takim identyfikatorze już istnieje");
        } else {
            studenci.put (id, new Student(id, imie, nazwisko));
        }
    }

    public static Map<Integer, Student> listaStudentow() {
        return studenci;
    }

    public static Integer wygenerujIdentyfikator(Map mapa) throws IllegalArgumentException{
        if(mapa != null){
            return mapa.size() + 1;
        }
        throw new IllegalArgumentException("Nie można wygenerować identyfikatora");
    }

    public static void zmienImieStudenta(Integer idStudent, String name) throws IllegalArgumentException{
        if(!studenci.containsKey(idStudent) || name.length() < 3) throw new IllegalArgumentException("Niepoprawne dane studenta");

        studenci.get(idStudent).setName(name);
    }

    public static void zmienNazwiskoStudenta(Integer idStudent, String surname) throws IllegalArgumentException{
        if(!studenci.containsKey(idStudent) || surname.length() < 3) throw new IllegalArgumentException("Niepoprawne dane studenta");

        studenci.get(idStudent).setName(surname);
    }

}
