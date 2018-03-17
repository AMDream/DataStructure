package swordoffer.chapter6;

/**
 * Created by Dream on 2018/3/14.
 */
public class Interview38 {
    public static void main(String[] args){
        int[] arr = {1,2,3,3,3,3};
        int num = GetNumberOfK(arr,3);
        System.out.println(num);
    }
        public static int GetNumberOfK(int [] array , int k) {
            if(array == null || array.length == 0)
                return 0;
            int begin = GetFirstK(array,0,array.length-1,k);
            int end = GetLastK(array,0,array.length-1,k);
            if(begin == -1 || end == -1)
                return 0;
            return end-begin+1;
        }
        private static int GetFirstK(int[] arr,int begin,int end,int k){
            if(begin > end){
                return -1;
            }
            int mid = (begin+end)/2;
            if(arr[mid] == k){
                if(mid == begin || arr[mid] != arr[mid-1])
                    return mid;
                else if(arr[mid] == arr[mid-1])
                    end = mid-1;
            }else if(arr[mid] < k){
                begin = mid+1;
            }else{
                end = mid-1;
            }
            return GetFirstK(arr,begin,end,k);
        }
        private static int GetLastK(int[] arr,int begin,int end,int k){
            if(begin > end)
                return -1;
            int mid = (begin+end)/2;
            int midData = arr[mid];
            if(midData == k){
                if(mid == end || midData != arr[mid+1])
                    return mid;
                else if(midData == arr[mid+1])
                    begin = mid+1;
            }else if(midData < k){
                begin = mid+1;
            }else{
                end = mid-1;
            }
            return GetLastK(arr,begin,end,k);
        }
}
