package Videos.Models;

import java.util.ArrayList;
import java.util.List;

import Videos.Exceptions.InvalidEmailException;

public class Spectator extends User {

    private List<String> watchedVideos = new ArrayList<String>();

    // Constructor using all fields
    public Spectator(String name, int age, String email, String password) throws InvalidEmailException {
        super(name, age, email, password);
    }

    // public Spectator(List<String> watchedVideos) {
    // this.watchedVideos = watchedVideos;
    // }

    public void watch(String videoName) {
        watchedVideos.add(videoName);
    }

    // Boilerplate Code

    public List<String> getHistoric() {
        return watchedVideos;
    }

}