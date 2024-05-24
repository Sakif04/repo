package HotelManagement;

import java.util.*;

public class Restaurant {

    private ArrayList<String> menu = new ArrayList<String>();
    private ArrayList<Double> price = new ArrayList<Double>();
    private double totalPrice;

    Restaurant() {
        menu.add("1.Chinese set  -- 350.50Tk.");
        menu.add("2.Thai set-- 320.30Tk.");
        menu.add("3.Indian set -- 300.00Tk.");
        menu.add("4.Classic Bengali -- 200.60Tk.");
        menu.add("5.Snacks set -- 80.00Tk.");
        menu.add("6.Refreshments -- 100.00Tk.");

        price.add(350.5);
        price.add(320.3);
        price.add(300.0);
        price.add(200.60);
        price.add(80.00);
        price.add(100.00);

    }

    public  ArrayList<String> getMenu(){
        return menu;
    }

    public void displayMenu() {
        for (String x : menu) {
            System.out.println(x);
        }
    }

    public void placeOrder(int ch) {
        displayMenu();
        if (ch >= 1 && ch <= menu.size()) {
            totalPrice += price.get(ch - 1);
        }

    }

    public String viewBill(int ch) {
        return "Purchased: "+ menu.get(ch-1)+
         "Bill for the purchase is: " + totalPrice + "Tk.";
    }

}