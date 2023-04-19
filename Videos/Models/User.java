package Videos.Models;

import Videos.Exceptions.*;

public abstract class User {

    private String name;
    private String email;
    private String password;
    private int age;

    // Constructor using all fields
    public User(String name, int age, String email, String password) throws InvalidEmailException {
        this.name = name;
        this.age = age;
        if (email.contains("@")) {
            this.email = email;
        } else {
            throw new InvalidEmailException();
        }
        this.password = password;
    }

    // function to authenticate the user
    public boolean validatePassword(String pass) {
        boolean result = false;

        if (pass == this.password) {
            result = true;
        }

        return result;
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
                ", password='" + "hidden" + "'" +
                "}";
    }

}