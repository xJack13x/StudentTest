import com.company.Dziennik;
import org.junit.*;

import static junit.framework.TestCase.assertEquals;


public class DziennikTest {

    @Test
    public void addStudentTest(){
        Dziennik.dodajStudenta(1, "Jan", "Kowalski");
        assertEquals(1, Dziennik.listaStudentow().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeSurnameStudentTooShort(){
        String nazwisko = "Ha";
        Dziennik.zmienNazwiskoStudenta(1, nazwisko);
    }

    @Test
    public void zmienImieStudenta(){
        String name = "Nowak";
        Dziennik.zmienImieStudenta(1, name);
    }

}