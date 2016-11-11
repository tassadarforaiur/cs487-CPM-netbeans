package javaapplication1;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class JUnitAccountTest {

    private Account a;

    @Before
    public void setUp()	{
        a = new Account("aroedg", "RoegerBros123", "Andy Roedger", "aroedg@iit.edu", "1-(212)-664-7665", "65 Alberta Ave");
        System.out.println("@Before - setUp");
    }

    @Test
    public void testToString() {
        String expected = "Andy Roedger\naroedg@iit.edu 1-(212)-664-7665\n65 Alberta Ave";
        assertEquals(expected, a.toString());
        System.out.println("@Test - testToString");
    }

}
