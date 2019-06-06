package com.company;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Student {

    Integer nrId;
    String name;

    Map<Date, Obecnosc> ewidencjaObecnosci;

    Map<Integer, Ocena> ocenyStudenta;

    public void setNrId(Integer nrId) {
        this.nrId = nrId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    String surname;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getNrId(){
        return nrId;
    }

    public Student(Integer nrId, String name, String surname)
    {
        this.name = name;
        this.surname = surname;
        this.nrId = nrId;
    }

    public Student() {
        ocenyStudenta = new HashMap<>();
        ewidencjaObecnosci = new HashMap<>();
    }

    public Map<Date, Obecnosc> getEwidencjaObecnosci() {
        return ewidencjaObecnosci;
    }

    public Map<Integer, Ocena> getOcenyStudenta() {

        return ocenyStudenta;
    }

    public void setOcenyStudenta(Map<Integer, Ocena> ocenyStudenta) {

        this.ocenyStudenta = ocenyStudenta;
    }

    public Double policzSrednia(){
        if(this.ocenyStudenta != null){
            Double suma = 0.0;
            for(Ocena o : ocenyStudenta.values()){
                suma += o.getWartosc();
            }

            return suma/ ocenyStudenta.size();
        }
        return 0.0;
    }

    public int wyliczNieobecnosci(){
        int counter = 0;
        if(ewidencjaObecnosci.isEmpty()) return counter;

        for(Obecnosc o: ewidencjaObecnosci.values()){
            if(o.getTypObecnosci().equals(ObecnoscType.NIEOBECNY)) counter++;
        }

        return  counter;
    }
}
