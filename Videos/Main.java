package Videos;

import Videos.Controllers.*;
import Videos.Exceptions.*;
import Videos.Repositories.UsersRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        terminalInterface();
    }

    public static void terminalInterface() {
        // Publisher p1 = new Publisher("Indiano", 19, "bla@bla.com", "123456");
        // Spectator s1 = new Spectator("Usuário", 21, "as@as.com", "123456");

        // System.out.println(p1.publishNewVideo("Tutorial Java", "12342"));
        // System.out.println(p1.publishNewVideo("Tutorial Java", "123456"));
        // System.out.println(p1.publishNewVideo("Tutorial C#", "123456"));

        // s1.watch("Tutorial Java");

        Scanner sc = new Scanner(System.in);
        InterfaceUserController controller = new UserController(new UsersRepository());

        int opt = -1;

        printMenu();

        while (opt != 0) {
            opt = sc.nextInt();
            sc.nextLine();
            switch (opt) {
                case 0: {
                    sc.close();
                    System.out.println("Encerrando aplicação.");
                    break;
                }
                case 1: {
                    try {
                        controller.add();
                        System.out.println("Usuário cadastrado com sucesso.");
                    } catch (UserAlreadyExistsException e) {
                        System.out.println("Um usuário com esse email já existe.");
                    } catch (InvalidEmailException e) {
                        System.out.println("O email informado é inválido");
                    }
                    break;
                }
                case 2: {
                    try {
                        controller.rem();
                        System.out.println("Usuário removido com sucesso.");
                    } catch (UserDontExistsException e) {
                        System.out.println("Não existe esse usuário na base de dados.");
                    } catch (InvalidEmailException e) {
                        System.out.println("O email informado é inválido");
                    }
                    break;
                }
                case 3: {
                    try {
                        controller.edit();
                    } catch (UserDontExistsException e) {
                        System.out.println("Não existe esse usuário na base de dados.");
                    } catch (InvalidEmailException e) {
                        System.out.println("O email informado é inválido");
                    }
                    break;
                }
                case 10: {
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
        System.out.println("Digite 10 para exibir esse menu novamente.");
        System.out.println("Digite 0 para encerrar o programa.");
        System.out.println("----------------------------------------");
    }
}
