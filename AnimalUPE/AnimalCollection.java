package AnimalUPE;

import java.util.List;
import java.util.ArrayList;

public class AnimalCollection implements InterfaceAnimalCollection {
    List<Animal> animais = new ArrayList<Animal>();

    public Animal search(String nome) {
        Animal result = null;

        for (int i = 0; i < animais.size(); i++) {
            if (animais.get(i).getNome().equals(nome)) {
                result = animais.get(i);
            }
        }

        return result;
    }

    public void add(Animal a) throws AnimalJaExisteException {
        try {
            if (search(a.getNome()) != null) {
                throw new AnimalJaExisteException("esse animal já existe na base de dados");
            }
            animais.add(a);
        } catch (Exception e) {
            throw e;
        }
    }

    public void remove(Animal a) {
        try {
            animais.remove(a);
        } catch (Exception e) {
            throw e;
        }
    }
}
