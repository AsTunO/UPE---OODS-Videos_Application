package Videos.Repositories;

import java.util.List;
import java.util.ArrayList;
import Videos.Exceptions.UserDontExistsException;
import Videos.Models.User;
import Videos.Exceptions.UserAlreadyExistsException;

public class UsersRepository implements InterfaceUsersRepository {
    private List<User> collection = new ArrayList<User>();

    public User searchByEmail(String email) {
        User u = null;

        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).getEmail() == email) {
                u = collection.get(i);
            }
        }

        return u;
    }

    public void addUser(User u) throws UserAlreadyExistsException {
        try {
            if (searchByEmail(u.getEmail()) != null) {
                throw new UserAlreadyExistsException();
            }
            collection.add(u);
        } catch (Exception e) {
            throw e;
        }
    }

    public void remUser(User u) throws UserDontExistsException {
        try {
            if (searchByEmail(u.getEmail()) == null) {
                throw new UserDontExistsException();
            }
            collection.remove(u);
        } catch (Exception e) {
            throw e;
        }
    }

    public void editUser(User updatedUser) throws UserDontExistsException {
        try {
            for (int i = 0; i < collection.size(); i++) {
                if (collection.get(i).getEmail() == updatedUser.getEmail()) {
                    collection.remove(i);
                    collection.add(i, updatedUser);
                    return;
                }
            }

            throw new UserDontExistsException();
        } catch (Exception e) {
            throw e;
        }
    }
}
