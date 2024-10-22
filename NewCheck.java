package kassa1;

import java.util.Scanner;

public class NewCheck {
    public static void N() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Для продажи товара введите его артикул. Для выхода - esc");
            String line = scanner.nextLine();
            if (line.equals("esc")) break;

            try {
                System.out.println("Введите количество покупаемого товара данного артикула");
                String value = scanner.nextLine();
                
                int article = Integer.parseInt(line);
                int quantity = Integer.parseInt(value);
                
                // Предполагается, что Stock.Corect() - это метод для обработки продажи
                Stock.correct(false, article, quantity);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: пожалуйста, введите числовые значения для артикула и количества.");
            } catch (Exception e) {
                System.out.println("Произошла ошибка: " + e.getMessage());
            }
        }
        scanner.close(); // Закрываем сканер после завершения работы
    }
}