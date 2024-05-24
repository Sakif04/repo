package HotelManagement;

import java.util.*;

public abstract class Room {
    private int roomNumber;
    protected ArrayList<Guest> guests = new ArrayList<Guest>();
    private boolean isOccupied;

    Room() {
    }

    Room(int rNum) {
        this.roomNumber = rNum;
    }

    public void setroomNumber(int rNum) {
        this.roomNumber = rNum;
    }

    public int getroomNumber() {
        return roomNumber;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void checkIn(Guest guest) {
        if (isOccupied() == false) {
            guests.add(guest);
            setOccupied(true);
        } else {
            System.out.println("Room is Already Occupied.");
        }
    }

    public void checkOut(String gName) {

        if (isOccupied() == true) {
            for (int i = 0; i < guests.size(); i++) {
                if (guests.get(i).getgName().compareTo(gName) == 0) {
                    guests.remove(i);
                    setOccupied(false);
                }
            }
        }
    }

    public abstract double calculateCost(int stayingDays);

    public abstract void display();

}