package Farmacia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws EstoqueWithoutProductsException {
        Scanner sc = new Scanner(System.in);

        Cart cart = new Cart();
        Products productsCollection = new Products();

        // Produtos já pré-cadastrados para testes
        Product xarope = new Medicamento("xarope", 2, 29.90, new Fornecedor("Jontex"));
        Product esmalte = new Cosmetico("esmalte", 100, 4.5, new Fornecedor("Esmaltec"));
        productsCollection.addProduct(xarope);
        productsCollection.addProduct(esmalte);

        // Carrinho já pré estabelecido para teste
        cart.addProduct(xarope);
        cart.addProduct(xarope);
        cart.addProduct(esmalte);
        cart.addProduct(esmalte);
        cart.addProduct(esmalte);

        printMenu();

        int opt = -1;
        while (opt != 0) {
            System.out.print("Digite uma opção: ");
            opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {
                case 1: {
                    String name, fornName;
                    int storage = 0, productType = 0;
                    Double price = 0.0;
                    Product p = null;

                    System.out.print("Digite uma descrição para o produto: ");
                    name = sc.nextLine().replace("\n", "");

                    while (storage <= 0) {
                        System.out.print("Digite a sua quantidade no estoque: ");
                        storage = sc.nextInt();
                        sc.nextLine();
                        if (storage <= 0)
                            System.out.println("Entrada inválida");
                    }

                    while (price <= 0.0) {
                        System.out.print("Digite o preço unitário do produto: ");
                        price = Double.parseDouble(sc.nextLine().replace("\n", ""));
                        if (price <= 0.0)
                            System.out.println("Entrada inválida");
                    }

                    System.out.print("Digite o nome do fornecedor: ");
                    fornName = sc.nextLine().replace("\n", "");

                    while (productType != 1 && productType != 2) {
                        System.out.print("Digite o tipo do produto [1- para medicamento e 2- para cosmetico]: ");
                        productType = sc.nextInt();
                        sc.nextLine();
                        if (productType != 1 && productType != 2)
                            System.out.println("Entrada inválida");
                    }

                    if (productType == 1) {
                        p = new Medicamento(name, storage, price, new Fornecedor(fornName));
                    } else {
                        p = new Cosmetico(name, storage, price, new Fornecedor(fornName));
                    }
                    productsCollection.addProduct(p);
                    System.out.println("Produto cadastrado com sucesso.\n");

                    break;
                }

                case 2: {
                    productsCollection.listproducts();
                    break;
                }

                case 3: {
                    System.out.print("Digite o nome do produto que deseja adicionar ao carrinho: ");
                    String name = sc.nextLine().replace("\n", "");
                    Product p = productsCollection.searchProductByDescription(name);

                    if (p == null) {
                        System.out.println("Esse produto não está cadastrado");
                    } else {
                        cart.addProduct(p);
                    }
                    break;
                }

                case 4: {
                    cart.listCart();
                    break;
                }

                case 5: {
                    if (cart.cartSize() > 0) {
                        System.out.print("Digite o cpf do cliente");
                        String cpf = sc.nextLine().replace("\n", "");
                        Client c = new Client(cpf);

                        cart.executeSell(c);
                        cart.clearCart();
                    } else {
                        System.out.println("O carrinho está vazio.");
                    }
                }

                case 6: {
                    System.out.print("Digite o nome do produto que você deseja remover: ");
                    String name = sc.nextLine().replace("\n", "");
                    Product p = productsCollection.searchProductByDescription(name);

                    if (p != null) {
                        productsCollection.removeProduct(p);
                    } else {
                        System.out.println("Esse produto não está cadastrado.");
                    }

                }

                case 7: {
                    System.out.print("Digite o nome do produto que você deseja remover do carrinho: ");
                    String name = sc.nextLine().replace("\n", "");
                    Product p = cart.searchProductByDescription(name);

                    if (p != null) {
                        cart.removeProduct(p);
                    } else {
                        System.out.println("Esse produto não está no carrinho.");
                    }

                }

                case 9: {
                    printMenu();
                }

                case 0: {
                    sc.close();
                    break;
                }
            }
        }
    }

    public static void printMenu() {
        System.out.println("----------------------------------------");
        System.out.println("Digite 1 para cadastrar um novo produto.");
        System.out.println("Digite 2 para listar os produtos cadastrados");
        System.out.println("Digite 3 para adicionar um produto ao carrinho");
        System.out.println("Digite 4 para listar os itens do carrinho");
        System.out.println("Digite 5 para comprar os itens do carrinho");
        System.out.println("Digite 6 para remover um produto cadastrado.");
        System.out.println("Digite 7 para remover um produto do carrinho.");
        System.out.println("Digite 9 para exibir esse menu novamente.");
        System.out.println("Digite 0 para encerrar o programa.");
        System.out.println("----------------------------------------");
    }
}
