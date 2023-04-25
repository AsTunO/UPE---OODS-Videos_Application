package Videos.Models;

import java.util.ArrayList;
import java.util.List;
import Videos.Exceptions.*;
import Videos.Models.Video;

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
        this.password = password;
    }

    // function to authenticate the user
    public boolean validatePassword(String pass) {
        boolean result = false;

        if (this.password.equals(pass)) {
            result = true;
        }

        return result;
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

    public void setName(String name, String pass) {
        if (validatePassword(pass)) {
            this.name = name;
        }
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age, String pass) {
        if (validatePassword(pass)) {
            if (age > 0) {
                this.age = age;
            } else {
                this.age = 0;
            }
        }
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email, String pass) {
        if (validatePassword(pass)) {
            this.email = email;
        }
    }

    public void setPassword(String newPass, String pass) {
        if (validatePassword(pass)) {
            this.password = newPass;
        }
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