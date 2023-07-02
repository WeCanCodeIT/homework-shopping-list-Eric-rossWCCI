package shopping_cart;

import java.math.BigDecimal;

public class ShopApp {

    public static void main(String [] args){
        // create Item instance using custom constructor
        Item item = new Item("shoes", new BigDecimal(25.00), 2);

        // invoke overriden toString method of Item class
        System.out.println(item.toString());
        

    }

}
