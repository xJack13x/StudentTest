package com.company;

import java.util.*;

public class Dziennik {

    private static Map<Integer, Student> studenci = new HashMap<>();

    public static void dodajStudenta(Integer id, String imie, String nazwisko) throws IllegalArgumentException{
        if(id == null )
            id = wygenerujIdentyfikator(studenci);

        if(studenci.containsKey(id)){
            throw new IllegalArgumentException("Student o takim identyfikatorze już istnieje");
        } else {
            studenci.put (id, new Student(id, imie, nazwisko));
        }
    }

    public static Map<Integer, Student> listaStudentow() {
        return studenci;
    }

    public static Integer wygenerujIdentyfikator(Map mapa) throws IllegalArgumentException{
        if(mapa != null){
            return mapa.size() + 1;
        }
        throw new IllegalArgumentException("Nie można wygenerować identyfikatora");
    }

    public static void usunStudenta(Integer id){
        if(id == null) {
            throw new IllegalArgumentException();
        }
        Student s = studenci.get(id);
        if(s == null){
            throw new NoSuchElementException("Brak studenta o podanym identyfikatorze.");
        } else {
            studenci.remove(id);
        }
    }

    public static void zmienImieStudenta(Integer idStudent, String name) throws IllegalArgumentException{
        if(!studenci.containsKey(idStudent) || name.length() < 3) throw new IllegalArgumentException("Niepoprawne dane studenta");

        studenci.get(idStudent).setName(name);
    }

    public static void zmienNazwiskoStudenta(Integer idStudent, String surname) throws IllegalArgumentException{
        if(!studenci.containsKey(idStudent) || surname.length() < 3) throw new IllegalArgumentException("Niepoprawne dane studenta");

        studenci.get(idStudent).setSurname(surname);
    }

    public static void sprawdzObecnosc(Integer idStudent, Date date, ObecnoscType obecnosc){
        Student s = znajdzStudenta(idStudent);

        if(date == null || obecnosc == null){
            throw new IllegalArgumentException("Niepoprawne dane obecności");
        }
        s.getEwidencjaObecnosci().put(date, new Obecnosc(obecnosc, date));
    }

    public static Student znajdzStudenta(Integer idstudent){
        Student s = studenci.get(idstudent);
        if( s == null){
            throw new NoSuchElementException("Brak studenta o podanym identyfikatorze.");
        }

        return s;
    }

    public static void addGrade(Integer idStudent, double ocena, String przedmiot) throws NoSuchElementException {
        if(!studenci.containsKey(idStudent)) throw new NoSuchElementException("Brak takiego studenta!");
        if(Przedmiot.getByName(przedmiot) == null) throw new NoSuchElementException("Brak takiego przedmiotu!");
        if(!czyOcenaPrawidlowa(ocena) )throw new IllegalArgumentException("Niepoprawna wartosc oceny");
        else {
            Map<Integer, Ocena> ocenyStudenta = studenci.get(idStudent).getOcenyStudenta();
            Ocena nowaOcena = new Ocena(wygenerujIdentyfikator(ocenyStudenta), Przedmiot.getByName(przedmiot), ocena);
            ocenyStudenta.put(idStudent, nowaOcena);
            studenci.get(idStudent).setOcenyStudenta(ocenyStudenta);

        }
    }

    public static boolean czyOcenaPrawidlowa(double ocena){
        List<Double> poprawneOceny = new ArrayList<>();
        poprawneOceny.add(2.0);
        poprawneOceny.add(3.0);
        poprawneOceny.add(3.5);
        poprawneOceny.add(4.0);
        poprawneOceny.add(4.5);
        poprawneOceny.add(5.0);

        return poprawneOceny.contains(ocena);

    }







}
