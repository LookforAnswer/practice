package mianshi;/**
 * Created by fing on 2018/4/3.
 */

/**
 * @author
 * @create 2018-04-03 22:54
 **/
public class KonggeFilter {

    public static void main(String[] args) {
        char[] a = {'a',' ',' ','b',' ','c'};

        int flag = 0 , i = 0;
        for (i = 0; i < a.length; i++){

            if( a[i] != ' '){//如果遇到非空，同时移动
                if( i != flag){
                    char temp = a[i];
                    a[i] = a[flag];
                    a[flag] = temp;
                }
                flag++;
            }
        }

        for (char ch : a){
            System.out.println( ch + ",");
        }

    }

}
