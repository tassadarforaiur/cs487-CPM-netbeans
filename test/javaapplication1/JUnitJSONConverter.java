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
        attendees.add("123");
        attendees.add("456");
        attendees.add("789");
        schedule.add("skiing");
        schedule.add("dancing");
        jC = new JSONConverter();
        a = new Account("aroedg", "RoegerBros123", "Andy Roedger", "aroedg@iit.edu", "1-(212)-664-7665", "65 Alberta Ave");
        e = new Event();
        e.setTitle("Chicago Blockchain Developers Conference");
        e.setHostID("some userid");
        e.setStart(11, 22, 2016);
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
        assertEquals(expected, jC.deserializeJSONAccount("{ \n" +
            "    \"_id\" : \"5817afc252b1fa6364016fa8\", \n" +
            "    \"googleID\" : \"asdflkj123\", \n" +
            "    \"name\" : \"Dev Bharel\", \n" +
            "    \"email\" : \"devbharel@gmail.com\", \n" +
            "    \"conferences\" : [] \n" +
            "}").toString());
        System.out.println("@Test - testDeserializeJSONAccount");
    }
    
    @Test
    public void testDeserializeJSONEvent() {
        String expected = "{\"googleID\":\"\",\"date\":\""+a.getFormattedOpening()+"\",\"address\":\"65 Alberta Ave\",\"phone\":\"1-(212)-664-7665\",\"name\":\"Andy Roedger\",\"user\":\"RoegerBros123\",\"email\":\"aroedg@iit.edu\"}";
        assertEquals(expected, jC.deserializeJSONEvent("{ \n"+
            "    \"name\": \"Chicago Blockchain Developers Conference\", \n"+
            "    \"organizer\" : \"123\", \n"+
            "    \"address\" : \"1871 Merchandise Mart\", \n"+
            "    \"date\" : \"11-22-2016\", \n"+
            "    \"attendees\" : [], \n"+
            "    \"image\" : \"devbharel/cbdc.jpg\", \n"+
            "    \"register_link\" : \"something.com\", \n"+
            "    \"events\" : [ \n"+
                "    \"skiing\", \"dancing\", \"\" \n"+
            "    ] \n"  +
            "}").toString());
        System.out.println("@Test - testDeserializeJSONEvent");
    }

}
