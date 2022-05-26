package products;

import java.util.*;

public class Product {
    private String name;
    private String description;
    private double price;

    /**
     * initialize the property
     * @param name
     * @param description
     * @param price
     */
    public Product(String name,String description,double price)
    {
        this.name=name;
        this.description=description;
        this.price=price;
    }

    /**
     * get the name of the product
     * @return name
     */
    public String getName() { return this.name; }

    /**
     * get the description of the product
     * @return description
     */
    public  String getDescription() {return this.description; }

    /**
     * get the price of the product
     * @return price
     */
    public double getPrice() { return this.price; }

    /**
     * A vector of <code>Product</code>.
     */
    private Vector<Product> products;

    /**
     * Add the specified product to the vector products.
     *
     * @param product the specified product added to the vector products.
     */
    public void addProduct(Product product) {
        products.add(product);
    }
    
}
