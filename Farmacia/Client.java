package Farmacia;

public class Client {
    private String cpf;

    Client(String cpf) {
        setCpf(cpf);
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        cpf.trim();
        cpf.replace(".", "");
        cpf.replace("-", "");
        this.cpf = cpf;
    }
}
