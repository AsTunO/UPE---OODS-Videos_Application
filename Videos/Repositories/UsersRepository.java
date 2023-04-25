package Videos.Repositories;

import java.util.List;
import java.util.ArrayList;
import Videos.Models.User;
import Videos.Models.Video;

public class UsersRepository implements InterfaceUsersRepository {
    private List<User> collection = new ArrayList<User>();

    public User searchByEmail(String email) {
        User u = null;

        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).getEmail().equals(email)) {
                u = collection.get(i);
            }
        }

        return u;
    }

    public void addUser(User u) {
        collection.add(u);
    }

    public void remUser(User u) {
        collection.remove(u);
    }

    public void editUser(User oldUser, User updatedUser) {
        collection.remove(oldUser);
        collection.add(updatedUser);
    }

    public void listAllUsers() {
        System.out.println("------------------------------------");
        for (User u : collection) {
            System.out.println(u);
            System.out.println("------------------------------------");
        }
    }

    public void watchVideo(User u, Video v) {
        collection.remove(u);
        u.watch(v);
        collection.add(u);
    }

    public boolean isEmpty() {
        return collection.isEmpty();
    }
}
