package HomeWork3;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

// Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, 
// разделенные пробелом: Фамилия Имя Отчество датарождения номертелефона пол
public class AppExceptions {

    private static void checkExceptions(String[] ar) {

        if (ar.length != 6) {
            System.err.println("Ошибка: неверное количество введенных данных!");
            return;
        }
        Boolean isMobNumber = false;
        try {
            isMobNumber = checkMobNumber(ar[4]);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: неверный формат моб. номера." + ar[4]);
            return;
        }
        Boolean isDate = false;
        isDate = checkDate(ar[3]);
        if (!isDate) {
            return;
        }

        Boolean isGender = false;
        try {
            isGender = checkGender(ar[5]);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: неверный пол." + ar[5]);
            return;
        }

        boolean isLetter = false;
        try {
            isLetter = checkLetters(ar);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: неверное ФИО -> " + ar[0] + " " + ar[1] + " " + ar[2]);
            return;
        }

        writeToFile(ar);

    }

    private static void writeToFile(String[] array) {
        String data = "<" + array[0] + ">" + "<" + array[1] + ">" + "<" + array[2] + ">" + "<" + array[3] + ">" + "<"
                + array[4] + ">"
                + "<" + array[5] + ">";
        String fileName = array[0] + ".txt";
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(data + System.lineSeparator());
            System.out.println("Данные успешно записаны в файл -> " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + fileName);
            e.printStackTrace();
        }
    }

    private static Boolean checkDate(String bdate) {
        LocalDate date;
        LocalDate minDate = LocalDate.parse("01.01.1950", DateFormatter.getFormatter());
        LocalDate maxDate = LocalDate.now();// LocalDate.parse("2015.01.01", DateFormatter.getFormatter());
        try {
            date = LocalDate.parse(bdate, DateFormatter.getFormatter());
        } catch (DateTimeParseException e) {
            System.err.println("Ошибка: неверный формат даты рождения.");
            return false;
        }

        if (!(date.isAfter(minDate) && date.isBefore(maxDate))) {
            System.err.println("Ошибка: дата рождения вне диапазона.");
            return false;
        }
        return true;
    }

    private static Boolean checkMobNumber(String numb) {
        String regex = "(0/91)?[0-9][0-9]{9}";
        try {
            Long mobnum;
            mobnum = Long.parseLong(numb);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: неверный формат моб. номера." + numb);
            return false;
        }

        if (!numb.matches(regex)) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private static Boolean checkGender(String value) {
        if (!(Gender.f.toString().equalsIgnoreCase(value) || Gender.m.toString().equalsIgnoreCase(value))) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private static class DateFormatter {
        private static final String DATEFORMAT = "dd.MM.yyyy";

        public static DateTimeFormatter getFormatter() {
            return java.time.format.DateTimeFormatter.ofPattern(DATEFORMAT);
        }

    }

    private static boolean checkLetters(String[] arr) {
        if (!(arr[0].matches("[a-zA-Zа-яА-Я]+") && arr[1].matches("[a-zA-Zа-яА-Я]+")
                && arr[2].matches("[a-zA-Zа-яА-Я]+"))) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private enum Gender {
        m, f;
    }

    public static void main(String[] args) {
        System.out.println(
                "Введите данные через пробел:  Фамилия Имя Отчество ДатаРождения(xx.xx.xxxx (1950 - NOW))  НомерТелефона(xxxxxxxxxx) Пол:(m/f) ");
        try (Scanner scan = new Scanner(System.in)) {
            String value = scan.nextLine();
            AppExceptions.checkExceptions(value.split(" "));
        }
    }
}