package kassa1;

import java.util.Scanner;

public class Menu {
    public static void m() {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            Avtoriz.auto(); // Assuming this method exists in your Java code.
            
            System.out.println("Выберите действие:");
            System.out.println("1 - Прием поставки");
            System.out.println("2 - Информация о наличии товара на складе");
            System.out.println("3 - Возврат товара");
            System.out.println("4 - Продажа товара");
            System.out.println("5 - Выход");
            
            String line = scanner.nextLine();
            
            switch (line) {
                case "1":
                    Delivery.D();
                    break;
                case "2":
                    Search.S();
                    break;
                case "3":
                    Return.R();
                    break;
                case "4":
                    NewCheck.N();
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный ввод, попробуйте снова.");
                    break;
            }
            
            System.out.println(); // Adding a line for better readability.
        }
    }
}