package AnimalUPE;

public class Main {
    public static void main(String args[]) throws AnimalJaExisteException {
        InterfaceAnimalCollection collection = new AnimalCollection();

        Cachorro a1 = new Cachorro("Cachorro");
        Gato a2 = new Gato("Gato");
        Passaro a3 = new Passaro("Passaro");

        collection.add(a1);
        collection.add(a2);
        collection.add(a3);
    }
}
