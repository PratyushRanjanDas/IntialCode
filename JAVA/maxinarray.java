import java.util.Arrays;

public class maxinarray {
    public static void main(String[] args) {
        int[] arr ={1,3,5,6,89,9,0};
        System.out.println(Arrays.stream(arr).max());
        System.out.println(Arrays.stream(arr).sum());
        System.out.println(Arrays.stream(arr).min());



    }
}
