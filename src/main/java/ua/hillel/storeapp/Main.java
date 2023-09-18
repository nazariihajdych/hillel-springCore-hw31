package ua.hillel.storeapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.hillel.storeapp.model.Product;
import ua.hillel.storeapp.repo.CartRepo;
import ua.hillel.storeapp.repo.ProductRepo;
import ua.hillel.storeapp.service.CartService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("ua.hillel.storeapp");

        Product product1 = new Product(1, "Tomatoes", 12.3D);
        Product product2 = new Product(2, "Pasta", 23.6D);
        Product product3 = new Product(3, "Oranges", 16.7D);
        Product product4 = new Product(4, "Apples", 23.5D);

        int totalProduct = 4;

        CartService cartService = context.getBean(CartService.class);
        ProductRepo productRepo = context.getBean(ProductRepo.class);
        CartRepo cartRepo = context.getBean(CartRepo.class);

        productRepo.addProductInRepo(product1);
        productRepo.addProductInRepo(product2);
        productRepo.addProductInRepo(product3);
        productRepo.addProductInRepo(product4);

        Scanner scanner = new Scanner(System.in);

        System.out.print("""
                        ********************
                        Welcome to our store!
                        ********************
                        We can offer you this kind of products:
                        """);
        for (Product pr: productRepo.getAllProducts()) {
            System.out.println(pr);
        }
        System.out.println("""
                        ********************
                        You can use this commands:
                        add - to add product, enter -> product id;
                        remove - to remove product, enter -> product id;
                        cart - to see all products in your cart;
                        exit - to left our store;
                        ********************
                        """);
        boolean exit = false;
            while (!exit) {
                System.out.print(">");
                String userChoice = scanner.nextLine();

                switch (userChoice) {
                    case "add" -> {
                        cartService.addProduct(getUserProductChoice(scanner, totalProduct));
                        System.out.println("Your product in cart;");
                    }
                    case "remove" -> {
                        if (cartRepo.getAllProductsInCart().isEmpty()){
                            System.out.println("Your cart is empty!");
                        }else {
                            cartService.removeProductById(getUserProductChoice(scanner, totalProduct));
                            System.out.println("Your product removed from cart;");
                        }
                    }
                    case "cart" -> {
                        System.out.println("Product in your cart:");
                        System.out.println("*********************");
                        if (cartRepo.getAllProductsInCart().isEmpty()){
                            System.out.println("Your cart is empty!");
                        }
                        for (Product pr: cartRepo.getAllProductsInCart()) {
                            System.out.println(pr);
                        }
                        System.out.println("*********************");
                    }
                    case "exit" -> {
                        System.out.println("Have a nice day!");
                        scanner.close();
                        exit = true;
                    }
                    default -> System.out.println("Wrong command! Try again.");
                }
            }

    }

    private static int getUserProductChoice(Scanner scanner, int totalProduct){
        int productNumber;
        while (true) {
            System.out.print(">Enter product id -> ");
            if (scanner.hasNextInt() && (productNumber = scanner.nextInt()) <= totalProduct) {
                scanner.nextLine();
                break;
            } else {
                System.out.println("Wrong id! Try again.");
                scanner.nextLine();
            }
        }
        return productNumber;
    }
}