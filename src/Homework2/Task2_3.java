package Homework2;

import java.util.Scanner;

// Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. 
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
public class Task3_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String value = scan.nextLine();
        if (value.isEmpty())
            throw new IllegalArgumentException("Пустые строки вводить нельзя");
        else
            System.out.println(value);
    }
}
