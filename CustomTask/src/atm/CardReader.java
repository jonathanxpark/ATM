/**
 * This is an abstract class to show case the card reader operations. 
 * Extend this class to integrate it with a real bank system in the future.
 * @author jonathanxpark
 * @version 1.0
 * @since 2021-06-21
 */

package atm;

abstract class CardReaderBase {
    abstract String Read();
}

/**
 * Simple card reader class to provide values to test teh code
 * @author jonxpan
 * @version 1.0
 * @since 2021-06-21
 */
public class CardReader {

    public String Read() {
        return "1234";
    }
}
