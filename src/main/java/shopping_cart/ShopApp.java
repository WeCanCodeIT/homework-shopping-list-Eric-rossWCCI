package shopping_cart;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class ShopApp {
    // create field to serve as a container for list of items
    ArrayList<Item> listOfItems = new ArrayList<Item>();
    // create field to keep track of total cart price
    BigDecimal totalCartPrice = new BigDecimal(0.0);
    // create field to store shopping status
    boolean stillShopping;

    // create main method that starts the application 
    public static void main(String[] args) {
        /*
        create instance of this class so that we can call non static member 
        startShoppingExperience as created objects are non static. 
        Since both are non static, the communication is possible
         */ 
        ShopApp shopApp = new ShopApp();
        // now that the object is created, make the call to it's startShoppingExperience method
        shopApp.startShoppingExperience();
    }

    public void startShoppingExperience() {
        // create Item instance using custom constructor
        // round BigDecimal to two decimal places
        Item item = new Item("shoes", new BigDecimal(25.00).setScale(2, RoundingMode.HALF_UP), 2);
        // create new item called item two for the sock purchase
        Item item2 = new Item("socks", new BigDecimal(10.00).setScale(2, RoundingMode.HALF_UP), 3);
        // preload the two items that were just created so that the user sees two items in cart initially 
        addItems(item);
        addItems(item2);

         /*
          * call method of this class from non static method.
           Notice that we don't have to create an object to make this call. 
          */
        retrieveUserInput();

    }

    public void retrieveUserInput() {
        // create scanner object to interact with user from console
        Scanner scanner = new Scanner(System.in);

        // use do while loop to prompt for user input at least once.
        do {
            // prompt user for name
            System.out.println("Enter the name of the item: ");
            // save the user's name input by escaping entire line
            String name = scanner.nextLine();
            // prompt user for price and save result as bigDecimal
            System.out.println("Enter the unit price: ");
            BigDecimal price = scanner.nextBigDecimal();
            // since we are technically on the same line, escape the line so the following logic works as intended
            scanner.nextLine();
            // prompt user for quantity and save as Integer
            System.out.println("Enter the quantity: ");
            Integer quantity = scanner.nextInt();
            scanner.nextLine();
            // create item object using custom constructor and values harvested from user
            Item item = new Item(name, price, quantity);
            // call addItems method of this class
            addItems(item);


            // continue shopping
            System.out.println("Continue shopping (y/n)? ");
            String answer = scanner.nextLine();
            determineShoppingStatus(answer);
        } while (stillShopping == true);
        scanner.close();
    }

    // create method to determine if we should still shop
    public void determineShoppingStatus(String ans) {
        stillShopping = ans.toLowerCase().equals("y") ? true : false;
    }

    // create method that adds to item list
    private void addItems(Item item) {
        // add to item list
        listOfItems.add(item);
        // call calculateCartPrice of this class.
        calculateCartPrice();
        // now that we've calculated the total, let's call the toString method with it.
        System.out.println(item.toString(totalCartPrice, listOfItems));
        // reset price
        totalCartPrice = new BigDecimal(0.0);

    }

    public void calculateCartPrice() {
        // loop through each item in the items list and add to a running total (totalCartPrice)
        for (Item i : listOfItems) {
            // use bigDecimal multiplication method to multiply quantity by price of current
            // item and add that result to the current totalCartPrice value. 
            totalCartPrice = totalCartPrice.add(i.getPrice().multiply(new BigDecimal(i.getQuantity())));

        }

    }

}
