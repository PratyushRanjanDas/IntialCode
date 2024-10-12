import java.util.Scanner;

public class loopmult {
    public static void main(String[] args) {
        int mul,n;
        Scanner wl= new Scanner(System.in);
        System.out.println("enter n");
        n = wl.nextInt();
        System.out.println(n);
        int i =1;
        while (i<=10){
            System.out.println(n +  "*" + i + "=" + n*i);
            i++;
        }
    }
}
