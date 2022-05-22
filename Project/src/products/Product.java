package products;

public class Product {
    private String name;
    private String description;
    private double price;

    /**
     *
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
    public String getDescription() { return this.description; }

    /**
     * get the price of the product
     * @return price
     */
    public double getPrice() { return this.price; }
}
