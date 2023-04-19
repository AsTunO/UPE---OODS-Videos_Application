package Videos.Controllers;

import Videos.Exceptions.*;

public interface InterfaceUserController {
    public void add() throws InvalidEmailException, UserAlreadyExistsException;

    public void rem() throws InvalidEmailException, UserDontExistsException;

    public void edit() throws InvalidEmailException, UserDontExistsException;

    public void watchVideo() throws InvalidEmailException, UserDontExistsException;

    public void listHistory() throws InvalidEmailException, UserDontExistsException;

    public void publishVideo() throws InvalidEmailException, UserDontExistsException, UserNotPublisherException;

    public void deleteVideo() throws InvalidEmailException, UserDontExistsException, UserNotPublisherException;

    public void editVideo() throws InvalidEmailException, UserDontExistsException, UserNotPublisherException;

    public void searchVideos();
}
