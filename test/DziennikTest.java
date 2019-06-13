import com.company.*;
import org.junit.*;

import java.util.Date;
import java.util.Map;
import java.util.NoSuchElementException;

import static junit.framework.TestCase.assertEquals;


public class DziennikTest {

    static int [] id = { -1, 1, 2, 3, 4};
    static double  [] marks = { -2, 1, 2, 3, 4.5};
    static String [] subjects = {"Matematyka", "Fizyka", "Chemia"};
    double delta = 0.0;

    @Test
    public void addStudentTest(){
        Dziennik.addStudent(1, "Jan", "Kowalski");
        assertEquals(1, Dziennik.listStudents().size());
    }

    @Test(expected=IllegalArgumentException.class)
    public void addStudentNotBeId(){
        Dziennik.addStudent(id[1], "Kowalski","Jan");
    }

    @Test(expected = IllegalArgumentException.class)
    public void replaceSurnameStudent(){
        String surname = "Ha";
        Dziennik.replaceSurnameStudent(1, surname);
    }

    @Test
    public void replaceNameStudent(){
        String name = "Nowak";
        Dziennik.replaceNameStudent(1, name);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeStudentNotId(){
        Integer id = null;
        Dziennik.removeStudent(id);
    }

    @Test(expected = NoSuchElementException.class)
    public void remoteStudentNotStudent(){
        Integer id = 35;
        Dziennik.removeStudent(id);
    }

    @Test
    public void removeStudent(){
        int students = Dziennik.listStudents().size();
        Integer id = 1;
        Dziennik.removeStudent(id);
        Assert.assertEquals(--students, Dziennik.listStudents().size());
    }

    @Test
    public void chceckAttendacne(){
        Student s = Dziennik.listStudents().get(id[1]);
        int startAttendance = s.getAttendancesRekord().size();
        Dziennik.chceckAttendacne(id[1], new Date(), AttendanceType.OBECNY);

        Assert.assertEquals(++startAttendance, s.getAttendancesRekord().size());
    }

    @Test(expected = NoSuchElementException.class)
    public void chceckAttendacneNotExist(){
        Dziennik.chceckAttendacne(4, new Date(), AttendanceType.OBECNY);
    }

    @Test
    public void countAttendanceNotBe(){
        Assert.assertEquals(0, Dziennik.listStudents().get(1).countAbsence());
    }

    @Test
    public void countAttendance(){
        Dziennik.listStudents().put(id[4], new Student(id[4], "Kozłowski"," Michał"));
        Dziennik.chceckAttendacne(id[4], new Date(), AttendanceType.NIEOBECNY);

        Assert.assertEquals(1, Dziennik.listStudents().get(id[4]).countAbsence());
        Dziennik.listStudents().remove(id[4]);
    }

    @Test
    public void addMarkIntegerTest(){
        Dziennik.addMark(id[1], marks[3], Subject.Matematyka.nameSubject);
        Map<Integer, Student> studenci = Dziennik.listStudents();

        Assert.assertEquals(3, studenci.get(id[1]).getStudentMarks().values().iterator().next().getValue(), delta);
    }

    @Test
    public void addMarkDoubleTest(){
        Dziennik.addMark(id[1], marks[4], Subject.Matematyka.nameSubject);
        Map<Integer, Student> studenci = Dziennik.listStudents();

        Assert.assertEquals(4.5, studenci.get(id[1]).getStudentMarks().values().iterator().next().getValue(), delta);
    }

    @Test(expected = NoSuchElementException.class)
    public void addMarkNotBeSubject(){
        Dziennik.addMark(id[2], 3, subjects[2]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addBedMark(){
        Dziennik.addMark(id[1], 1, subjects[1]);
    }

    @Test
    public void calculateAverageStudent(){
        Student s= new Student();
        Mark m1 = new Mark(1, Subject.Fizyka, 3.5);
        Mark m2 = new Mark(2, Subject.Matematyka, 3.5);
        s.getStudentMarks().put(m1.getIdMark(), m1);

        Assert.assertEquals(s.calculateAverage(), 3.5, delta);
    }

    @Test(expected = RuntimeException.class)
    public void calculateAverageStudentsNotBeMarks(){
        Assert.assertEquals(Double.NaN, Dziennik.calculateAverageStudents(), delta);
    }

    @Test
    public void editMark(){
        Student s = Dziennik.listStudents().get(2);
        s.getStudentMarks().put(1, new Mark(1, Subject.Matematyka, 2));
        Mark start = s.getStudentMarks().get(1);
        Dziennik.editMark(2, 1, 3.5);
        Assert.assertEquals(start, Dziennik.listStudents().get(2).getStudentMarks().get(1));
    }

    @Test
    public void calculateAverageStudents(){
        Dziennik.listStudents();
        Dziennik.addStudent(3, "Karol", " Tomasz");
        Dziennik.addMark(3, 3.5, Subject.Matematyka.nameSubject);

        Assert.assertEquals(Dziennik.calculateAverageStudents(), 3.5, delta);
    }

    @Test(expected = NoSuchElementException.class)
    public void editMarkNotBeStudent(){
        Student s = Dziennik.listStudents().get(1);
        s.getStudentMarks().put(1, new Mark(1, Subject.Matematyka, 2));
        Mark start = s.getStudentMarks().get(1);
        Dziennik.editMark(2, 1, 3.5);
    }


    @Test(expected = NoSuchElementException.class)
    public void editMarkNotBeMark(){
        Student s = Dziennik.listStudents().get(id[2]);
        Dziennik.editMark(id[2], 2, 3.5);
    }

    @Test(expected = RuntimeException.class)
    public void calculateAverageStudentNotBeMark(){
        Dziennik.listStudents().forEach((k, v) -> v.getStudentMarks().clear());

        Dziennik.calculateAverageStudents();
    }
}