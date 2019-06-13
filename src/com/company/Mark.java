package com.company;

public class Mark {

    private Integer idMark;
    private Subject subject;
    private double value;

    public Mark(Integer idMark, Subject subject, double value){
        this.idMark=idMark;
        this.subject = subject;
        this.value = value;
    }

    public Integer getIdMark() {
        return idMark;
    }

    public void setIdMark(Integer idMark) {
        this.idMark = idMark;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
