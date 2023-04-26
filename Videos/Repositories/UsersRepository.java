package Videos.Repositories;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

import Videos.DB.DBConnection;
import Videos.Exceptions.InvalidEmailException;
import Videos.Models.Publisher;
import Videos.Models.Spectator;
import Videos.Models.User;
import Videos.Models.Video;
import Videos.Utilities.Utils;

public class UsersRepository implements InterfaceUsersRepository {
    private List<User> collection = new ArrayList<User>();

    private DBConnection genConn;
    Connection connection;

    public UsersRepository() {
        genConn = DBConnection.getInstancia();
        collection = Utils.loadDBUsersTable();
        // genConn.loadProperties();
    }

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

    // database methods
    @Override
    public User searchByEmailDB(String email) throws ClassNotFoundException, SQLException {
        User u = null;
        connection = genConn.connection();

        String name, pass;
        int age;

        String sql = "SELECT * FROM users WHERE EMAIL = ?";
        PreparedStatement pstmt;
        pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, sql);

        ResultSet set = pstmt.executeQuery();

        if (set.next()) {
            name = set.getString("NAME");
            email = set.getString("EMAIL");
            pass = set.getString("PASSWORD");
            age = set.getInt("AGE");
            try {
                if (set.getBoolean("IS_PUBLISHER")) {
                    u = new Publisher(name, age, email, pass);
                } else {
                    u = new Spectator(name, age, email, pass);
                }
            } catch (InvalidEmailException e) {
                e.printStackTrace();
            }
        }

        genConn.disconnect(connection);
        return u;
    }

    @Override
    public void addUserDB(User u) throws ClassNotFoundException, SQLException {
        connection = genConn.connection();

        String sql = "INSERT INTO users (EMAIL, NAME, PASSWORD, AGE, IS_PUBLISHER) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement pstmt;
        pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, u.getEmail());
        pstmt.setString(2, u.getName());
        pstmt.setString(3, u.getPassword());
        pstmt.setInt(4, u.getAge());
        pstmt.setBoolean(5, u instanceof Publisher);

        pstmt.executeUpdate();

        genConn.disconnect(connection);
    }

    @Override
    public void remUserDB(User u) throws SQLException, ClassNotFoundException {
        connection = genConn.connection();

        String sql = "DELETE FROM users WHERE EMAIL = ?";

        PreparedStatement pstmt;
        pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, u.getEmail());

        pstmt.executeUpdate();

        genConn.disconnect(connection);
    }

    @Override
    public void editUserDB(User oldUser, User updatedUser) throws ClassNotFoundException, SQLException {
        connection = genConn.connection();

        String sql = "UPDATE users SET EMAIL = ?, NAME = ?, PASSWORD = ?, AGE = ? WHERE EMAIL = ?";

        PreparedStatement pstmt;
        pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, updatedUser.getEmail());
        pstmt.setString(2, updatedUser.getName());
        pstmt.setString(3, updatedUser.getPassword());
        pstmt.setInt(4, updatedUser.getAge());
        pstmt.setString(5, oldUser.getEmail());

        pstmt.executeUpdate();

        genConn.disconnect(connection);
    }

    @Override
    public void listAllUsersDB() throws ClassNotFoundException, SQLException {
        connection = genConn.connection();

        String sql = "SELECT * FROM users";

        Statement stmt;
        stmt = connection.createStatement();
        ResultSet set = stmt.executeQuery(sql);

        System.out.println("------------------------------------");
        while (set.next()) {
            try {
                String name = set.getString("NAME"), pass = set.getString("PASSWORD"), email = set.getString("EMAIL");
                int age = set.getInt("AGE");
                User u = null;

                if (set.getBoolean("IS_PUBLISHER")) {
                    u = new Publisher(name, age, email, pass);
                } else {
                    u = new Spectator(name, age, email, pass);
                }

                System.out.println(u);
                System.out.println("------------------------------------");

            } catch (InvalidEmailException e) {
                e.printStackTrace();
            }
        }

        genConn.disconnect(connection);
    }
}
