import java.util.Arrays;
public class CYCLICsort {
    public static int Csort(int[] arr)
    {
      int i =0;
      while(i< arr.length)
      {
        int ele = arr[i]-1;
          if (arr[i]!=arr[ele]) {
            arr[i]=arr[i]^arr[ele];
            arr[ele]=arr[i]^arr[ele];
            arr[i]=arr[i]^arr[ele];
          }
          else if(arr[ele]==-1)
              return i+1;
          else
              i++;
      }
      return 0;
    }
    public static void main(String[] args) {
    int[] arr ={3,5,2,1,4,8,6,7};
        Csort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
