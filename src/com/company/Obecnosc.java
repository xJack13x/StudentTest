package com.company;

import java.util.Date;

public class Obecnosc {

    private ObecnoscType typObecnosci;

    private Date data;

    public Obecnosc(ObecnoscType typObecnosci, Date data){
        this.typObecnosci=typObecnosci;
        this.data=data;
    }

    public ObecnoscType getTypObecnosci() {
        return typObecnosci;
    }

}
