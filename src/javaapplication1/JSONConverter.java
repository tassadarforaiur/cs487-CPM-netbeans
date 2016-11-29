package javaapplication1;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.reflect.TypeToken;
import com.google.gson.*;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import java.lang.String;
import java.lang.reflect.Type;
//import org.codehaus.jackson.annotate.JsonSubTypes.Type;
//import javax.json.*;

public class JSONConverter {

    private String title, start, end, location, description;
    private String name;
    private String email;
    private String phone;
    private String address;
    private DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss zzz yyyy");

    public static String toJSONAccount(Account a) {

        try {
            JSONObject accObj = new JSONObject();
            accObj.put("email", a.getEmail());
            accObj.put("name", a.getName());
            accObj.put("phone", a.getPhone());
            accObj.put("address", a.getAddress());
            accObj.put("googleID", a.getGoogleID());
            accObj.put("date", a.getFormattedOpening());

            return accObj.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    public static String toJSONGAccount(Account a) {

        try {
            JSONObject accObj = new JSONObject();
            accObj.put("googleID", a.getGoogleID());

            return accObj.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    public static String toJSONGSAccount(String id) {

        try {
            JSONObject accObj = new JSONObject();
            accObj.put("googleID", id);

            return accObj.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    public static String toJSONEventTitle(String s){
        try {
            JSONObject evObj = new JSONObject();
            evObj.put("eventName", s);

            return evObj.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String toJSONEvent(Event ev) {

        try {
            Gson gson = new GsonBuilder().create();
            JsonArray schedule = gson.toJsonTree(ev.getSchedule()).getAsJsonArray();
            JsonArray attendees = gson.toJsonTree(ev.getAttendees()).getAsJsonArray();
            String scheduleJSON = gson.toJson(ev.getSchedule());
            String attendeesJSON = gson.toJson(ev.getAttendees());
            String attendeesString = ev.getAttendeesString();
            String scheduleString = ev.getScheduleString();
            
            JSONObject evObj = new JSONObject();
                       
            evObj.put("eventName", ev.getTitle());
            evObj.put("description", ev.getDescription());
            evObj.put("start", ev.getFormattedStart());
            evObj.put("end", ev.getFormattedEnd());
            evObj.put("location", ev.getLocation());
            evObj.put("register_link", ev.getRegisterLink());
            evObj.put("image", ev.getImageFN());
            evObj.put("events", scheduleString);
            evObj.put("attendees", attendeesString);
            evObj.put("organizer", ev.getHostID());
            //accObj.put("events", scheduleJSON);
            //accObj.put("attendees", attendeesJSON);

            return evObj.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Event deserializeJSONEvent(String JSData) {
        Event tempEv;

        try {
            JSONObject evObj = new JSONObject(JSData);

            title = evObj.getString("eventName");
            location = evObj.getString("location");
            description = evObj.getString("description");
            String schedule = evObj.getString("events");
            String attendees = evObj.getString("attendees");
            
            Date start = df.parse(evObj.getString("start"));
            Date end = df.parse(evObj.getString("end"));

            tempEv = new Event(title, description, location);
            tempEv.setStart(start);
            tempEv.setEnd(end);
            
            tempEv.setScheduleString(schedule);
            tempEv.setAttendeesString(attendees);
            
            /*Gson gson = new Gson();

            @SuppressWarnings("serial")
            Type collectionType = new TypeToken<ArrayList<String>>() {
            }.getType();
            ArrayList<String> tempEventAttendeeInfo = gson.fromJson(evObj.getString("attendees"), collectionType);  
            
            tempEv.setAttendees(tempEventAttendeeInfo);
            
            @SuppressWarnings("serial")
            Type collectionType2 = new TypeToken<ArrayList<String>>() {
            }.getType();
            ArrayList<String> tempEventScheduleInfo = gson.fromJson(evObj.getString("schedule"), collectionType2);  
            
            tempEv.setAttendees(tempEventScheduleInfo);*/
            

            return tempEv;

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(JSONConverter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Account deserializeJSONAccount(String JSData) {
        Account tempAcc;

        try {
            JSONObject accObj = new JSONObject(JSData);

            name = accObj.getString("name");
            email = accObj.getString("email");
            phone = accObj.getString("phone");
            address = accObj.getString("address");

            Date result = df.parse(accObj.getString("date"));

            tempAcc = new Account(name, email, phone, address);

            tempAcc.setGoogleID(accObj.getString("googleID"));
            
            tempAcc.setAccountOpening(result);

            return tempAcc;

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}