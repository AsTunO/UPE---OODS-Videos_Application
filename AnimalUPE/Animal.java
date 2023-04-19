package AnimalUPE;

public abstract class Animal {
    private String Nome;

    public String getNome() {
        return Nome;
    }

    public void setNome(String n) {
        this.Nome = n;
    }

    public void comer() {
        System.out.println("O animal está comendo");
    }

    public void andar() {
        System.out.println("O animal está andando");
    }

    public void emitirSom() {
        System.out.println("O animal está emitindo som");
    }
}