package Videos.Controllers;

import Videos.Exceptions.*;
import Videos.Models.*;

public interface InterfaceUserController {
    public void add() throws InvalidEmailException, UserAlreadyExistsException;

    public void rem() throws InvalidEmailException, UnauthorizedException;

    public void edit() throws InvalidEmailException, UnauthorizedException;

    public void watchVideo(User u, Video v);

    public void listAllUsers();

    public User searchByEmail(String email);

    public User authenticate() throws UnauthorizedException;
}
