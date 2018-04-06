package sort;/**
 * Created by fing on 2018/4/2.
 */

/**
 * @author
 * @create 2018-04-02 18:01
 **/
public class MergeSort {


    public static void main(String[] args) {
        int [] a = {6,2,7,3,9,5,4};
        mergeSort(a,0,a.length-1);
        for (int everyRow : a){
            System.out.print( everyRow + ",");
        }
    }

    public static void mergeSort(int[] numArray,int start,int end){
        if(start >= end){
            return;
        }

        int mid = ( start + end ) / 2;
        mergeSort(numArray,start,mid);
        mergeSort(numArray,mid+1,end);
        merge(numArray,start,mid,end);
    }

    public static void merge(int [] numArray,int start,int mid,int end){

        int[] tempArr = new int[numArray.length];//用于合并的新数组

        int rightIndex = mid + 1,
                leftIndex = start,
                i = start ;

        while ( start <= mid && rightIndex <= end){//左边 和 右边 的两个游标都在范围内

            //从两个分组的数组中，每次一遍取一个
            if( numArray[ start ] < numArray[rightIndex]){
                tempArr[i++] = numArray[start++];
            } else {
                tempArr[i++] = numArray[rightIndex++];
            }
        }

        //说明右边的元素多
        while ( rightIndex <= end)
            tempArr[i++] = numArray[rightIndex++];

        //说明左边的元素多
        while (start <= mid )
            tempArr[i++] = numArray[start++];

        while ( leftIndex <= end)
            numArray[leftIndex] = tempArr[leftIndex++];
    }


}
