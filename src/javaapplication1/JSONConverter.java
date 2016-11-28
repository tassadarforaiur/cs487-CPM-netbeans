package javaapplication1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.json.*;

public class JSONConverter {

    private String title, start, end, location, description;

    private String user;
    private String pass;
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

    public static String toJSONEvent(Event ev) {

        try {
            Gson gson = new GsonBuilder().create();
            JsonArray schedule = gson.toJsonTree(ev.getSchedule()).getAsJsonArray();
            JsonArray attendees = gson.toJsonTree(ev.getSchedule()).getAsJsonArray();
            
            
            JSONObject accObj = new JSONObject();
                       
            accObj.put("title", ev.getTitle());
            accObj.put("description", ev.getDescription());
            accObj.put("start", ev.getStart().toString());
            accObj.put("end", ev.getEnd()).toString();
            accObj.put("location", ev.getLocation());
            accObj.put("register_link", ev.getRegisterLink());
            accObj.put("image", ev.getImageFN());
            accObj.put("events", schedule);
            accObj.put("attendees", attendees);

            return accObj.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Event deserializeJSONEvent(String JSData) {
        Event tempEv;

        try {
            JSONObject evObj = new JSONObject(JSData);

            title = evObj.getString("title");
            location = evObj.getString("location");
            description = evObj.getString("description");
            
            Date start = df.parse(evObj.getString("start"));
            Date end = df.parse(evObj.getString("end"));

            tempEv = new Event(title, description, location);
            tempEv.setStart(start);
            tempEv.setEnd(end);

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

            tempAcc = new Account(user, pass, name, email, phone, address);

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
