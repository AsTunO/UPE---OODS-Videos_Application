package Videos.Repositories;

import Videos.Models.User;
import Videos.Models.Video;

public interface InterfaceUsersRepository {
    public User searchByEmail(String email);

    public void addUser(User u);

    public void remUser(User u);

    public void editUser(User oldUser, User updatedUser);

    public void listAllUsers();

    public void watchVideo(User u, Video v);

    public boolean isEmpty();
}
