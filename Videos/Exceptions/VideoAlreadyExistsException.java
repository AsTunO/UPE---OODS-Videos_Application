package Videos.Exceptions;

public class VideoAlreadyExistsException extends Exception {
    public VideoAlreadyExistsException() {
        super();
    }

    public VideoAlreadyExistsException(String msg) {
        super(msg);
    }
}
