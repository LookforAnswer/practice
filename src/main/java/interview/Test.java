package interview;/**
 * Created by fing on 2018/4/4.
 */

/**
 * @author
 * @create 2018-04-04 19:21
 **/
public class Test {

    public static void main(String[] args) {
        int[] arr = {1,5,4,6,8,9,3,2};



    }



    public void quickSort(int [] arr,int start ,int end){
        //边界条件的判断
        if( null == arr || start >= end )
            return;

        int i = start, j = end;

        int mid = (start + end) / 2;
        int temp = arr[mid];//获取 比较元

        //反复比对，将比 temp 大的数挪到 temp 的右边，比 temp 小的数挪到 temp 的左边
        while (i < j){

            //从后往前找，找到 第一个 比 temp 小的值
            while ( i < j && arr[j] > temp)
                j--;

            //找到之后，因为 i( 最开始的时候是 start ) 已经存到 temp 里边，那么这个时候，找到 比temp小的值，挪到 i 这个地方
            if( i < j){
                arr[i++] = arr[j];//将 位置 为 j 的位置的数挪到 i 的地方，同时将 i 往后挪
            }

            //从前往后找，找到第一个 比 tmep 大的值
            while ( i < j && arr[i] < temp)
                i++;

            //由于 j 的位置的值，已经赋值 i 的位置了
            if( i < j ){
                arr[j++] = arr[i];//将 位置 为 j 的位置的数挪到 i 的地方，同时将 i 往后挪
            }
        }

        //一轮比对完了，最后剩下一个空的位置，分割位置
        arr[i] = temp;

        //对 temp 左边的数组进行递归调用，由于 temp 已经是分割元了，所以，就不需要将其纳入需要排序的子数组中了
        quickSort(arr,start,i-1);

        //对 temp 右边的数组进行递归调用
        quickSort(arr,i+1,end);
    }

}
