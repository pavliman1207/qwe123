package kassa1;

import java.util.Scanner;

public class Delivery {
    public static void D() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Для приема поставки товара введите его артикул. Для выхода - esc");
            String line = scanner.nextLine();
            if (line.equals("esc")) break;

            System.out.println("Введите количество приехавшего товара данного артикула");
            String value = scanner.nextLine();
            Stock.correct(true, Integer.parseInt(line), Integer.parseInt(value));
        }
    }
}