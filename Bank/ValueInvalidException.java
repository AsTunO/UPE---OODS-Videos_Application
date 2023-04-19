package Bank;

public class ValueInvalidException extends Exception {
    public ValueInvalidException() {
        super();
    }

    public ValueInvalidException(String msg) {
        super(msg);
    }
}
