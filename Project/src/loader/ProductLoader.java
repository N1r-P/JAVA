package loader;

import products.Product;
import java.io.*;

/**
 * This interface declares a method for obtaining a product catalog from a file.
 *
 * @author Enboy Yu
 * @version 1.0
 */

public interface ProductLoader {

    /**
     * Loads the information in the specified file into a product catalog and
     * returns the catalog.
     *
     * @param fileName The name of a file that contains catalog information.
     * @return a product catalog.
     * @throws FileNotFoundException if the specified file does not exist.
     * @throws IOException           if there is an error reading the information in
     *                               the specified file.
     * @throws DataFormatException   if the file contains badly-formed data.
     */
    Product loadProduct(String fileName) throws FileNotFoundException, IOException, DataFormatException;
}
