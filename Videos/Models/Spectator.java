package Videos.Models;

import Videos.Exceptions.InvalidEmailException;

public class Spectator extends User {
    // Constructor using all fields
    public Spectator(String name, int age, String email, String password) throws InvalidEmailException {
        super(name, age, email, password);
    }

    // public Spectator(List<String> watchedVideos) {
    // this.watchedVideos = watchedVideos;
    // }
}