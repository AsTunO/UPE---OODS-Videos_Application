package Videos.Repositories;

import java.sql.SQLException;

import Videos.Models.User;
import Videos.Models.Video;

public interface InterfaceUsersRepository {
    // arraylist methods

    public User searchByEmail(String email);

    public void addUser(User u);

    public void remUser(User u);

    public void editUser(User oldUser, User updatedUser);

    public void listAllUsers();

    public void watchVideo(User u, Video v);

    public boolean isEmpty();

    // database methods
    public User searchByEmailDB(String email) throws ClassNotFoundException, SQLException;

    public void addUserDB(User u) throws ClassNotFoundException, SQLException;

    public void remUserDB(User u) throws SQLException, ClassNotFoundException;

    public void editUserDB(User oldUser, User updatedUser) throws ClassNotFoundException, SQLException;

    public void listAllUsersDB() throws ClassNotFoundException, SQLException;
}
