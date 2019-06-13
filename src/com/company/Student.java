package com.company;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Student {

    private Integer nrId;
    private String name;

    Map<Date, Attendance> attendancesRekord;

    Map<Integer, Mark> studentMarks;

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
        studentMarks = new HashMap<>();
        attendancesRekord = new HashMap<>();
    }

    public Map<Date, Attendance> getAttendancesRekord() {
        return attendancesRekord;
    }

    public void setAttendancesRekord(Map<Date, Attendance> attendancesRekord) {
        this.attendancesRekord = attendancesRekord;
    }

    public Map<Integer, Mark> getStudentMarks() {
        return studentMarks;
    }

    public void setStudentMarks(Map<Integer, Mark> studentMarks) {
        this.studentMarks = studentMarks;
    }

    public Double calculateAverage(){
        if(this.studentMarks != null){
            Double suma = 0.0;
            for(Mark o : studentMarks.values()){
                suma += o.getValue();
            }

            return suma/studentMarks.size();
        }
        return 0.0;
    }

    public int countAbsence(){
        int counter = 0;
        if(attendancesRekord.isEmpty()) return counter;

        for(Attendance o: attendancesRekord.values()){
            if(o.getTypeAttendance().equals(AttendanceType.NIEOBECNY)) counter++;
        }

        return  counter;
    }


}
