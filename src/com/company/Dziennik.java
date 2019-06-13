package com.company;

import java.util.*;

public class Dziennik {

    private static Map<Integer, Student> students = new HashMap<>();

    public static void addStudent(Integer id, String name, String surname) throws IllegalArgumentException{
        if(id == null )
            id = generateIdentyfikator(students);

        if(students.containsKey(id)){
            throw new IllegalArgumentException("Student o takim identyfikatorze już istnieje");
        } else {
            students.put (id, new Student(id, name, surname));
        }
    }

    public static Map<Integer, Student> listStudents() {
        return students;
    }

    public static Integer generateIdentyfikator(Map mapa) throws IllegalArgumentException{
        if(mapa != null){
            return mapa.size() + 1;
        }
        throw new IllegalArgumentException("Nie można wygenerować identyfikatora");
    }

    public static void removeStudent(Integer id){
        if(id == null) {
            throw new IllegalArgumentException();
        }
        Student s = students.get(id);
        if(s == null){
            throw new NoSuchElementException("Brak studenta o podanym identyfikatorze.");
        } else {
            students.remove(id);
        }
    }

    public static void replaceNameStudent(Integer idStudent, String name) throws IllegalArgumentException{
        if(!students.containsKey(idStudent) || name.length() < 3) throw new IllegalArgumentException("Niepoprawne dane studenta");

        students.get(idStudent).setName(name);
    }

    public static void replaceSurnameStudent(Integer idStudent, String surname) throws IllegalArgumentException{
        if(!students.containsKey(idStudent) || surname.length() < 3) throw new IllegalArgumentException("Niepoprawne dane studenta");

        students.get(idStudent).setSurname(surname);
    }

    public static void chceckAttendacne(Integer idStudent, Date date, AttendanceType attendance){
        Student s = findStudent(idStudent);

        if(date == null || attendance == null){
            throw new IllegalArgumentException("Niepoprawne dane obecności");
        }
        s.getAttendancesRekord().put(date, new Attendance(attendance, date));
    }

    public static Student findStudent(Integer idstudent){
        Student s = students.get(idstudent);
        if( s == null){
            throw new NoSuchElementException("Brak studenta o podanym identyfikatorze.");
        }

        return s;
    }

    public static void addMark(Integer idStudent, double mark, String subject) throws NoSuchElementException {
        if(!students.containsKey(idStudent)) throw new NoSuchElementException("Brak takiego studenta!");
        if(Subject.getByName(subject) == null) throw new NoSuchElementException("Brak takiego przedmiotu!");
        if(!ifMarkTrue(mark) )throw new IllegalArgumentException("Niepoprawna wartosc oceny");
        else {
            Map<Integer, Mark> studentMarks = students.get(idStudent).getStudentMarks();
            Mark newMark = new Mark(generateIdentyfikator(studentMarks), Subject.getByName(subject), mark);
            studentMarks.put(idStudent, newMark);
            students.get(idStudent).setStudentMarks(studentMarks);
        }
    }

    public static void editMark(Integer idStudent, Integer idMark, double value) throws IllegalArgumentException {
        if (idStudent == null || idMark == null) {
            throw new IllegalArgumentException("Nieprawidłowy identyfikator studenta lub/i oceny!");
        }

        Student s = findStudent(idStudent);
        Mark m = s.getStudentMarks() != null ? s.getStudentMarks().get(idMark) : null;

        if (s != null && m != null && ifMarkTrue(value)) {
            students.get(idStudent).getStudentMarks().get(idMark).setValue(value);
        } else {
            throw new NoSuchElementException("Nie udało się zmienić oceny.");
        }
    }

    public static boolean ifMarkTrue(double mark){
        List<Double> trueMark = new ArrayList<>();
        trueMark.add(2.0);
        trueMark.add(3.0);
        trueMark.add(3.5);
        trueMark.add(4.0);
        trueMark.add(4.5);
        trueMark.add(5.0);

        return trueMark.contains(mark);
    }

    public static Double calculateAverageStudents() throws RuntimeException{
        if(students == null || students.isEmpty()){
            return 0.0;
        }

        Double countAverage = 0.0;
        for(Student s : students.values()){
            countAverage += s.calculateAverage();
        }

        Double average =  countAverage/students.size();
        if(average.isNaN()) throw new RuntimeException("Nie można policzyć średniej - studenci nie mają ocen");
        return average;

    }






}
