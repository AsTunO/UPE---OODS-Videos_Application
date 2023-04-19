package Bank;

import java.security.SecureRandom;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {
    public static String encodeString(String data) {
        String result = null;

        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
            md.update(salt);
            byte[] encodedData = md.digest(data.getBytes(StandardCharsets.UTF_8));
            result = encodedData.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void authenticate(String id, String passwd) {
        Account a = AccountCollection.findAccountById(id);
        String encodedPasswd = encodeString(passwd);

        if (encodedPasswd != a.getPassword()) {
            // throw new
        }
    }
}
