package atm;

abstract class CardReaderBase {
    abstract String Read();
}

public class CardReader {

    public String Read() {
        return "1234";
    }
}
