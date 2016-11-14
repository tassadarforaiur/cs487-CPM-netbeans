package javaapplication1;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
            accObj.put("user", a.getUser());
            accObj.put("user", a.getPass());
            accObj.put("email", a.getEmail());
            accObj.put("name", a.getName());
            accObj.put("phone", a.getPhone());
            accObj.put("address", a.getAddress());
            accObj.put("googleID", a.getGoogleID());
            accObj.put("date", a.getAccountOpening().toString());

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
            JSONObject accObj = new JSONObject();
            accObj.put("title", ev.getTitle());
            accObj.put("description", ev.getDescription());
            accObj.put("start", ev.getStart().toString());
            accObj.put("end", ev.getEnd()).toString();
            accObj.put("location", ev.getLocation());

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
            start = evObj.getString("start");
            end = evObj.getString("end");
            location = evObj.getString("location");
            description = evObj.getString("description");

            tempEv = new Event(title, description,/*start, end,*/ location);

            return tempEv;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Account deserializeJSONAccount(String JSData) {
        Account tempAcc;

        try {
            JSONObject accObj = new JSONObject(JSData);

            user = accObj.getString("user");
            pass = accObj.getString("pass");
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
