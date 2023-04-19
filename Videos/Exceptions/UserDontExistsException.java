package Videos.Exceptions;

public class UserDontExistsException extends Exception {

    public UserDontExistsException() {
        super();
    }

    public UserDontExistsException(String msg) {
        super(msg);
    }

}