package Bank;

import java.util.ArrayList;
import java.util.List;

public class AccountCollection {
    private static List<Account> collection = new ArrayList<Account>();

    public static void addAccount(Account newAccount) {
        try {
            collection.add(newAccount);
        } catch (Exception e) {
            throw e;
        }
    }

    public static Account findAccountById(String id) {
        Account resultAccount = null;

        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).getId() == id) {
                resultAccount = collection.get(i);
            }
        }

        return resultAccount;
    }
}
