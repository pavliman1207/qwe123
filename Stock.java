package kassa1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Stock {

    public static List<Product> readStock() {
        List<Product> products = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\1\\Desktop\\dbStock.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                int art = Integer.parseInt(line);
                int st = Integer.parseInt(reader.readLine());

                Product product = new Product();
                product.setArticle(art);
                product.setStock(st);

                products.add(product);
            }

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Ошибка формата данных: " + e.getMessage());
        }

        return products;
    }

    public static void writeStock(List<Product> products) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\\\Users\\\\1\\\\Desktop\\\\dbStock.txt"))) {

            for (Product product : products) {
                writer.write(String.valueOf(product.getArticle()));
                writer.newLine();
                writer.write(String.valueOf(product.getStock()));
                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    public static void correct(boolean type, int art, int value) {
        List<Product> products = readStock();

        if (type) { // Adding stock
            boolean found = false;

            for (Product product : products) {
                if (product.getArticle() == art) {
                    product.setStock(product.getStock() + value);
                    found = true;
                    break;
                }
            }

            if (!found) { // If not found, add a new product
                Product newProduct = new Product();
                newProduct.setArticle(art);
                newProduct.setStock(value);
                products.add(newProduct);
            }

        } else { // Selling stock
            boolean found = false;

            for (Product product : products) {
                if (product.getArticle() == art) {
                    if (product.getStock() >= value) {
                        product.setStock(product.getStock() - value);
                        found = true;
                    } else {
                        System.out.println("Недостаточно товара на складе для продажи.");
                        return; // Выход из метода, если недостаточно товара
                    }
                    break;
                }
            }

            if (!found) { // If not found, notify user
                System.out.println("Товара с таким артикулом нет на складе");
            }
        }

        writeStock(products); // Save changes to file
    }
}