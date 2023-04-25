package Videos.Controllers;

import Videos.Exceptions.*;
import Videos.Models.*;

public interface InterfaceVideoController {
    void search(String name);

    public void publishVideo(User u) throws VideoAlreadyExistsException;

    void rem(User u) throws VideoDontExistsException;

    public void edit(User u) throws VideoDontExistsException;

    public void listAllVideos();

    public Video findVideoByName(String videoName);
}
