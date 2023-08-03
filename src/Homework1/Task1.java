package Homework1;

public class Task1 {

    public static void main(String[] args) {
        // int x = 0;
        // x = 7 / 0;

        // System.out.println(x + "\n");

        // int[] array = { 1, 2, 3, 4 };
        // System.out.println(array[5]);
        // String s = "A5";
        // int i = 0;
        // i = Integer.parseInt(s);
        int[] a = {};
        int[] b = {};

        a = new int[] { 12, 8, 16 };
        b = new int[] { 4, 2, 4 };

        if (a.length != b.length) {
            int[] c = {};
            System.out.println("[0]");
        } else {
            int[] c = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                c[i] = a[i] / b[i];
            }
            System.out.printf("[ %d, %d, %d ]", c[0], c[1], c[2]);
        }

    }
}
