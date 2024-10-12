public class RC_linearSearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 89, 9, 0};
        System.out.println(lins(arr,0,79));
    }

    public static int lins(int[] arr, int i, int target) {
        if (i == arr.length) {
            return  -1;
        }
        if (arr[i] == target)
            return i+1;
        return lins(arr,i+1,target);
    }

}
