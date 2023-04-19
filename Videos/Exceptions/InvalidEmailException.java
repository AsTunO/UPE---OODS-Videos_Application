package Videos.Exceptions;

public class InvalidEmailException extends Exception {

    public InvalidEmailException() {
        super();
    }

    public InvalidEmailException(String msg) {
        super(msg);
    }

}
