package Videos.Repositories;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

import Videos.Controllers.InterfaceUserController;
import Videos.DB.*;
import Videos.Models.User;
import Videos.Models.Video;
import Videos.Utilities.Utils;

public class VideoRepository implements InterfaceVideosRepository {
    private List<Video> collection = new ArrayList<>();

    private DBConnection genConn;
    Connection connection;

    private InterfaceUserController userController;

    public VideoRepository(InterfaceUserController userController) {
        genConn = DBConnection.getInstancia();
        collection = Utils.loadDBVideosTable(userController);
        this.userController = userController;
    }

    public void search(String name) {
        if (collection.isEmpty()) {
            System.out.println("Não existe nenhum vídeo publicado");
        } else {
            boolean finded = false;
            for (Video v : collection) {
                if (v.getName().contains(name)) {
                    System.out.println(v);
                    finded = true;
                }
            }
            if (!finded) {
                System.out.println("Nenhum vídeo encontrado.");
            }
        }
    }

    public void addVideo(Video v) {
        collection.add(v);
    }

    public void remVideo(Video v) {
        collection.remove(v);
    }

    public void editVideo(Video oldV, Video updatedV) {
        collection.remove(oldV);
        collection.add(updatedV);
    }

    public Video findVideoByName(String name) {
        Video result = null;

        for (Video v : collection) {
            if (Objects.equals(v.getName(), name)) {
                result = v;
            }
        }

        return result;
    }

    public void listAllVideos() {
        System.out.println("------------------------------------");
        for (Video v : collection) {
            System.out.println(v);
            System.out.println("------------------------------------");
        }
    }

    public boolean isEmpty() {
        return collection.isEmpty();
    }

    // db methods

    @Override
    public void addVideoDB(Video v) throws SQLException, ClassNotFoundException {
        connection = genConn.connection();

        String sql = "INSERT INTO videos (NAME, PUBLISHER_EMAIL, PUBLISHED_DATE) VALUES (?, ?, ?)";

        java.util.Date utilDate = v.getPublishedDate();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        PreparedStatement pstmt;
        pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, v.getName());
        pstmt.setString(2, v.getPublisher().getEmail());
        pstmt.setDate(3, sqlDate);

        pstmt.executeUpdate();

        genConn.disconnect(connection);
    }

    @Override
    public void remVideoDB(Video v) throws ClassNotFoundException, SQLException {
        connection = genConn.connection();

        String sql = "DELETE FROM videos WHERE NAME = ?";

        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, v.getName());

        pstmt.executeUpdate();

        genConn.disconnect(connection);
    }

    @Override
    public void editVideoDB(Video oldV, Video updatedV) throws SQLException, ClassNotFoundException {
        connection = genConn.connection();

        String sql = "UPDATE videos SET NAME = ? WHERE NAME = ?";

        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, updatedV.getName());
        pstmt.setString(2, oldV.getName());

        pstmt.executeUpdate();

        genConn.disconnect(connection);
    }

    @Override
    public void listAllVideosDB() throws SQLException, ClassNotFoundException {
        connection = genConn.connection();

        String sql = "SELECT * FROM videos";

        Statement stmt = connection.createStatement();
        ResultSet set = stmt.executeQuery(sql);

        System.out.println("------------------------------------");
        while (set.next()) {
            String name = set.getString("NAME");
            User p = userController.searchByEmail(set.getString("PUBLISHER_EMAIL"));
            java.sql.Date publishedDate = set.getDate("PUBLISHED_DATE");
            Video v = new Video(name, p, publishedDate);
            System.out.println(v);
            System.out.println("------------------------------------");
        }

        genConn.disconnect(connection);
    }
}
