import java.util.Arrays;
import java.util.Scanner;
import java.lang.*;
public class arrayofobject {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] str = new String[3];
        System.out.println("enter 3 string");
        for (int i = 0; i < str.length ; i++) {
            str[i] = s.next();
        }
        System.out.println(Arrays.toString(str));
    }
}
