package Videos.Controllers;

import java.util.Scanner;
import Videos.Models.*;
import Videos.Repositories.*;
import Videos.Exceptions.*;
import Videos.Utilities.*;

public class UserController implements InterfaceUserController {
    private InterfaceUsersRepository collection;

    public UserController(UsersRepository repo) {
        this.collection = repo;
    }

    public void add() throws InvalidEmailException, UserAlreadyExistsException {
        Scanner sc = new Scanner(System.in);
        InterfaceUtils ut = new Utils();

        User newUser;
        String name = ut.inputStringField("nome", "usuário");
        String email = ut.inputStringField("email", "usuário");
        String password = ut.inputStringField("senha", "usuário");
        int age = ut.inputAgeField("idade", "usuário");

        while (collection.searchByEmail(email) != null) {
            System.out.println("Já existe uma conta com esse email, por favor, tente novamente.\n> ");
            email = sc.nextLine().strip().replace("\n", "");
            sc.nextLine();
        }

        System.out.println("Você deseja que esse usuário possa publicar vídeos?");
        System.out.println("Digite S para sim, qualquer outro caractere para não.");

        String option = sc.nextLine().strip().replace("\n", "");
        if (option.equalsIgnoreCase("S")) {
            newUser = new Publisher(name, age, email, password);
        } else {
            newUser = new Spectator(name, age, email, password);
        }
        System.out.println("Usuário adicionado com sucesso.");
        sc.close();

        try {
            collection.addUser(newUser);
        } catch (UserAlreadyExistsException e) {
            throw e;
        }
    }

    @Override
    public void rem() throws InvalidEmailException, UserDontExistsException {
        Scanner sc = new Scanner(System.in);
        InterfaceUtils ut = new Utils();

        System.out.println("Digite o email do usuário a ser removido: ");
        String email = ut.inputStringField();

        sc.nextLine();

        while (collection.searchByEmail(email) == null) {
            System.out.println("Não existe uma conta com esse email, por favor, tente novamente.\n> ");
            email = sc.nextLine().strip().replace("\n", "");
            sc.nextLine();
        }

        sc.close();

        User u = collection.searchByEmail(email);
        try {
            collection.remUser(u);
            System.out.println("Usuário removido com sucesso.");
        } catch (UserDontExistsException e) {
            System.out.println("O usuário que você tentou remover não existe no banco de dados.");
        }
    }

    @Override
    public void edit() throws InvalidEmailException, UserDontExistsException {
        Scanner sc = new Scanner(System.in);
        InterfaceUtils ut = new Utils();

        User u;
        String name, email, pass;
        int age;

        System.out.println("Digite o email do usuário a ser alterado: ");
        email = ut.validateEmail(ut.inputStringField());
        System.out.println("Digite a senha do usuário: ");
        pass = ut.inputStringField();
        while (collection.searchByEmail(email) == null
                || collection.searchByEmail(email).validatePassword(pass)) {
            System.out.println("Dados inválidos, por favor, tente novamente.\n> ");
            email = ut.validateEmail(ut.inputStringField());
            pass = ut.inputStringField();
        }

        u = collection.searchByEmail(email);

        System.out.println("\nDigite S para sim, qualquer outro caractere para não.");
        System.out.println("\nVocê deseja editar o email? ");
        if (sc.nextLine().strip().replace("\n", "").equalsIgnoreCase("S")) {
            do {
                email = ut.validateEmail(ut.inputStringField("email", "usuário"));
                if (collection.searchByEmail(email) != null) {
                    System.out.println("Email já existente na base de dados, tente novamente.");
                }
            } while (collection.searchByEmail(email) != null);
            u.setEmail(email, pass);
        }
        sc.nextLine();

        System.out.println("\nVocê deseja editar o nome? ");
        if (sc.nextLine().strip().replace("\n", "").equalsIgnoreCase("S")) {
            name = ut.inputStringField("nome", "usuário");
            u.setName(name, pass);
        }
        sc.nextLine();

        System.out.println("\nVocê deseja editar a senha? ");
        if (sc.nextLine().strip().replace("\n", "").equalsIgnoreCase("S")) {
            String newPassword = ut.inputStringField("senha", "usuário");
            u.setPassword(newPassword, pass);
            pass = newPassword;
        }
        sc.nextLine();

        System.out.println("\nVocê deseja editar a idade? ");
        if (sc.nextLine().strip().replace("\n", "").equalsIgnoreCase("S")) {
            age = ut.inputAgeField("idade", "usuário");
            u.setAge(age, pass);
        }
        sc.nextLine();
        sc.close();

        collection.editUser(u);
        System.out.println("Usuário editado com sucesso.");
    }

    @Override
    public void watchVideo() throws InvalidEmailException, UserDontExistsException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'watchVideo'");
    }

    @Override
    public void listHistory() throws InvalidEmailException, UserDontExistsException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listHistory'");
    }

    @Override
    public void publishVideo() throws InvalidEmailException, UserDontExistsException, UserNotPublisherException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'publishVideo'");
    }

    @Override
    public void deleteVideo() throws InvalidEmailException, UserDontExistsException, UserNotPublisherException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteVideo'");
    }

    @Override
    public void editVideo() throws InvalidEmailException, UserDontExistsException, UserNotPublisherException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editVideo'");
    }

    @Override
    public void searchVideos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchVideos'");
    }
}
