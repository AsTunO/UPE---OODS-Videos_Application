package Videos.Models;

import java.util.ArrayList;
import java.util.List;

import Videos.Exceptions.InvalidEmailException;

public class Publisher extends User {

    private List<String> publishedVideos = new ArrayList<String>();

    public Publisher(String name, int age, String email, String password) throws InvalidEmailException { // Constructor
                                                                                                         // using all
                                                                                                         // fields
        super(name, age, email, password);
    }

    public Boolean publishNewVideo(String videoName, String pass) {
        if (validatePassword(pass)) {
            publishedVideos.add(videoName);
            return true;
        } else {
            return false;
        }
    }

    // Boilerplate Code

    public List<String> getPublishedHistoric() {
        return publishedVideos;
    }

}