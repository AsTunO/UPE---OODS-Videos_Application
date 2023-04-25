package Videos.Views;

import Videos.Controllers.InterfaceUserController;
import Videos.Controllers.InterfaceVideoController;
import Videos.Controllers.UserController;
import Videos.Controllers.VideoController;
import Videos.Exceptions.*;
import Videos.Models.Publisher;
import Videos.Models.User;
import Videos.Models.Video;
import Videos.Repositories.UsersRepository;
import Videos.Repositories.VideoRepository;
import Videos.Utilities.Utils;

import java.util.Scanner;

public class Terminal {
    public static void terminalInterface() {
        Scanner sc = new Scanner(System.in);
        Utils.setScanner(sc);
        InterfaceUserController usersController = new UserController(new UsersRepository());
        InterfaceVideoController videosController = new VideoController(new VideoRepository());

        int opt = -1;

        printMenu();

        while (opt != 0) {
            opt = Utils.optionSelector();

            switch (opt) {
                case 0: {
                    sc.close();
                    System.out.println("Encerrando aplicação.");
                    break;
                }
                case 1: {
                    try {
                        usersController.add();
                    } catch (UserAlreadyExistsException e) {
                        System.out.println("Um usuário com esse email já existe.");
                    } catch (InvalidEmailException e) {
                        System.out.println("O email informado é inválido.");
                    }
                    break;
                }
                case 2: {
                    try {
                        usersController.rem();
                    } catch (UnauthorizedException e) {
                        System.out.println("Dados inválidos, tente novamente mais tarde.");
                    } catch (InvalidEmailException e) {
                        System.out.println("O email informado é inválido.");
                    }
                    break;
                }
                case 3: {
                    try {
                        usersController.edit();
                    } catch (UnauthorizedException e) {
                        System.out.println("Dados inválidos, tente novamente mais tarde.");
                    } catch (InvalidEmailException e) {
                        System.out.println("O email informado é inválido.");
                    }
                    break;
                }
                case 4: {
                    try {
                        User u = usersController.authenticate();

                        System.out.println("Digite o nome do vídeo que você deseja assistir:");
                        String videoName = Utils.inputStringField();

                        Video v = videosController.findVideoByName(videoName);

                        if (v == null) {
                            throw new VideoDontExistsException();
                        }

                        usersController.watchVideo(u, v);
                        System.out.println("Vídeo assistido.");
                    } catch (VideoDontExistsException e) {
                        System.out.println("Não existe um vídeo publicado com esse nome.");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                }
                case 5: {
                    try {
                        User u = usersController.authenticate();

                        u.listHistory();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                }
                case 6: {
                    try {
                        User u = usersController.authenticate();

                        if (!(u instanceof Publisher)) {
                            throw new UserNotPublisherException();
                        }

                        videosController.publishVideo(u);
                    } catch (UnauthorizedException e) {
                        System.out.println("Dados inválidos, tente novamente mais tarde.");
                    } catch (UserNotPublisherException e) {
                        System.out.println("O usuário não tem a permissão de publicar vídeos.");
                    } catch (VideoAlreadyExistsException e) {
                        System.out.println("Já existe um vídeo publicado com esse nome.");
                    }
                    break;
                }
                case 7: {
                    try {
                        User u = usersController.authenticate();

                        if (!(u instanceof Publisher)) {
                            throw new UserNotPublisherException();
                        }

                        videosController.rem(u);
                    } catch (UnauthorizedException e) {
                        System.out.println("Dados inválidos, tente novamente mais tarde.");
                    } catch (UserNotPublisherException e) {
                        System.out.println("O usuário não tem a permissão de publicar vídeos.");
                    } catch (VideoDontExistsException e) {
                        System.out.println("Não existe um vídeo publicado com esse nome.");
                    }
                    break;
                }
                case 8: {
                    try {
                        User u = usersController.authenticate();

                        if (!(u instanceof Publisher)) {
                            throw new UserNotPublisherException();
                        }

                        videosController.edit(u);
                    } catch (UnauthorizedException e) {
                        System.out.println("Dados inválidos, tente novamente mais tarde.");
                    } catch (UserNotPublisherException e) {
                        System.out.println("O usuário não tem a permissão de publicar vídeos.");
                    } catch (VideoDontExistsException e) {
                        System.out.println("Não existe um vídeo publicado com esse nome.");
                    }
                    break;
                }
                case 9:{
                    try {
                        System.out.println("Digite um termo para busca: ");
                        String name = Utils.inputStringField();

                        videosController.search(name);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                }
                case 10: {
                    usersController.listAllUsers();
                    break;
                }
                case 11: {
                    videosController.listAllVideos();
                    break;
                }
                case 12: {
                    printMenu();
                    break;
                }
            }
        }
    }

    public static void printMenu() {
        System.out.println("----------------------------------------");
        System.out.println("Digite 1 para criar um novo usuário.");
        System.out.println("Digite 2 para remover um usuário.");
        System.out.println("Digite 3 para editar um usuário.");
        System.out.println("Digite 4 para assistir um vídeo.");
        System.out.println("Digite 5 para listar o histórico do usuário.");
        System.out.println("Digite 6 para publicar um vídeo.");
        System.out.println("Digite 7 para deletar um vídeo publicado.");
        System.out.println("Digite 8 para editar um vídeo publicado.");
        System.out.println("Digite 9 para pesquisar um vídeo.");
        System.out.println("Digite 10 para listar todos os usuários.");
        System.out.println("Digite 11 para listar todos os vídeos");
        System.out.println("Digite 12 para exibir esse menu novamente.");
        System.out.println("Digite 0 para encerrar o programa.");
        System.out.println("----------------------------------------");
    }
}
