package shopping.base;

import java.util.Vector;

/**
 * <p>This class models a shopping cart.</p>
 *
 * @author A Jiayi
 * @version 1.0.0
 * @see Product
 */
public class ShoppingCart {
	/**
	 * This shopping cart maintains a collection of Product objects.
	 */
	Vector<Product> products = new Vector<Product>();
	
	/**
	 * Adds a new product to this shopping cart.
	 */
	public void addProduct(Product product) {
		products.add(product);
	}
	
	/**
	 * Obtains a String representation of all the products in this shopping cart.
	 * 
	 * @return if cart is not empty, a String with the information of every product in cart; otherwise the String "empty".
	 * @see Product.toString()
	 */
	public String toString() {
		String temp = "\n";
		for (Product p : products) {
			temp += p.toString() + "\n";
		}
		return temp;
	}

	/**
	 * Computes the total value of the products in this shopping cart.
	 * This is done by summing the values of each product.
	 * 
	 * @return the total value of the products in this shopping cart.
	 * @see Product.getValue()
	 */
	public double getTotalValue() {
		double temp = 0.0;
		for (Product p : products) {
			temp += p.getValue();
		}
		return temp;
	}
}
