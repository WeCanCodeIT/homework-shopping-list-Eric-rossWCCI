package shopping_cart;

import java.math.BigDecimal;

public class Item {

    // create string field for name
    private String name;
    private BigDecimal price;
    private int quantity;

    // create custom constructor that accepts state values
    public Item(String name, BigDecimal price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

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
    public String toString() {

        return "Current Cart \nItem: " + this.getName() + " Price: " + this.getPrice() + " Quantity: "
                + this.getQuantity() + " \n";
    }
}
