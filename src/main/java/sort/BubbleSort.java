package sort;/**
 * Created by fing on 2018/3/27.
 */

/**
 * 冒泡排序，是经典排序算法中的一种
 * 所谓冒泡，通过名字来看，就是在水中的气泡越大，就越早越快往上浮，冒泡排序主要也是通过这个现象的启发。
 * 每一次遍历，都将最大（最小）的数，移动到最右边（左边），这样，遍历完成之后，所有的数都已经排好序了
 * 稳定性：
 * 时间复杂度：
 * 空间复杂度：
 */
public class BubbleSort {

    //
    public void sort(int [] a){

        for(int i = 0 ;i < a.length -1 ; i++){//当最后一个数的时候，不需要遍历，所以，遍历的次数，只需要 n - 1 次

            /**
             * 由于第一次遍历，最大的数跑到了最右边，那么下一次需要遍历的数据量就少一个，遍历一次就少一个，
             *
             * 由于，是 j 和 j+1 进行比较，那么为了保证数组访问时不越界，那么 j 的值 最大为 n-1；
             *
             */
            for (int j = 0 ; j < a.length-1 - i ; j++){
                if(a[j] > a[j+1]){//如果前一个元素比后一个元素大，那么则交换位置，由此处看出，冒泡排序是稳定的

                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }

            for (int j = 0 ; j < a.length ; j++)
                System.out.print(a[j] + ",");

            System.out.println();
        }
    }


    /**
     *  优化过的排序，当没发生交换，那么说明数已经按照顺序排列好了，为什么这么说呢？
     *
     * @param a
     */
    public void betterSort(int [] a){

        for(int i = 0 ;i < a.length -1 ; i++){

            boolean isExchange = false;

            for (int j = 0 ; j < a.length-1 - i ; j++){
                if(a[j] > a[j+1]){

                    isExchange = true;//用于标记是否发生过交换

                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }

            for (int j = 0 ; j < a.length ; j++)
                System.out.print(a[j] + ",");


            System.out.println(isExchange);
        }
    }

    public static void main(String[] args) {
        int [] numberAry = {8,2,4,5,7,9,6};
        BubbleSort bs = new BubbleSort();

//        bs.sort(numberAry);

        /**
         * 输出如下：
         * 2,4,5,7,8,6,9,true
         * 2,4,5,7,6,8,9,true
         * 2,4,5,6,7,8,9,true
         * 2,4,5,6,7,8,9,false
         * 2,4,5,6,7,8,9,false
         * 2,4,5,6,7,8,9,false
         *  根据次输出，我们可以看出的现象是，如果没有放胜过交换，那么数据就已经排列好，那么我们就可以推出循环
         */
        bs.betterSort(numberAry);
    }
}
