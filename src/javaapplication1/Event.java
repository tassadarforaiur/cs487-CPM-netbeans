 package javaapplication1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Event{

    private Calendar start= Calendar.getInstance();
    private Calendar end = Calendar.getInstance();
    private String title, status="inactive", location, description, hostID, eventID, imageFN, registerLink,attendeesString,scheduleString;
    private DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss zzz yyyy");
    private ArrayList<String> schedule = new ArrayList<>(); 
    private ArrayList<String> attendees = new ArrayList<>();    

    public Event(String t, String d, String l){
        title = "TEDTalks";
        description = "Educational";
        location="IIT MTCC";
        hostID="Teddy";
        eventID="eTED";
    }

    public Event(){
        title = "TEDTalks";
        description = "Educational";
        start.getInstance();
        start.add(Calendar.DATE, -3);
        end.getInstance();
        end.add(Calendar.DATE, 12);
        location="IIT MTCC";
        hostID="Teddy";
        eventID="eTED";
    }
    
    public Event(String hID){
        hostID=hID;
    }

    public Event(String tt, String d, int sY, int sM, int sD, int eY, int eM, int eD, String l,String hID, String eID){
        title = tt;
        description = d;
        start.set(sY, sM, sD);
        end.set(eY, eM, eD);
        location=l;
        hostID=hID;
        eventID=eID;
    }
    
    public Event(String tt, String d, int sY, int sM, int sD, int eY, int eM, int eD, String l, String hID){
        title = tt;
        description = d;
        start.set(sY, sM, sD);
        end.set(eY, eM, eD);
        location=l;
        hostID=hID;
    }

    public void appendSchedule(String a){
        schedule.add(a);
    }
    
    public void appendAttendees(Account a){
        attendees.add(a.getGoogleID());
    }
    
    public void appendAttendees(String aGID){
        attendees.add(aGID);
    }
    
    public String toString(){
        return ""+title+"\n"+description+"\n"+location;
    }

    //Takes the difference in Milliseconds(start-current)
    public void beginEvent(Calendar cal) {
        if(cal.compareTo(start)>0){
            status="active";
        }else{
            status="inactive";
        }
    }

    //Takes the difference in Milliseconds(current-end)
    public void endEvent(Calendar cal) {
        if(end.compareTo(cal)<0){
            status="inactive";
        }else{
            status="active";
        }
    }

    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    public String getLocation(){
        return this.location;
    }

    public Calendar getStart(){
        return this.start;
    }
    
    public String getFormattedStart(){
            return df.format(this.start.getTime());
    }

    public Calendar getEnd(){
        return this.end;
    }
    
    public String getFormattedEnd(){
            return df.format(this.end.getTime());
    }

    public String getStatus(){
        return this.status;
    }

    public String getHostID(){
        return this.hostID;
    }

    public String getEventID(){
        return this.eventID;
    }
    
    public String getImageFN(){
        return this.imageFN;
    }
    
    public ArrayList<String> getSchedule(){
        return this.schedule;
    }

    public String getRegisterLink() {
        return registerLink;
    }
    
    public ArrayList<String> getAttendees() {
        return attendees;
    }
    
    public String getAttendeesString(){
        return attendeesString;
    }
    
    public String getScheduleString(){
        return scheduleString;
    }
    
    public void setAttendeesString(String aS){
        this.attendeesString= aS;
    }
    
    public void setScheduleString(String sS){
        this.scheduleString = sS;
    }

    public void setHostID(String hID){
        this.hostID=hID;
    }
    
    public void setAttendees(ArrayList<String> a) {
        this.attendees = a;
    }

    public void setRegisterLink(String registerLink) {
        this.registerLink = registerLink;
    }    
    
    public void setSchedule(ArrayList<String> s){
        schedule=s;
    }
    
    public void setImageFN(String i){
        imageFN=i;
    }
    
    public void setTitle(String t){
        title=t;
    }

    public void setDescription(String d){
        description=d;
    }

    public void setLocation(String l){
        location=l;
    }

    public void setStart(int sD, int sM, int sY){
        start.set(sY, sM, sD);
    }
    
    public void setStart(Date s){
        start.setTime(s);
    }

    public void setEnd(int eD, int eM, int eY){
        end.set(eY, eM, eD);
    }
    
    public void setEnd(Date e){
        end.setTime(e);
    }

    public void setEventID(String eID){
        eventID=eID;
    }

}
