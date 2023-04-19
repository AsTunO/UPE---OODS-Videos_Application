package Farmacia;

public class Medicamento extends Product {
    public Medicamento(String descriçao, int estoque, Double preço, Fornecedor fornecedor) {
        super(descriçao, estoque, preço, fornecedor);
        this.setDescontoMax(0.1);
    }
}
