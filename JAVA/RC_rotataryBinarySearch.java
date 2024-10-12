public class RC_rotataryBinarySearch {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,8,9,1,2,3};
        System.out.println(lins(arr, 0, arr.length, 8));
        int ans=RC_linearSearch.lins(arr,0,9);
        System.out.println(ans);
    }

    static int lins(int[] arr, int start, int end, int target) {
        if (start >= end)
            return -1;
        int mid=start+(end-start)>>>1;
        if(arr[mid]==target)
            return mid+1;
        if (arr[start] <= arr[mid])
        {
            if(arr[start]<=target && arr[mid]>=target)
                return lins(arr, start,  mid-1,  target);
            else
                return lins(arr, mid+1,  end,  target);
        }
        else
        {
            if (arr[mid] <= target &&  arr[end] >= target)
                return lins(arr, mid+1,  end,  target);
            else
                return lins(arr, start,  mid-1,  target);
        }

    }
}
