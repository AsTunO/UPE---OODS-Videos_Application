package Videos.Models;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import Videos.Exceptions.*;

public abstract class User {

    private String name;
    private String email;
    private String password;
    private int age;
    private List<Video> watchedVideos = new ArrayList<Video>();

    // Constructor using all fields
    public User(String name, int age, String email, String password) throws InvalidEmailException {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = encodeString(password);
    }

    // function to authenticate the user
    public boolean validatePassword(String pass) {
        boolean result = false;

        if (encodeString(pass).equals(password)) {
            result = true;
        }

        return result;
    }

    public String encodeString(String str) {
        String encodedStr = null;

        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
            md.update(salt);

            byte[] hashedStr = md.digest(str.getBytes(StandardCharsets.UTF_8));
            encodedStr = new String(hashedStr, StandardCharsets.UTF_8);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return str;
    }

    public void watch(Video v) {
        watchedVideos.add(v);
    }

    public void listHistory() {
        if (watchedVideos.isEmpty()) {
            System.out.println("O usuário não assistiu nenhum vídeo.");
        } else {
            for (Video v : watchedVideos) {
                System.out.println(v);
            }
        }
    }

    // Boilerplate Code

    // getters & setters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String newPass) {
        this.password = encodeString(newPass);
    }

    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                ", age='" + getAge() + "'" +
                ", email='" + getEmail() + "'" +
                "}";
    }
}