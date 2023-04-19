package Farmacia;

public class EstoqueWithoutProductsException extends Exception {

    public EstoqueWithoutProductsException() {
    }

    public EstoqueWithoutProductsException(String message) {
        super(message);
    }

}
