public class nonduplicate {
    public static void main(String[] args) {
        int[] arr ={2,3,8,4,1,2,1,3,6,4,8,5,5};
        System.out.println(nodupe(arr));

    }

   public static int nodupe(int[] arr) {
        int single=0;
       for (int te : arr) {
           single^= te ;
       }
       return single;
        }
    }

