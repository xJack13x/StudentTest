package com.company;

public class Ocena {

    private Integer idOcena;
    private Przedmiot przedmiot;
    private double wartosc;

    public Ocena(Integer idOcena, Przedmiot przedmiot, double wartosc){
        this.idOcena=idOcena;
        this.przedmiot=przedmiot;
        this.wartosc=wartosc;
    }

    public Integer getIdOcena() {
        return idOcena;
    }

    public void setIdOcena(Integer idOcena) {
        this.idOcena = idOcena;
    }

    public Przedmiot getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(Przedmiot przedmiot) {
        this.przedmiot = przedmiot;
    }

    public double getWartosc() {
        return wartosc;
    }

    public void setWartosc(double wartosc) {
        this.wartosc = wartosc;
    }
}
