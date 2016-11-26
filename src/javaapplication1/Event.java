 package javaapplication1;

import java.util.ArrayList;
import java.util.Calendar;


public class Event{

    private Calendar start= Calendar.getInstance();
    private Calendar end = Calendar.getInstance();
    private String title, status="inactive", location, description, hostID, eventID, imageFN, registerLink;

    
    private ArrayList<String> schedule = new ArrayList<>(); 
    //private ArrayList<Account> attendees = new ArrayList<>();
    //private ArrayList<Event> moderators = new ArrayList<>();
    //private ArrayList<Account> hosts = new ArrayList<>();
    

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

    public void appendSchedule(String a){
        schedule.add(a);
    }
    
    public String toString(){
        return ""+title+"\n"+description+"\n"+location+"\n";
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
        return this.getLocation();
    }

    public Calendar getStart(){
        return this.start;
    }

    public Calendar getEnd(){
        return this.end;
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
    
    public ArrayList getSchedule(){
        return this.schedule;
    }

    public String getRegisterLink() {
        return registerLink;
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

    public void setEnd(int eD, int eM, int eY){
        end.set(eY, eM, eD);
    }

    public void setEventID(String eID){
        eventID=eID;
    }

}
