import java.util.*;

public class subsetiteration {
    public static void main(String[] args) {
        int arr[]={1,4,2};
        List<List<Integer>> ans = SUBSET(arr);
        for (List<Integer> list : ans)
            System.out.println(list);
    }
    static List<List<Integer>> SUBSET(int arr[])
    {
        Arrays.sort(arr);
        List<List<Integer>> out = new ArrayList<>();
        int s = 0;
        int e = 0;
        for (int i = 0; i < arr.length; i++) {
            s =0;
            e=0;
            if (i>0 && arr[i]==arr[i-1]) s=e+1;
            e= out.size()-1;
            int n = out.size();
            for (int j = s; j <n ; j++) {
                List<Integer> in = new ArrayList<>(out.get(j));
                in.add(arr[i]);
                out.add(in);
            }

        }
        return out;
    }
}
