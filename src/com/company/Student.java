package com.company;

public class Student {

    Integer nrId;
    String name;

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
}
