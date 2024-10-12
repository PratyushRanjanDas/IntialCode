import java.util.Scanner;
public class sqrt_Rt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = 1;
        System.out.println("enter the no(if it don't have non decimal sqrt it print error):");
        int high=sc.nextInt();
        int s = high;
        double incr=0.1;
        double root=0.0;
        while (low <= high) {
            int mid = low + ((high - low) >>> 1);
            if (mid * mid < s)
                low = mid + 1;
            else if (mid * mid > s)
                high = mid - 1;
            else {
                System.out.println("the sqrt: " + mid);
                break;
            }
        }
        for (int i = 0; i < 4 ; i++) {
            while (root*root <= s)
                root+=incr;
        }
        root-=incr;
        incr/=10;
        System.out.printf("the sqrt: %.2f",root);

    }

}
