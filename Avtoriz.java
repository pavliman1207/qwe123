package kassa1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Avtoriz {

    public static List<Employee> readEmployee() {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\\\Users\\\\1\\\\Desktop\\\\dbEmployee.txt"))) {
            String login;
            while ((login = reader.readLine()) != null) {
                String password = reader.readLine();
                Employee employee = new Employee();
                employee.setLogin(login);
                employee.setPassword(password);
                employees.add(employee);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении данных сотрудников: " + e.getMessage());
        }
        return employees;
    }

    public static void writeEmployee(List<Employee> employees) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\1\\Desktop\\dbEmployee.txt"))) {
            for (Employee employee : employees) {
                writer.write(employee.getLogin());
                writer.newLine();
                writer.write(employee.getPassword());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи данных сотрудников: " + e.getMessage());
        }
    }

    public static void newEmployee() {
        List<Employee> employees = readEmployee();
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Для создания нового сотрудника введите логин. Для выхода - esc");
            try {
                String line1 = consoleReader.readLine();
                if (line1.equals("esc")) break;

                boolean exists = employees.stream().anyMatch(emp -> emp.getLogin().equals(line1));
                if (exists) {
                    System.out.println("Сотрудник с таким логином уже есть в базе");
                } else {
                    Employee newEmployee = new Employee();
                    newEmployee.setLogin(line1);
                    newEmployee.generateNewPassword();
                    System.out.println("Пароль нового сотрудника: " + newEmployee.getPassword());
                    employees.add(newEmployee);
                }
            } catch (IOException e) {
                System.out.println("Ошибка ввода: " + e.getMessage());
            }
        }
        writeEmployee(employees);
    }

    public static void auto() {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Введите логин сотрудника:");
            try {
                String login = consoleReader.readLine();
                List<Employee> employees = readEmployee();
                Employee foundEmployee = employees.stream()
                        .filter(emp -> emp.getLogin().equals(login))
                        .findFirst()
                        .orElse(null);

                if (foundEmployee == null) {
                    System.out.println("Сотрудника с таким логином не существует");
                    System.out.println("1 - создать нового сотрудника");
                    System.out.println("2 - повторить авторизацию");
                    String option = consoleReader.readLine();
                    if (option.equals("1")) {
                        newEmployee();
                    }
                } else {
                    System.out.println("Введите пароль сотрудника:");
                    String passwordInput = consoleReader.readLine();

                    if (passwordInput.equals(foundEmployee.getPassword())) {
                        break; // Успешная авторизация
                    } else {
                        System.out.println("Пароль не верен");
                        System.out.println("1 - повторить авторизацию");
                        System.out.println("2 - запросить новый пароль");
                        String option = consoleReader.readLine();

                        if (option.equals("2")) {
                            foundEmployee.generateNewPassword();
                            System.out.println("Пароль нового сотрудника: " + foundEmployee.getPassword());
                            writeEmployee(employees);
                            break; // Завершение после изменения пароля
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Ошибка ввода: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // Пример использования
        auto(); // Запуск процесса авторизации
    }
}
    