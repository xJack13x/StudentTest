package com.company;

public enum ObecnoscType {

    OBECNY("obecny","o"),
    NIEOBECNY("nieobecny", "n");

    private String name;
    private String symbol;

    ObecnoscType(String name,String symbol){
        this.name=name;
        this.symbol=symbol;
    }



}
