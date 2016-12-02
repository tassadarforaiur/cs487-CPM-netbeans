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
        attendees.clear();
        schedule.clear();
        attendees.add("123");
        attendees.add("456");
        attendees.add("789");
        schedule.add("skiing");
        schedule.add("dancing");
        jC = new JSONConverter();
        a = new Account("Andy Roedger", "aroedg@iit.edu", "1-(212)-664-7665", "65 Alberta Ave");
        a.setGoogleID("thisID123");
        //a.setAttendeesString("thisID123,123,456");
        e = new Event();
        e.setTitle("Chicago Blockchain Developers Conference");
        e.setDescription("Coolest Event");
        e.setLocation("here");
        e.setHostID("some userid");
        e.setStart(11, 11, 2016);
        e.setEnd(12, 11, 2016);
        e.setAttendees(attendees);
        e.setAttendeesString("123,456,789");
        e.setImageFN("devbharel/cbdc.jpg");
        e.setRegisterLink("something.com");
        e.setSchedule(schedule);
        e.setScheduleString("skiing,dancing");
        
        System.out.println("@Before - setUp");
    }

    @Test
    public void testToJSONAccount() {
        String expected = "{\"googleID\":\"thisID123\",\"date\":\""+a.getFormattedOpening()+"\",\"address\":\"65 Alberta Ave\",\"phone\":\"1-(212)-664-7665\",\"name\":\"Andy Roedger\",\"email\":\"aroedg@iit.edu\"}";
        assertEquals(expected, jC.toJSONAccount(a));
        System.out.println("@Test - testToJSONAccount");
    }
    
    @Test
    public void testToJSONGAccount() {
        String expected = "{\"googleID\":\"thisID123\"}";
        assertEquals(expected, jC.toJSONGAccount(a));
        System.out.println("@Test - testToJSONGAccount");
    }
    
    @Test
    public void testToJSONEventTitle() {
        String expected = "{\"eventName\":\"Cool Event\"}";
        assertEquals(expected, jC.toJSONEventTitle("Cool Event"));
        System.out.println("@Test - testToJSONEventTitle");
    }
    
    @Test
    public void testToJSONEvent() {
        String expected = "{\"image\":\"devbharel/cbdc.jpg\",\"register_link\":\"something.com\",\"attendees\":\"123,456,789\",\"organizer\":\"some userid\",\"start\":\""+e.getFormattedStart()+"\",\"eventName\":\"Chicago Blockchain Developers Conference\",\"description\":\"Coolest Event\",\"end\":\""+e.getFormattedEnd()+"\",\"location\":\"here\",\"events\":\"skiing,dancing\"}";
        assertEquals(expected, jC.toJSONEvent(e));
        System.out.println("@Test - testToJSONEvent");
    }
    
    @Test
    public void testDeserializeJSONAccount() {
        String expected = "Andy Roedger\naroedg@iit.edu 1-(212)-664-7665\n65 Alberta Ave";
        assertEquals(expected, (jC.deserializeJSONAccount(jC.toJSONAccount(a))).toString());
        System.out.println("@Test - testDeserializeJSONAccount");
    }
    
    @Test
    public void testDeserializeJSONEvent() {
        String expected = "TEDTalks\nEducational\nIIT MTCC";
        assertEquals(expected, (jC.deserializeJSONEvent(jC.toJSONEvent(e))).toString());
        System.out.println("@Test - testDeserializeJSONEvent");
    }

}
