package javaapplication1;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Account implements Serializable{

    private String name="";
    private String email="";
    private String phone="";
    private String address="";
    private Calendar accountOpening = Calendar.getInstance();
    private ArrayList<Event> eventList = new ArrayList<>();
    
    private DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss zzz yyyy");

    private String googleID="";

    public Account(String n, String e, String ph, String a) {
        name = n;
        email = e;
        phone = ph;
        address = a;
    }
    
    public Account(String gID) {
        googleID = gID;
    }

    public void setName(String n){
        this.name = n;
    }

    public void setEmail(String e){
        this.email = e;
    }

    public void setPhone(String ph){
        this.phone = ph;
    }

    public void setAddress(String a){
        this.address = a;
    }

    public void setGoogleID(String googleID) {
        this.googleID = googleID;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPhone(){
        return this.phone;
    }

    public String getAddress(){
        return this.address;
    }

    public String getGoogleID() {
        return googleID;
    }

    public void setAccountOpening(Date d){
        accountOpening.setTime(d);
    }

    public Calendar getAccountOpening(){
        return this.accountOpening;
    }
    
    public String getFormattedOpening(){
            return df.format(this.accountOpening.getTime());
    }
    
    public ArrayList getEventList(){
        return this.eventList;
    }

    public String toString() {
        return name + "\n" + email +" "+ phone + "\n" + address;
    }

}
