package javaapplication1;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class JUnitJSONConverter {

    private Account a;
    private JSONConverter jC;

    @Before
    public void setUp()	{
        jC = new JSONConverter();
        a = new Account("aroedg", "RoegerBros123", "Andy Roedger", "aroedg@iit.edu", "1-(212)-664-7665", "65 Alberta Ave");
        System.out.println("@Before - setUp");
    }

    @Test
    public void testToJSONAccount() {
        String expected = "{\"googleID\":\"\",\"date\":\""+a.getFormattedOpening()+"\",\"address\":\"65 Alberta Ave\",\"phone\":\"1-(212)-664-7665\",\"name\":\"Andy Roedger\",\"user\":\"RoegerBros123\",\"email\":\"aroedg@iit.edu\"}";
        assertEquals(expected, jC.toJSONAccount(a));
        System.out.println("@Test - testToJSONAccount");
    }

}
