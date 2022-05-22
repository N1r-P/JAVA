package products;

public class Goods extends Product {
    private String brand;
    private String reason;
    private String origin;

    /**
     *
     * @param name
     * @param description
     * @param price
     * @param brand
     * @param reason why you want to sell it
     * @param origin where did you buy it
     */
    public Goods(String name,String description,double price,String brand,String reason,String origin)
    {
        super();
        this.brand=brand;
        this.reason=reason;
        this.origin=origin;
    }

    /**
     * get the brand of the product
     * @return brand
     */
    public String getBrand() { return this.brand; }

    /**
     * get the reason of why you want to sell it
     * @return reason
     */
    public String getReason() { return this.reason; }

    /**
     * get the origin of the product
     * @return origin
     */
    public String getOrigin() { return this.origin; }
}
