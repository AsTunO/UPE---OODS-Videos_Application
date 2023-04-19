package Farmacia;

public abstract class Product {
    private String descricao;
    private int estoque;
    private Double preço;
    private Double descontoMax;
    private Fornecedor fornecedor;

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Product(String descriçao, int estoque, Double preço, Fornecedor fornecedor) {
        setDescricao(descriçao);
        setEstoque(estoque);
        setPreço(preço);
        setFornecedor(fornecedor);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public Double getPreço() {
        return preço;
    }

    public void setPreço(Double preço) {
        this.preço = preço;
    }

    public Double getDescontoMax() {
        return descontoMax;
    }

    public void setDescontoMax(Double descontoMax) {
        this.descontoMax = descontoMax;
    }
}
