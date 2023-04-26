package Videos.Repositories;

import java.sql.SQLException;

import Videos.Models.*;

public interface InterfaceVideosRepository {
    // arraylist methods
    Video findVideoByName(String name);

    void search(String name);

    void addVideo(Video v);

    void remVideo(Video v);

    void editVideo(Video oldV, Video updatedV);

    void listAllVideos();

    boolean isEmpty();

    // db methods

    void addVideoDB(Video v) throws SQLException, ClassNotFoundException;

    void remVideoDB(Video v) throws ClassNotFoundException, SQLException;

    void editVideoDB(Video oldV, Video updatedV) throws SQLException, ClassNotFoundException;

    public void listAllVideosDB() throws SQLException, ClassNotFoundException;
}
