package Videos.Exceptions;

public class VideoDontExistsException extends Exception {
    public VideoDontExistsException() {
        super();
    }

    public VideoDontExistsException(String msg) {
        super(msg);
    }
}
