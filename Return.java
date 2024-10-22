package kassa1;

import java.util.Scanner;

public class Return {
    public static void R() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Для возврата товара введите его артикул. Для выхода - esc");
            String line = scanner.nextLine();
            if (line.equals("esc")) break;

            System.out.println("Введите количество возвращаемого товара данного артикула");
            String value = scanner.nextLine();
            Stock.correct(true, Integer.parseInt(line), Integer.parseInt(value));
        }
    }
}