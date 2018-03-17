package swordoffer.chapter2;
public class TwoDimensionArraySearch {
    /**
     * 自己的思路：还是非常繁琐啊啊啊啊....
     * 1.最左上角和最右下角的元素分别是数组的最小值和最大值，如果该元素不在这两个值的范围内，则无需再进行判断，直接返回false即可
     * 2.然后判断对角线的元素，如果相等，则直接返回true，否则定位到val小于的第一个对角元素
     * 3.然后在该对角元素的左下方和右上方元素进行判断
     * @param arr
     * @param val
     * @return
     */
    public static boolean isFind(int[][] arr,int val){
        int row = arr.length;
        int col = arr[0].length;
        if(val < arr[0][0] || val > arr[row-1][col-1])
            return false;
        int min = Math.min(row,col);
        int i;
        for(i=0;i<min;i++){
            if(arr[i][i] == val){
                return true;
            }else if(arr[i][i] > val)
                break;
        }
        for(int m = 0;m<i;m++){
            for (int n = i;n<row;n++){
                if(val == arr[m][n])
                    return true;
            }
        }
        for (int m = i;m<col;m++){
            for (int n = 0;n<i;n++){
                if (val == arr[m][n])
                    return true;
            }
        }
        return false;
    }

    /**
     * 神思路：
     * 右上角的元素是特殊的，其左边的元素全部比它小，下面的元素全部比它大，所以我们可以将val与最右上角的元素进行比较，
     * 如果小，则直接砍掉最后一列元素
     * 如果大，则直接砍掉第一行元素
     * 继续上述判断，每一次判断都砍掉一行元素或者一列元素
     * （补充：也可以选择从左下角的元素开始：右边的元素都比它大，上边的元素都比它小。左上角和右下角的元素则不行）
     * @param arr
     * @param val
     * @return
     */
    public static boolean isFindSuper(int[][] arr,int val){
        if (arr == null)
            return false;
        int row = arr.length;
        int col = arr[0].length;
        boolean find = false;
        int m = 0,n = col-1;
        while (m < row && n >= 0){
            if(val < arr[m][n])
                n--;
            else if(val > arr[m][n])
                m++;
            else {
                find = true;
                break;
            }
        }
        return find;
    }
    public static void main(String[] args){
        int[][] arr = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int val = 5;
        boolean find = TwoDimensionArraySearch.isFindSuper(arr,val);
        System.out.println(find);
    }
}
