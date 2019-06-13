package com.company;

import java.util.Date;

public class Attendance {

    private AttendanceType typeAttendance;

    private Date data;

    public Attendance(AttendanceType typeAttendance, Date data){
        this.typeAttendance=typeAttendance;
        this.data=data;
    }

    public AttendanceType getTypeAttendance() {
        return typeAttendance;
    }

}
