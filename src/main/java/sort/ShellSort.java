package sort;/**
 * Created by fing on 2018/3/27.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @create 2018-03-27 23:51
 **/
public class ShellSort {

    public void shellSort(int[] a){

        double d1 = a.length;

        while (true){

        }
    }


    public int fun(int n){
        boolean[] arr = new boolean[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = true;
        }

        int leftCount = n;
        int countNum = 0;
        int index = 0;
        while (leftCount > 1) {
            if (arr[index] == true) {
                countNum++;
                if (countNum == 3) {
                    countNum = 0;
                    arr[index] = false;
                    leftCount--;
                }
            }
            index++;
            if (index == n) {
                index = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == true) {
                index = i;
                break;
            }
        }
        return index+1;
    }



    public static void main(String[] args) {
        ShellSort ss = new ShellSort();

        System.out.println(ss.fun(5));
    }


}
