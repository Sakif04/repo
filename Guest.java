package HotelManagement;

import java.util.Calendar;
import java.util.Date;

public class Guest extends Person{
    private Calendar CheckInDate,CheckOutDate;

    public Guest(){
        super();
        CheckInDate = Calendar.getInstance();
        CheckOutDate = Calendar.getInstance();
    }

    public Guest(String n, int a,int stayingDays){
        super(n,a);
        CheckInDate = Calendar.getInstance();
        CheckOutDate = Calendar.getInstance();
        CheckOutDate.add(Calendar.DATE,stayingDays);
    }

    public void setgName(String n){
        super.name = n;
    }

    public String getgName(){
        return super.name;
    }

    public void setAge(int a){
        super.age = a;
    }

    public int getgAge(){
        return super.age;
    }
    
    public void setCheckOutDate(int stayingDays){
        CheckOutDate.add(Calendar.DATE,stayingDays);
    }

    public Date getCheckInDate(){
        return CheckInDate.getTime();
    }

    public Date getCheckOutDate(){
        return CheckOutDate.getTime();
    }

   // public 
    public String displayGuests(){
       return "Guest Name: "+name+
                    "  Age:"+age+
                    "  Checked in on: "+getCheckInDate()+
                    "  Expected check out date: "+getCheckOutDate();
    }

}
