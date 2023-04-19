package Farmacia;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> cart = new ArrayList<Product>();

    public void addProduct(Product p) throws EstoqueWithoutProductsException {
        try {
            if (p.getEstoque() <= 0) {
                throw new EstoqueWithoutProductsException();
            }
            p.setEstoque(p.getEstoque() - 1);
            cart.add(p);
        } catch (Exception e) {
            throw e;
        }
    }

    public void removeProduct(Product p) {
        try {
            p.setEstoque(p.getEstoque() + 1);
            cart.remove(p);
        } catch (Exception e) {
            throw e;
        }
    }

    public int cartSize() {
        return cart.size();
    }

    public Product searchProductByDescription(String description) {
        Product result = null;

        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getDescricao().equals(description)) {
                result = cart.get(i);
            }
        }

        return result;
    }

    public Double listCart() {
        Double total = null;
        if (cart.isEmpty()) {
            System.out.println("O carrinho está vazio.");
            return total;
        }

        System.out.println("----------------------------------------");
        System.out.println("| PRODUTO | PREÇO   | FORNECEDOR       | ");
        System.out.println("----------------------------------------");
        Product a;
        total = 0.0;
        for (int i = 0; i < cart.size(); i++) {
            a = cart.get(i);
            System.out.println("| "
                    + a.getDescricao() + " | R$ "
                    + a.getPreço() + " |"
                    + a.getFornecedor().getNome() + " | ");
            if (cart.size() >= 10) {
                total += a.getPreço() - a.getPreço() * a.getDescontoMax();
            } else if (cart.size() >= 5) {
                total += a.getPreço() - a.getPreço() * (a.getDescontoMax() / 2);
            } else {
                total += a.getPreço();
            }
        }

        return total;
    }

    public void executeSell(Client c) {
        if (cart.isEmpty()) {
            System.out.println("O carrinho está vazio.");
            return;
        }

        Double total;

        System.out.println("----------------------------------------");
        System.out.println("| CPF CLIENTE: " + c.getCpf() + " | ");
        System.out.println("| DATA DA COMPRA: " + new Date() + " | ");
        System.out.println("----------------------------------------");
        if (cart.size() >= 4) {
            System.out.println("----------------------------------------");
            System.out.println("|       VOCÊ RECEBEU UM DESCONTO!!!    |");
            System.out.println("----------------------------------------");
        }
        total = listCart();
        System.out.println("----------------------------------------");
        System.out.println("| TOTAL = R$ " + total + " | ");
    }

    public void clearCart() {
        cart.clear();
    }
}
