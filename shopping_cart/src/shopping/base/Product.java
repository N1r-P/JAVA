package shopping.base;

/**
 * <p>
 * This class models a product.
 * </p>
 *
 * @author A Jiayi
 * @version 1.0.0
 */
public class Product {
	/**
	 * The name of the product
	 */
	private String name;

	/**
	 * The quantity of the product
	 */
	private int quantity;

	/**
	 * The price of the product
	 */
	private double price;

	/**
	 * Constructs a Product object.
	 */
	public Product(String initialName, int initialQuantity, double initialPrice) {
		name = initialName;
		quantity = initialQuantity;
		price = initialPrice;
	}

	/**
	 * Obtains the name of this product.
	 * 
	 * @return the name of this product.
	 */
	public String getName() {
		return name;

	}

	/**
	 * Obtains the quantity of this product.
	 * 
	 * @return the quantity of this product.
	 */
	public int getQuantity() {
		return quantity;

	}

	/**
	 * Obtains the price of this product.
	 * 
	 * @return the price of this product.
	 */
	public double getPrice() {
		return price;

	}

	/**
	 * Obtains the value of this product. The value is quantity times price.
	 * 
	 * @return the price of this product.
	 */
	public double getValue() {
		return quantity * price;
	}

	/**
	 * Returns a String representation of this product.
	 * 
	 * @return the String representation of this product.
	 */
	public String toString() {
		return name + "_" + quantity + "_" + price;
	}
}
