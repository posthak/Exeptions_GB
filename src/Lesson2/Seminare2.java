
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Seminare2 {

    public static List<String[]> myReader(String filepath) {
        try {
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            List<String[]> reader = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] r = line.split("=");
                reader.add(r);
            }
            return reader;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String[]> checkArray(List<String[]> list) {

        for (String[] strings : list) {
            if (strings[1].equals("?")) {
                strings[1] = Integer.toString(strings[0].length());
            }
        }

        return list;
    }

    public static void myWriter(List<String[]> list, String filepath) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));
            for (String[] strings : list) {
                bw.write(strings[0] + "=" + strings[1] + "\n");
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String filepath = "test.txt";
        List<String[]> l = myReader(filepath);
        myWriter(checkArray(l), filepath);
        // for (String[] strings : checkArray(l)) {
        // System.out.println(strings[0] + "=" + strings[1] + "\n");
        // }
    }
}
