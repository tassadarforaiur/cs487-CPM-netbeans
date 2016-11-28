package javaapplication1;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class JUnitJSONConverter {

    private Account a;
    private JSONConverter jC;
    private Event e;
    private ArrayList<String> attendees = new ArrayList<>();
    private ArrayList<String> schedule = new ArrayList<>();

    @Before
    public void setUp()	{
        a.setGoogleID("thisID123");
        attendees.add("123");
        attendees.add("456");
        attendees.add("789");
        schedule.add("skiing");
        schedule.add("dancing");
        jC = new JSONConverter();
        a = new Account("aroedg", "RoegerBros123", "Andy Roedger", "aroedg@iit.edu", "1-(212)-664-7665", "65 Alberta Ave");
        e = new Event();
        e.setTitle("Chicago Blockchain Developers Conference");
        e.setDescription("Coolest Event");
        e.setLocation("here");
        e.setHostID("some userid");
        e.setStart(11, 11, 2016);
        e.setEnd(12, 11, 2016);
        e.setAttendees(attendees);
        e.setImageFN("devbharel/cbdc.jpg");
        e.setRegisterLink("something.com");
        e.setSchedule(schedule);
        
        
        System.out.println("@Before - setUp");
    }

    @Test
    public void testToJSONAccount() {
        String expected = "{\"googleID\":\"\",\"date\":\""+a.getFormattedOpening()+"\",\"address\":\"65 Alberta Ave\",\"phone\":\"1-(212)-664-7665\",\"name\":\"Andy Roedger\",\"user\":\"RoegerBros123\",\"email\":\"aroedg@iit.edu\"}";
        assertEquals(expected, jC.toJSONAccount(a));
        System.out.println("@Test - testToJSONAccount");
    }
    
    @Test
    public void testToJSONGAccount() {
        String expected = "{\"googleID\":\"\",\"date\":\""+a.getFormattedOpening()+"\",\"address\":\"65 Alberta Ave\",\"phone\":\"1-(212)-664-7665\",\"name\":\"Andy Roedger\",\"user\":\"RoegerBros123\",\"email\":\"aroedg@iit.edu\"}";
        assertEquals(expected, jC.toJSONGAccount(a));
        System.out.println("@Test - testToJSONGAccount");
    }
    
    @Test
    public void testToJSONEvent() {
        String expected = "{\"googleID\":\"\",\"date\":\""+a.getFormattedOpening()+"\",\"address\":\"65 Alberta Ave\",\"phone\":\"1-(212)-664-7665\",\"name\":\"Andy Roedger\",\"user\":\"RoegerBros123\",\"email\":\"aroedg@iit.edu\"}";
        assertEquals(expected, jC.toJSONEvent(e));
        System.out.println("@Test - testToJSONEvent");
    }
    
    @Test
    public void testDeserializeJSONAccount() {
        String expected = "{\"googleID\":\"\",\"date\":\""+a.getFormattedOpening()+"\",\"address\":\"65 Alberta Ave\",\"phone\":\"1-(212)-664-7665\",\"name\":\"Andy Roedger\",\"user\":\"RoegerBros123\",\"email\":\"aroedg@iit.edu\"}";
        assertEquals(expected, (jC.deserializeJSONAccount(jC.toJSONAccount(a))).toString());
        System.out.println("@Test - testDeserializeJSONAccount");
    }
    
    @Test
    public void testDeserializeJSONEvent() {
        String expected = "{\"googleID\":\"\",\"date\":\""+a.getFormattedOpening()+"\",\"address\":\"65 Alberta Ave\",\"phone\":\"1-(212)-664-7665\",\"name\":\"Andy Roedger\",\"user\":\"RoegerBros123\",\"email\":\"aroedg@iit.edu\"}";
        assertEquals(expected, (jC.deserializeJSONEvent(jC.toJSONEvent(e))).toString());
        System.out.println("@Test - testDeserializeJSONEvent");
    }

}
