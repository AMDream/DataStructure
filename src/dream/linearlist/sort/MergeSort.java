package dream.linearlist.sort;

/**
 * Created by Dream on 2018/3/14.
 */
public class MergeSort {
    public void sort(int[] num,int left,int right,int[] temp){
        if (left < right){
            int mid = (left+right)/2;
            sort(num,left,mid,temp);
            sort(num,mid+1,right,temp);
            mergeSort(num,left,mid,right,temp);
        }
    }
    public void mergeSort(int[] num,int left,int mid,int right,int[] temp){
        int i = left;
        int j = mid+1;
        int t = 0;
        while(i <= mid && j <= right){
            if (num[i] <= num[j])
                temp[t++] = num[i++];
            else
                temp[t++] = num[j++];
        }
        while(i <= mid)
            temp[t++] = num[i++];
        while(j <=right)
            temp[t++] = num[j++];
        t = 0;
        while(left <= right)
            num[left++] = temp[t++];
    }
}
