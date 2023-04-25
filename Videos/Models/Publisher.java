package Videos.Models;

import java.util.ArrayList;
import java.util.List;

import Videos.Exceptions.InvalidEmailException;

public class Publisher extends User {
    private List<Video> publishedVideos = new ArrayList<Video>();

    // Constructor using all fields
    public Publisher(String name, int age, String email, String password) throws InvalidEmailException {
        super(name, age, email, password);
    }

    public void publishNewVideo(Video v, String pass) {
        publishedVideos.add(v);
    }

    // Boilerplate Code
    public List<Video> getPublishedHistoric() {
        return publishedVideos;
    }

}