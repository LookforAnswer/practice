package sort;/**
 * Created by fing on 2018/3/27.
 */

/**
 * 插入排序：
 */
public class InsertSort {

    public void insertSort(int[] a){

        //为什么从 1 开始，1代表第二个元素开始，因为前边的以排列好的集合至少有一个元素
        for (int i = 1 ; i < a.length ; i++){

            int temp = a[i];//临时存储 带插入元素值，找到插入位置，那么 这个位置的值会被重写
            int j = i-1;//用于记录第一个比 temp 元素小的位置

            for (;j>=0;j--){
                if( temp < a[j]){
                    a[j+1] = a[j];
                    continue;
                }
                break;
            }

            a[j+1] = temp;

            for (int k = 0 ;k < a.length ; k++)
                System.out.print(a[k]+",");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int [] numberAry = {8,2,4,5,7,9,6};
        InsertSort is = new InsertSort();
        is.insertSort(numberAry);
    }
}
