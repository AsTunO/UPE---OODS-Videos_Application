package Videos.Repositories;

import Videos.Exceptions.*;
import Videos.Models.User;

public interface InterfaceUsersRepository {

    public User searchByEmail(String email);

    public void addUser(User u) throws UserAlreadyExistsException;

    public void remUser(User u) throws UserDontExistsException;

    public void editUser(User updatedUser) throws UserDontExistsException;

}
