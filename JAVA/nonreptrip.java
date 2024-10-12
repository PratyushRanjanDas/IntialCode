import java.sql.SQLOutput;

public class nonreptrip {
    public static void main(String[] args) {
        int arr[] = {1,4,2,3,3,2,3,1,2,1};
        int sum = 0;
        for (int i = 0; i < arr.length ; i++) {

            int[] zrr = DECIMALtoBINARY.DTB(arr[i]);
            sum+=zrr[i];
        }
        System.out.println(sum);
        int ans =sum%3;
        System.out.println(ans);
    }
}
