package AnimalUPE;

public class Gato extends Animal {
    public void lamber() {
        System.out.println("O gato está farejando");
    }

    @Override
    public void emitirSom() {
        System.out.println("O gato está miando");
    }

    public Gato(String nome) {
        setNome(nome);
    }
}
