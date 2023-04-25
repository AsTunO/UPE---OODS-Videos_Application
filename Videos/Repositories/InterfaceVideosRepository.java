package Videos.Repositories;

import Videos.Models.*;
import Videos.Exceptions.*;

public interface InterfaceVideosRepository {

    Video findVideoByName(String name);

    void search(String name);

    void addVideo(Video v) throws VideoAlreadyExistsException;

    void remVideo(Video v) throws VideoDontExistsException;

    void editVideo(Video oldV, Video updatedV) throws VideoDontExistsException;

    void listAllVideos();

    boolean isEmpty();
}
