package sort;/**
 * Created by fing on 2018/4/2.
 */

/**
 * @author
 * @create 2018-04-02 17:54
 **/
public class QSort {


    public void Qsort(int[] numArray , int start ,int end){
        if(null == numArray || start >= end){
            return;
        }


        int tmp = numArray[start];
        int i = start,j = end;

        while (i < j){
            while( i < j && numArray[j] > tmp)
                j--;
            if(i < j){
                numArray [i++] = numArray[j];
             }
            while (i < j && numArray[i] < tmp)
                i++;

            if(i < j){
                numArray[j--] = numArray[i];
            }
        }

        numArray[i] = tmp;
        Qsort( numArray,start,i-1 );
        Qsort( numArray,i+1,end );
    }

    public static void main(String[] args) {
        int [] a = {6,2,7,3,9,5,4};
        QSort obj = new QSort();
        obj.Qsort(a,0,a.length-1);
        for (int everyRow : a){
            System.out.print( everyRow + ",");
        }
    }

}
