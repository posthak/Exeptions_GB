package Homework2;

import java.io.FileNotFoundException;

// Дан следующий код, исправьте его там, где требуется (задание 3)
public class Task2_2_2 {

    public static void main(String[] args) throws Exception {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 9);
            int[] abc = { 1, 2, 1 };
            abc[3] = 9;

        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
            return;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
            return;
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
        System.out.println("!!!!");
    }

    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }
}
