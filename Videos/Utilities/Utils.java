package Videos.Utilities;

import java.util.Scanner;

public class Utils implements InterfaceUtils {

    public String inputStringField() {
        Scanner sc = new Scanner(System.in);
        String field = "";

        System.out.println("> ");

        do {
            field = sc.nextLine().strip().replace("\n", "");
            sc.nextLine();
            if (field == null || field == "")
                System.out.println("Entrada não pode ser vazia, tente novamente.\n");
        } while (field == null || field == "");

        sc.close();
        return field;
    }

    public String inputStringField(String fieldName) {
        Scanner sc = new Scanner(System.in);
        String field = "";

        System.out.println("Digite o " + fieldName + ": ");
        do {
            field = sc.nextLine().strip().replace("\n", "");
            sc.nextLine();
            if (field == null || field == "")
                System.out.println("Entrada não pode ser vazia, tente novamente.\n");
        } while (field == null || field == "");

        sc.close();
        return field;
    }

    public String inputStringField(String fieldName, String location) {
        Scanner sc = new Scanner(System.in);
        String field = "";

        System.out.println("Digite o " + fieldName + " do " + location + ": ");
        do {
            field = sc.nextLine().strip().replace("\n", "");
            sc.nextLine();
            if (field == null || field == "")
                System.out.println("Entrada não pode ser vazia, tente novamente.\n");
        } while (field == null || field == "");

        sc.close();
        return field;
    }

    public int inputAgeField(String fieldName, String location) {
        Scanner sc = new Scanner(System.in);
        int field = 0;

        System.out.println("Digite o " + fieldName + " do " + location + ": ");
        do {
            field = sc.nextInt();
            sc.nextLine();
            if (field <= 0)
                System.out.println("A idade está inválida, tente novamente.\n");
        } while (field <= 0);

        sc.close();
        return field;
    }

    public String validateEmail(String email) {
        Scanner sc = new Scanner(System.in);

        while (!email.contains("@")) {
            System.out.println("Email inserido não é válido, por favor, tente novamente.\n> ");
            email = sc.nextLine().strip().replace("\n", "");
            sc.nextLine();
        }

        sc.close();
        return email;
    }
}
