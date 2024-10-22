package kassa1;

import java.util.List;
import java.util.Scanner;

public class Search {
    public static void S() {
        List<Product> products = Stock.readStock();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Для получения информации о количестве товара на складе введите его артикул. Для выхода - esc");
        String line = scanner.nextLine();
        
        if (!line.equals("esc")) {
            int stockAmount = 0;
            boolean found = false;
            
            for (Product product : products) {
                if (product.getArticle() == Integer.parseInt(line)) {
                    stockAmount = product.getStock();
                    found = true;
                    break;
                }
            }
            
            if (found) {
                System.out.println("На складе есть: " + stockAmount);
            } else {
                System.out.println("Товара с таким артикулом нет на складе");
            }
        }
    }
}