package interview;/**
 * Created by fing on 2018/4/3.
 */

/**
 * @author
 * @create 2018-04-03 22:54
 **/
public class KonggeFilter {

    /**
     * 两层嵌套循环，时间复杂度： N方
     * @param arr
     */
    public static void forFilter(char[] arr){
        for (int i = 0 ;i < arr.length ; i++){
            if( arr[i] == ' '){//找到空格
                for (int j = i ; j < arr.length; j++){
                    if(arr[j] != ' '){//从后找到非空格
                        char temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }

    /**
     * 两下标的方式，时间复杂度为 N
     * @param arr
     */
    public static void twoIndexFilter(char[] arr){
        int i = 0 , j = 0 ;
        for (; i < arr.length ; i++){// i 下标一直往前挪
            if(arr[i] != ' '){//如果遇到非空格，
                if(i != j){//如果 i 和 j 相当，那么说明，前边未遇到空格，因为如果是非空格的情况，两个下标同时都在移动
                    char tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
                j++;//i 和 j 下标都往前挪
            }
        }
    }

    public static void main(String[] args) {
        char[] a = {'a',' ',' ','b',' ','c'};

        //解法一：最笨的方式，两层嵌套循环：时间复杂度  N方
//        forFilter(a);
        twoIndexFilter(a);

        for (char ch : a){
            System.out.println( ch + ",");
        }

    }

}
