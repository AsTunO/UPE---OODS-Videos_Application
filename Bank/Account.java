package Bank;

public class Account {
    private String id;
    private String password = "";
    private Double wallet = 0.0;

    public Account(String id) {
        setId(id);
    }

    public Account(String id, String passwd) {
        setId(id);
        setPassword(passwd);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setWallet(Double value) {
        this.wallet = value;
    }

    public Double getWallet() {
        return wallet;
    }

    public void setPassword(String passwd) {
        this.password = Utils.encodeString(passwd);
    }

    public String getPassword() {
        return this.password;
    }

    public void deposit(Double value) throws ValueInvalidException {
        try {
            if (value <= 0) {
                throw new ValueInvalidException();
            }
            this.wallet += value;
        } catch (Exception e) {
            throw e;
        }
    }

    public void withdraw(Double value, String passwd) throws ValueInvalidException {
        try {

            if (value >= 0) {
                throw new ValueInvalidException();
            }
            this.wallet -= value;
        } catch (Exception e) {
            throw e;
        }
    }
}