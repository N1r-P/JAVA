package loader;

import java.util.*;
import java.io.*;
import products.*;

/**
 * The class FileCatalogLoader implements interface CatalogLoader.
 * It is used to obtain a product catalog from a file.
 *
 * @author  Enboy Yu
 * @version  1.0.0
 * @see ProductLoader
 * @see products
 * @see DataFormatException
 * @see Product
 * @see Goods
 * @see Task
 */

public class FileProductLoader implements ProductLoader{

    /**
     * This method reads a line of coffee-accessory data.
     *
     * @return a <code>Product</code> object that encapsulates the accessory data.
     * @throws  <code>DataFormatException</code> that contains the line of
     *           malformed data.
     */
    private Product readProduct(String line) throws DataFormatException {

        StringTokenizer st = new StringTokenizer(line, "_");
        if (st.countTokens() != 4) {
            throw new DataFormatException(line);
        } else {
            try {
                st.nextToken();
                return new Product();
            } catch (NumberFormatException nfe) {
                throw new DataFormatException(line);
            }
        }
    }

    /**
     * This method reads a line of coffee data.
     *
     * @return a <code>Coffee</code> object that encapsulates the coffee data.
     * @throws  <code>DataFormatException</code> that contains the line of
     *           malformed data.
     */
    private Goods readGoods(String line) throws DataFormatException {
        StringTokenizer st = new StringTokenizer(line, "_");
        if (st.countTokens() != 10) {
            throw new DataFormatException(line);
        } else {
            try {
                st.nextToken();
                return new Goods(st.nextToken(), st.nextToken(), Double.parseDouble(st.nextToken()),
                                 st.nextToken(), st.nextToken(), st.nextToken());
            } catch (NumberFormatException nfe) {
                throw new DataFormatException(line);
            }
        }
    }

    /**
     * This method reads a line of coffee-brewer data.
     *
     * @return a <code>CoffeeBrewer</code> object that encapsulates the brewer data.
     * @throws  <code>DataFormatException</code> that contains the line of
     *           malformed data.
     */
    private Task readTask(String line) throws DataFormatException {
        StringTokenizer st = new StringTokenizer(line, "_");
        if (st.countTokens() != 7) {
            throw new DataFormatException(line);
        } else {
            try {
                st.nextToken();
                return new Task(st.nextToken(), st.nextToken(), Double.parseDouble(st.nextToken()),
                        st.nextToken(), st.nextToken());
            } catch (NumberFormatException nfe) {
                throw new DataFormatException(line);
            }
        }
    }

    /**
     * This method loads the information in the specified file into a product
     * catalog and returns the catalog.
     *
     * @return a product catalog.
     * @throws <code>FileNotFoundException</code>
     * @throws <code>IOException</code>
     * @throws <code>DataFormatException</code>
     */
    public Product loadProduct(String filename) throws FileNotFoundException, IOException, DataFormatException {
        Product product = new Product();
        BufferedReader file = new BufferedReader(new FileReader(filename));
        String line = file.readLine();

        while (line != null) {
            if (line.startsWith("Product")) {
                product.addProduct(readProduct(line));//红色部分函数需要在Product类中创造
            } else if (line.startsWith("Goods")) {
                product.addProduct(readGoods(line));
            } else if (line.startsWith("Task")) {
                product.addProduct(readTask(line));
            } else {
                file.close();
                throw new DataFormatException(line);
            }

            line = file.readLine();
        }

        file.close();
        return product;
    }
}
