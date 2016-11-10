package JUnit;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class JUnitSearchTest {

    private ArrayList<Event> eL = new ArrayList<>();
    private ArrayList<Event> eListExpected = new ArrayList<>();

    private Event eAM = new Event("AnimeMidwest", "Convention", 2017, 7, 4, 2017, 7, 6, "Rosemont", "someOne", "eAM");
    private Event eTED = new Event("TEDTalks", "Educational", 2016, 5, 3, 2016, 5, 4, "IIT MTCC", "Teddy", "eTED");
    private Event eH = new Event("Hackathon", "Competition", 2016, 11, 5, 2016, 11, 6, "IIT IdeaShop", "Saelee", "eH");
    private Search s;

    @Before
    public void setUp()	{
        s = new Search();

        eL.add(eAM);
        eL.add(eTED);
        eL.add(eH);
        System.out.println("@Before - setUp");
    }

    @Test
    public void testSearchID() {
        eListExpected.add(eH);
        eL = s.searchID(eL, "eH");

        assertEquals(eListExpected.get(0), eL.get(0));
        System.out.println("@Test - testSearchID");
    }
}
