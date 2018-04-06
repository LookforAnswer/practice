package sort;/**
 * Created by fing on 2018/3/27.
 */

/**
 * 选择排序
 */
public class SelectSort {

    /**
     * 选择排序
     *
     * @param a
     */
    public void selectSort(int[] a){
        for (int i = 0 ; i < a.length ; i++){
            int min = i ;//每次默认 要比较的数组中的第一个位置为最小的元素，比较一次，min就后挪一次
            for (int j = i + 1; j < a.length; j++ ){
                if(a[min] > a[j]){

                }
            }
        }
    }
}
