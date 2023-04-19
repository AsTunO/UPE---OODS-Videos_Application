package AnimalUPE;

public class Cachorro extends Animal {
    public void farejar() {
        System.out.println("O cachorro está farejando");
    }

    @Override
    public void emitirSom() {
        System.out.println("O cachorro está latindo");
    }

    public Cachorro(String nome) {
        setNome(nome);
    }
}
