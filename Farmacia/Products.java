package Farmacia;

import java.util.ArrayList;
import java.util.List;

public class Products {
    private List<Product> products = new ArrayList<Product>();

    public void addProduct(Product p) {
        try {
            products.add(p);
        } catch (Exception e) {
            throw e;
        }
    }

    public void removeProduct(Product p) {
        try {
            products.remove(p);
        } catch (Exception e) {
            throw e;
        }
    }

    public void listproducts() {
        if (products.isEmpty()) {
            System.out.println("Não existe nenhum produto cadastrado.");
            return;
        }

        System.out.println("----------------------------------------");
        System.out.println("| PRODUTO | PREÇO   | QUANTIDADE NO ESTOQUE | FORNECEDOR");
        System.out.println("----------------------------------------");
        Product a;
        for (int i = 0; i < products.size(); i++) {
            a = products.get(i);
            System.out.println("| "
                    + a.getDescricao() + " | R$ "
                    + a.getPreço() + " |"
                    + a.getEstoque() + " | "
                    + a.getFornecedor().getNome() + " | ");
        }
        System.out.println("----------------------------------------");
    }

    public Product searchProductByDescription(String description) {
        Product result = null;

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getDescricao().equals(description)) {
                result = products.get(i);
            }
        }

        return result;
    }
}
