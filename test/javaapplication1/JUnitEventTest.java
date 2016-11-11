package javaapplication1;

import org.junit.Test;
import org.junit.Before;
import java.util.Calendar;
import static org.junit.Assert.assertEquals;

public class JUnitEventTest {

    private Event e;
    private Calendar cal;

    @Before
    public void setUp()	{
        e = new Event();
        cal = Calendar.getInstance();
        System.out.println("@Before - setUp");
        System.out.println(cal.getTime());
    }

    @Test
    public void testBeginEventT() {
        e.beginEvent(cal);
        String expected = "active";
        assertEquals(expected, e.getStatus());
        System.out.println("@Test - testBeginEvent: True Beginning");
    }

    @Test
    public void testBeginEventF() {
        cal.add(Calendar.DATE, -10);
        e.beginEvent(cal);
        System.out.println(cal.getTime());
        String expected = "inactive";
        assertEquals(expected, e.getStatus());
        System.out.println("@Test - testBeginEvent: False Beginning");
    }

    @Test
    public void testEndEventF() {
        e.endEvent(cal);
        String expected = "active";
        assertEquals(expected, e.getStatus());
        System.out.println("@Test - testEndEvent: False Ending");
    }

    @Test
    public void testEndEventT() {
        cal.add(Calendar.DATE, 13);
        e.endEvent(cal);
        String expected = "inactive";
        assertEquals(expected, e.getStatus());
        System.out.println("@Test - testEndEvent: True Ending");
    }
}
