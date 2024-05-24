package HotelManagement;
import java.io.*;
import java.util.*;


public class Hotel{
    String home = System.getProperty("user.home");
    String filePath = home + File.separator+ "Hotel Information.txt";
    File file = new File(filePath);
    Scanner inp = new Scanner(System.in);
    private ArrayList<Room> room = new ArrayList<Room>();
    private ArrayList<Guest> guest = new ArrayList<Guest>();
    private ArrayList<Staff> staff = new ArrayList<Staff>();
    private Restaurant restaura = new Restaurant();

    public Hotel() {
        room.add(new StandardRoom(101, 4000));
        room.add(new StandardRoom(102, 4000));
        room.add(new StandardRoom(103, 4000));
        room.add(new StandardRoom(104, 4000));
        room.add(new StandardRoom(105, 4000));
        room.add(new DeluxeRoom(301, 10000));
        room.add(new DeluxeRoom(302, 10000));
        room.add(new DeluxeRoom(303, 10000));
        room.add(new SuiteRoom(401, 15000));
        room.add(new SuiteRoom(402, 15000));
        
    }

    public void addCheckInGuest() {
        boolean rExists = false;
        try {
            System.out.println("Enter Guest Name: ");
            String gName = inp.nextLine();
            System.out.println("Enter age: ");
            int ag = inp.nextInt();
            System.out.println("Days of Stay: ");
            int stDays = inp.nextInt();
            guest.add(new Guest(gName, ag, stDays));
            writeToFile();
            System.out.println(gName + " Guest Added.");
            System.out.println("Options for check in:");
            System.out.println("1.Standard Room (101...105)");
            System.out.println("2.Deluxe Room (301....303)");
            System.out.println("3.Suite Room (401..402)");
            System.out.println("Enter Room No:");
            int rNo = inp.nextInt();
            for (Room r : room) {
                if (rNo == r.getroomNumber()) {
                    rExists = true;
                    r.checkIn(new Guest(gName, ag, stDays));
                    System.out.println(gName + " Guest Checked In.");
                    System.out.println("Cost of Stay: " + r.calculateCost(stDays));
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Input Type is Wrong!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        if (!rExists) {
            System.out.println("No Such Room Found!!");
        }
    }

    public void CheckOut() {
        boolean rExists = false;
        try {
            System.out.println("Enter Room No: ");
            int rNo = inp.nextInt();
            inp.nextLine();  // Consume the newline character
            System.out.println("Enter Guest Name: ");
            String gN = inp.nextLine();
            for (int i = 0; i < guest.size(); i++) {
                if (guest.get(i).getName().equals(gN)) {
                    guest.remove(i);
                    System.out.println(gN + " Guest Moved Out.");
                    break;
                }
            }
            for (Room r : room) {
                if (rNo == r.getroomNumber()) {
                    rExists = true;
                    r.checkOut(gN);
                    System.out.println(gN + " Guest Checked Out of room " + r.getroomNumber());
                    writeToFile();
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Input Type is Wrong!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        if (!rExists) {
            System.out.println("No such Room Found");
        }
    }

    public void displayAllGuests() {
        try {
            writeToFile();
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.startsWith("Guest Information:")) {
                    System.out.println(line);
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found. " + e.getMessage());
        } catch(IOException c){
            System.out.println("Error writing to file: "+c.getMessage());
        }
    }

    public void addStaff() {
        try {
            System.out.println("Enter Staff Name: ");
            inp.nextLine();  // Consume the leftover newline character
            String sName = inp.nextLine();
            System.out.println("Enter age: ");
            int ag = inp.nextInt();
            System.out.println("Enter Staff Role: ");
            inp.nextLine();  // Consume the leftover newline character
            String sRole = inp.nextLine();
            System.out.println("Enter Salary: ");
            double sal = inp.nextDouble();
            staff.add(new Staff(sName, ag, sRole, sal));
            System.out.println(sName + " added to Hotel.");
            writeToFile();
        } catch (InputMismatchException e) {
            System.out.println("Input Type is Wrong!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public void removeStaff() {
        boolean stExists = false;
        try {
            System.out.println("Enter Staff name: ");
            inp.nextLine();  // Consume the leftover newline character
            String Na = inp.nextLine();
            for (int i = 0; i < staff.size(); i++) {
                if (staff.get(i).getName().equals(Na)) {
                    stExists = true;
                    staff.remove(i);
                    System.out.println(Na + " removed.");
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Input Type is Wrong!");
        } 
        if (!stExists) {
            System.out.println("No Such Staff in the hotel.");
        }
    }

    public void displayAllStaff() {
        try {
            writeToFile();
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.startsWith("Staff Information:")) {
                    System.out.println(line);
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found. " + e.getMessage());
        } catch(IOException c){
            System.out.println("Error writing to File: "+ c.getMessage());
        }
    }

    public void displayRestaurantMenu() {
        restaura.displayMenu();
    }

    public void orderRestaurantFood() {
        displayRestaurantMenu();
        try {
            System.out.println("Enter your choice of menu: ");
            int chM = inp.nextInt();
            restaura.placeOrder(chM);
            System.out.println("Purchased: "+restaura.getMenu().get(chM-1));
        } catch (InputMismatchException e) {
            System.out.println("Input Type is Wrong!");
        } 
    }

    public void viewRestaurantPurchaseBill() {
        System.out.println("Enter your purchased set: ");
        int chM = inp.nextInt();
        restaura.viewBill(chM);
    }

    public void displayAvailableRooms() {
        for (Room r : room) {
            if (!r.isOccupied())
                r.display();
        }
    }

    private void writeToFile() throws IOException {
        try(
        PrintWriter writer = new PrintWriter(file);){
        for (Guest g : guest) {
            writer.println("Guest Information: " + g.displayGuests());
        }
        for (Staff s : staff) {
            writer.println("Staff Information: " + s.displayStaff());
        }
    } catch(FileNotFoundException r){
        System.out.println("Error: "+r.getMessage());
    } 
       
    }

    /*private void loadFromFile() {
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.startsWith("Guest: ")) {
                    String guestInfo = line.substring(7);  // Remove the "Guest: " prefix
                    Guest g = Guest.fromString(guestInfo);
                    guest.add(g);
                } else if (line.startsWith("Staff: ")) {
                    String staffInfo = line.substring(7);  // Remove the "Staff: " prefix
                    Staff s = Staff.fromString(staffInfo);
                    staff.add(s);
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found, starting with an empty hotel.");
        }*/
    

}


    

