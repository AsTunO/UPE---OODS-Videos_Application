package Videos.Utilities;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.InputMismatchException;

public class Utils {
    static Scanner sc;

    public static void setScanner(Scanner s) {
        sc = s;
    }

    public static String inputStringField() {
        String field = "";

        do {
            System.out.print("> ");
            field = sc.nextLine();
            if (field == null || field == "")
                System.out.println("Entrada não pode ser vazia, tente novamente.\n");
        } while (field == null || field == "");

        return field;
    }

    public static int inputAgeField() {
        int field = 0;

        System.out.print("> ");
        do {
            field = sc.nextInt();
            sc.nextLine();
            if (field <= 0)
                System.out.println("A idade está inválida, tente novamente.\n");
        } while (field <= 0);

        return field;
    }

    public static String validateEmail(String email) {

        while (!email.contains("@")) {
            System.out.println("Email inserido não é válido, por favor, tente novamente.\n> ");
            email = sc.nextLine().strip().replace("\n", "");
            sc.nextLine();
        }

        return email;
    }

    public static Integer optionSelector() {
        int option = -1;
        List<Integer> validValues = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);

        while (true) {
            try {
                System.out.print("> ");
                option = sc.nextInt();
                sc.nextLine();

                if (validValues.contains(option)) {
                    return option;
                }

                System.out.println("Opção inválida, tente novamente.");

            } catch (InputMismatchException e) {
                System.out.println("A entrada precisa ser um inteiro.");
                option = -1;
                sc.nextLine();
            }
        }
    }

    public static boolean chooseYesOrNo() {
        boolean result = false;

        System.out.print("> ");

        if (sc.nextLine().equalsIgnoreCase("S")) {
            result = true;
        }

        return result;
    }
}
