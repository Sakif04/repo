package HotelManagement;

public class StandardRoom extends Room{
    private double stdroomRate;

    public StandardRoom(){
       super();
    }

    public StandardRoom(int rNum,double stRoomRate){
        super(rNum);
        this.stdroomRate = stRoomRate;
    }

   /*  public  void checkIn(Guest guest){
        if(isOccupied()==false){
        guests.add(guest);
        setOccupied(true);
        } else{
            System.out.println("Room is Already Occupied.");
        }
    }*/

    /*public  void checkOut(String gName){
        if(isOccupied()==true){
        for(int i=0;i<guests.size();i++){
            if(guests.get(i).getgName().compareTo(gName)==0){
                guests.remove(i);
                setOccupied(false);
            }
        }
    }
    else{
        System.out.println("Room is not occupied by any guest.");
    }
    }*/

    public void display(){
        String oc = isOccupied() ? "Not Available" : "Available";
        System.out.println("Room Number: "+getroomNumber());
        System.out.println("Standard Room Rate: "+stdroomRate);
        System.out.println("Availablity Status: "+oc);
    }
     
    public double calculateCost(int stayDays){
        double c = stdroomRate*stayDays;
        return c;
    }
}