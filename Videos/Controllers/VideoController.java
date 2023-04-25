package Videos.Controllers;

import Videos.Utilities.Utils;
import Videos.Repositories.*;
import Videos.Exceptions.*;
import Videos.Models.*;

import java.util.Objects;

public class VideoController implements InterfaceVideoController {
    private InterfaceVideosRepository repository;

    public VideoController(VideoRepository repo) {
        this.repository = repo;
    }

    public void search(String name) {
        repository.search(name);
    }

    public void publishVideo(User u) throws VideoAlreadyExistsException {
        System.out.println("Digite o nome do vídeo a ser adicionado: ");
        String videoName = Utils.inputStringField();

        if (repository.findVideoByName(videoName) != null) {
            throw new VideoAlreadyExistsException();
        }

        Video v = new Video(videoName, u);

        repository.addVideo(v);
        System.out.println("Vídeo publicado com sucesso.");
    }

    public void rem(User u) throws VideoDontExistsException {
        System.out.println("Digite o nome do vídeo a ser removido");
        String videoName = Utils.inputStringField();

        Video v = repository.findVideoByName(videoName);

        if (v == null) {
            throw new VideoDontExistsException();
        }

        if (v.getPublisher() != u) {
            // TODO check if the validated user is the publisher of the video
        }

        repository.remVideo(v);
    }

    public void edit(User u) throws VideoDontExistsException {
        System.out.println("Digite o nome do vídeo a ser editado");
        String videoName = Utils.inputStringField();

        Video v = repository.findVideoByName(videoName);

        if (v == null) {
            throw new VideoDontExistsException();
        }

        if (!Objects.equals(v.getPublisher().getEmail(), u.getEmail())) {
            // TODO check if the validated user is the publisher of the video
            throw new UnsupportedOperationException("the video publisher is not the user");
        }

        Video newV = new Video(v.getName(), v.getPublisher(), v.getPublishedDate());

        System.out.println("Você deseja editar o nome do vídeo?");
        if (Utils.chooseYesOrNo()) {
            videoName = Utils.inputStringField();
            newV.setName(videoName);
        }

        repository.editVideo(v, newV);
    }

    public void listAllVideos() {
        if (repository.isEmpty()) {
            System.out.println("Não existe nenhum vídeo publicado.");
        } else {
            repository.listAllVideos();
        }
    }

    public Video findVideoByName(String videoName) {
        return repository.findVideoByName(videoName);
    }
}
