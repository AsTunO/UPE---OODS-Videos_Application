package AnimalUPE;

public interface InterfaceAnimalCollection {

    public Animal search(String nome);

    public void add(Animal a) throws AnimalJaExisteException;

    public void remove(Animal a);

}