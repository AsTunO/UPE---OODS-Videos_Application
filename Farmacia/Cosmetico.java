package Farmacia;

public class Cosmetico extends Product {
    public Cosmetico(String descriçao, int estoque, Double preço, Fornecedor fornecedor) {
        super(descriçao, estoque, preço, fornecedor);
        this.setDescontoMax(0.2);
    }
}
