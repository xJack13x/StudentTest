package com.company;

public enum AttendanceType {

    OBECNY("obecny","o"),
    NIEOBECNY("nieobecny", "n");

    private String name;
    private String symbol;

    AttendanceType(String name, String symbol){
        this.name=name;
        this.symbol=symbol;
    }



}
