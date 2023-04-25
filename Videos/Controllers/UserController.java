package Videos.Controllers;

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
        User newUser;

        System.out.println("Digite o email do usuário:");
        String email = Utils.validateEmail(Utils.inputStringField());

        if (collection.searchByEmail(email) != null) {
            throw new UserAlreadyExistsException("Já existe um usuário com o email informado.");
        }

        System.out.println("Digite o nome do usuário:");
        String name = Utils.inputStringField();

        System.out.println("Digite a senha do usuário:");
        String password = Utils.inputStringField();

        System.out.println("Digite a idade do usuário:");
        int age = Utils.inputAgeField();

        System.out.println("Você deseja que esse usuário possa publicar vídeos?");
        System.out.println("Digite S para sim, qualquer outro caractere para não.");

        if (Utils.chooseYesOrNo()) {
            newUser = new Publisher(name, age, email, password);
        } else {
            newUser = new Spectator(name, age, email, password);
        }

        collection.addUser(newUser);
        System.out.println("Usuário adicionado com sucesso.");
    }

    public void rem() throws InvalidEmailException, UnauthorizedException {
        System.out.println("Digite o email do usuário a ser removido: ");
        String email = Utils.validateEmail(Utils.inputStringField());

        System.out.println("Digite a senha do usuário a ser removido: ");
        String password = Utils.inputStringField();

        User u = collection.searchByEmail(email);

        if (u == null || !(u.validatePassword(password))) {
            throw new UnauthorizedException("Dados inválidos.");
        }

        collection.remUser(u);
        System.out.println("Usuário removido com sucesso.");
    }

    public void edit() throws InvalidEmailException, UnauthorizedException {
        User oldUser, updatedUser;
        String name, email, pass;
        int age;

        System.out.println("Digite o email do usuário a ser alterado: ");
        email = Utils.validateEmail(Utils.inputStringField());
        System.out.println("Digite a senha do usuário: ");
        pass = Utils.inputStringField();

        oldUser = collection.searchByEmail(email);

        if (oldUser instanceof Publisher) {
            updatedUser = new Publisher(oldUser.getName(), oldUser.getAge(), oldUser.getEmail(), pass);
        } else {
            updatedUser = new Spectator(oldUser.getName(), oldUser.getAge(), oldUser.getEmail(), pass);
        }

        if (oldUser == null || !(oldUser.validatePassword(pass))) {
            throw new UnauthorizedException("Dados inválidos.");
        }

        System.out.println("\nDigite S para sim, qualquer outro caractere para não.");

        System.out.println("\nVocê deseja editar o email? ");
        if (Utils.chooseYesOrNo()) {
            do {
                System.out.println("Digite o novo email do usuário:");
                email = Utils.validateEmail(Utils.inputStringField());
                if (collection.searchByEmail(email) != null) {
                    System.out.println("Email já existente na base de dados, tente novamente.");
                }
            } while (collection.searchByEmail(email) != null);
            updatedUser.setEmail(email, pass);
        }

        System.out.println("\nVocê deseja editar o nome? ");
        if (Utils.chooseYesOrNo()) {
            System.out.println("Digite o novo nome do usuário:");
            name = Utils.inputStringField();
            updatedUser.setName(name, pass);
        }

        System.out.println("\nVocê deseja editar a senha? ");
        if (Utils.chooseYesOrNo()) {
            System.out.println("Digite a nova senha do usuário:");
            String newPassword = Utils.inputStringField();
            updatedUser.setPassword(newPassword, pass);
            pass = newPassword;
        }

        System.out.println("\nVocê deseja editar a idade? ");
        if (Utils.chooseYesOrNo()) {
            System.out.println("Digite a nova idade do usuário:");
            age = Utils.inputAgeField();
            updatedUser.setAge(age, pass);
        }

        collection.editUser(oldUser, updatedUser);
        System.out.println("Usuário editado com sucesso.");
    }

    public void watchVideo(User u, Video v) {
        collection.watchVideo(u, v);
    }

    public void listAllUsers() {
        if (collection.isEmpty()) {
            System.out.println("Não existe nenhum usuário no sistema.");
        } else {
            collection.listAllUsers();
        }
    }

    public User searchByEmail(String email) {
        return collection.searchByEmail(email);
    }

    public User authenticate() throws UnauthorizedException {
        System.out.println("Digite o email do usuário: ");
        String email = Utils.validateEmail(Utils.inputStringField());

        User u = searchByEmail(email);

        System.out.println("Digite a senha do usuário: ");
        String password = Utils.inputStringField();

        if (u == null || !(u.validatePassword(password))) {
            throw new UnauthorizedException();
        }

        return u;
    }
}
