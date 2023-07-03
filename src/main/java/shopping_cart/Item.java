package shopping_cart;

import java.math.BigDecimal;
import java.util.ArrayList;


// class that represents the item that we create with user input data and re use to help print the total cart info
public class Item {

    // create string field for name
    private String name;
    // create field to hold price
    private BigDecimal price;
    // create field to hold quantity
    private int quantity;

    // create custom constructor that accepts state values
    public Item(String name, BigDecimal price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // create public accessors to get and set field values 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // override inherent toString method with custom implementation
    public String toString(BigDecimal total, ArrayList<Item> items) {
        // concatenate message to print using concatenation and looping
        String init = "Current Cart \n";
        for(Item i: items){
            init = init + "Item: " + i.getName() + " Price: " + i.getPrice() + " Quantity: "
            + i.getQuantity() + " \n";
        }
        init = init + "Total Price: "+ total;

        return init;
    }

}

