package Videos.Controllers;

import Videos.Utilities.Utils;
import Videos.Repositories.*;
import Videos.Exceptions.*;
import Videos.Models.*;

import java.sql.SQLException;
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
        try {
            repository.addVideoDB(v);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao se conectar com o banco de dados.");
        }
        System.out.println("Vídeo publicado com sucesso.");
    }

    public void rem(User u) throws VideoDontExistsException, UnauthorizedException {
        System.out.println("Digite o nome do vídeo a ser removido");
        String videoName = Utils.inputStringField();

        Video v = repository.findVideoByName(videoName);

        if (v == null) {
            throw new VideoDontExistsException();
        }

        if (!Objects.equals(v.getPublisher().getEmail(), u.getEmail())) {
            throw new UnauthorizedException();
        }

        repository.remVideo(v);
        try {
            repository.remVideoDB(v);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao se conectar com o banco de dados.");
        }
        System.out.println("Vídeo removido com sucesso.");
    }

    public void edit(User u) throws VideoDontExistsException, UnauthorizedException {
        System.out.println("Digite o nome do vídeo a ser editado");
        String videoName = Utils.inputStringField();

        Video v = repository.findVideoByName(videoName);

        if (v == null) {
            throw new VideoDontExistsException();
        }

        if (!Objects.equals(v.getPublisher().getEmail(), u.getEmail())) {
            throw new UnauthorizedException();
        }

        Video newV = new Video(v.getName(), v.getPublisher(), v.getPublishedDate());

        System.out.println("Você deseja editar o nome do vídeo?");
        if (Utils.chooseYesOrNo()) {
            System.out.println("Digite o novo nome do vídeo:");
            videoName = Utils.inputStringField();
            newV.setName(videoName);
        }

        repository.editVideo(v, newV);
        try {
            repository.editVideoDB(v, newV);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao se conectar com o banco de dados.");
        }
        System.out.println("Vídeo editado com sucesso.");
    }

    public void listAllVideos() {
        if (repository.isEmpty()) {
            System.out.println("Não existe nenhum vídeo publicado.");
        } else {
            repository.listAllVideos();
        }
    }

    public void listAllVideosDB() {
        if (repository.isEmpty()) {
            System.out.println("Não existe nenhum vídeo publicado.");
        } else {
            try {
                repository.listAllVideosDB();
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Erro ao se conectar com o banco de dados.");
            }
        }
    }

    public Video findVideoByName(String videoName) {
        return repository.findVideoByName(videoName);
    }
}
