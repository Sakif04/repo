package HotelManagement;

import java.util.*;
import java.util.InputMismatchException;

 class logInException extends Exception{
    public logInException(String str){
        super(str);
    }
}

public class HotelManagementSystem {
    public static boolean logIn() throws logInException{
        Scanner inp = new Scanner(System.in);
        boolean loggedIn = false;
        boolean retry = false;

        do {
            try {
                System.out.println("\n\nLOG IN PAGE\n\n");
                System.out.println("Enter Username: ");
                String uName = inp.next();

                if (uName.equals("GHotel")) {
                    System.out.println("Enter Password: ");
                    String pass = inp.next();
                    if (pass.equals("GH")) {
                        System.out.println("\n\nAccess Granted!!");
                        loggedIn = true;
                    } else {
                        logInException es = new logInException("Password is Wrong!");
                        throw es;
                    }
                } else {
                    logInException ex = new logInException("User Name is wrong!");
                    throw  ex;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input type is wrong. Enter a string!!");
                inp.next(); // Clear the invalid input
            } catch (logInException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Access Denied!! Try Again.");
            } finally {
                if (!loggedIn) {
                    System.out.println("Do you want to try again? (press y or n)");
                    String response = inp.next();
                    retry = response.equalsIgnoreCase("y");
                }
            }
        } while (!loggedIn && retry);
        return loggedIn;
    }



    public static void main(String[] args) throws logInException{
        Scanner inp = new Scanner(System.in);
        Hotel h = new Hotel();
        if (logIn()) {
            while(true){
            System.out.println("\n\nHOTEL MANAGEMENT MENU\n\n");
            System.out.println("1.Show all Available Rooms");
            System.out.println("2.Manage Guests");
            System.out.println("3.Manage Staff");
            System.out.println("4.Restaurant Operations");
            System.out.println("5.Exit");
            System.out.println("Enter your choice:");
            int a = inp.nextInt();
            switch (a) {
                case 1:
                    h.displayAvailableRooms();
                    break;
                case 2:
                while(true){
                    System.out.println("\nMANAGE GUESTS\n");
                    System.out.println("1.Check-In Guests");
                    System.out.println("2.Check-Out Guests");
                    System.out.println("3.Display Guest List");
                    System.out.println("4.Back");
                    System.out.println("Enter your choice:");
                    int b = inp.nextInt();
                    switch (b) {
                        case 1:
                            h.addCheckInGuest();
                            break;
                        case 2:
                            h.CheckOut();
                            break;
                        case 3:
                            h.displayAllGuests();
                            break;
                        case 4:
                            break;
                        default:
                        System.out.println("Invalid Input!!");
                            break;
                    }
                    if(b==4)
                        break;
                    
                }
                break;
                case 3:
                while(true){
                    System.out.println("\nMANAGE STAFF\n");
                    System.out.println("1.Add Staff");
                    System.out.println("2.Remove Staff");
                    System.out.println("3.Display Staff List");
                    System.out.println("4.Back");
                    int c = inp.nextInt();
                    switch (c) {
                        case 1:
                        h.addStaff();
                            break;
                        case 2:
                        h.removeStaff();
                            break;
                        case 3:
                        h.displayAllStaff();
                            break;
                        case 4:
                        break;
                        default:
                        System.out.println("Invalid Input!");
                            break;
                    }
                    if(c==4)
                    break;
                }
                    break;
                case 4:
                while(true){
                    System.out.println("\nRESTAURANT OPERATIONS\n");
                    System.out.println("1.Display Menu");
                    System.out.println("2.Place Order");
                    System.out.println("3.View Bill");
                    System.out.println("4.Back");
                    int d = inp.nextInt();
                    switch (d) {
                        case 1:
                        h.displayRestaurantMenu();
                            break;
                        case 2:
                        h.orderRestaurantFood();
                            break;
                        case 3:
                        h.viewRestaurantPurchaseBill();
                            break;
                        case 4:
                            break;
                        default:
                        System.out.println("Invalid Input!");
                            break;
                    }
                    if(d==4)
                    break;
                }
                    break;
                case 5:
                    System.exit(0);
                default:
                System.out.println("Invalid Input!");
                    break;
            }
        }
        } else {
            System.out.println("You do not have access.");
        }
        inp.close(); // Close the Scanner instance here
    }
}

