package Homework2;

import java.util.Scanner;

// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), 
// и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, 
// вместо этого, необходимо повторно запросить у пользователя ввод данных.
public class Task2 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            try {
                double data;
                Scanner input = new Scanner(System.in);
                System.out.print("Enter  data: ");
                data = input.nextFloat();
                System.out.print(data + "\n");
            } catch (Exception e) {
                System.out.print("Enter data double value!\n");
            }
        }
    }
}
