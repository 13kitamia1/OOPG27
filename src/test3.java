import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class test3 {
    public static void test() {
        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader("nuser.csv"));
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(",");
                if (lines[0].equals("c1"))
                    System.out.println(lines[0] + " " + lines[1]);
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }
    public static void main(String[] args) {
     test();
    }
}
