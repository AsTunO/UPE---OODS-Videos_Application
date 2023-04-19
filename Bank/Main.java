package Bank;

import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        AccountCollection.addAccount(new Account("123456"));
        AccountCollection.addAccount(new Account("012345"));
        AccountCollection.addAccount(new Account("123457", "123"));

    }
}
