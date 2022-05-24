package loader;

public class DataFormatException extends Exception {

    /**
     * Class serialVersionUID to verify that the version is consistent.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a <code>DataFormatException</code> with no detail message.
     */
    public DataFormatException() {

    }

    /**
     * Constructs a <code>DataFormatException</code> with the specified detail
     * message.
     *
     * @param message the malformed data
     */
    public DataFormatException(String message) {

        super(message);
    }
}
