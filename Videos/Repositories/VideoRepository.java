package Videos.Repositories;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

import Videos.Exceptions.VideoAlreadyExistsException;
import Videos.Exceptions.VideoDontExistsException;
import Videos.Models.User;
import Videos.Models.Video;

public class VideoRepository implements InterfaceVideosRepository {
    private List<Video> collection = new ArrayList<>();

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

    public void addVideo(Video v) throws VideoAlreadyExistsException {
        collection.add(v);
    }

    public void remVideo(Video v) throws VideoDontExistsException {
        collection.remove(v);
    }

    public void editVideo(Video oldV, Video updatedV) throws VideoDontExistsException {
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
}
