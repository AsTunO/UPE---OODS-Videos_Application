package AnimalUPE;

public class Passaro extends Animal {
    public void voar() {
        System.out.println("O passaro está voando");
    }

    public void bicar() {
        System.out.println("O passaro está bicando");
    }

    @Override
    public void emitirSom() {
        System.out.println("O passaro está cantando");
    }

    public Passaro(String nome) {
        setNome(nome);
    }
}
