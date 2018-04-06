package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 循环 和 递归两种方式实现未知维度集合的笛卡尔积
 */
public class Descartes {

    /**
     * 递归实现 targetList 中的笛卡尔积，结果放在 resultList 中
     * @param targetList 原始数据
     * @param resultList 结果数据
     * @param layer dimValue的层数
     * @param curList 每次笛卡尔积的结果
     */
    private static void recursive (List<List<String>> targetList, List<List<String>> resultList, int layer, List<String> curList) {

        if (layer < targetList.size() - 1) {
            if (targetList.get(layer).size() == 0) {
                recursive(targetList, resultList, layer + 1, curList);
            } else {
                for (int i = 0; i < targetList.get(layer).size(); i++) {
                    List<String> list = new ArrayList<String>(curList);
                    list.add(targetList.get(layer).get(i));
                    recursive(targetList, resultList, layer + 1, list);
                }
            }
        }
        else if (layer == targetList.size() - 1) {
            if (targetList.get(layer).size() == 0) {
                resultList.add(curList);
            } else {
                for (int i = 0; i < targetList.get(layer).size(); i++) {
                    List<String> list = new ArrayList<String>(curList);
                    list.add(targetList.get(layer).get(i));
                    resultList.add(list);
                }
            }
        }
    }

    /**
     * 循环实现 targetList 中的笛卡尔积，结果放在 resultLists 中
     * @param targetList 原始数据
     * @param resultList 结果数据
     */
    private static void circulate (List<List<String>> targetList, List<List<String>> resultList) {

        int total = 1;
        for (List<String> list : targetList) {//遍历多个数组的长度，相乘得到最终集合的大小 = 数组1大小 X 数组2大小 X 数组3大小 ...
            total *= list.size();
        }
        String[] myResult = new String[total];


        int itemLoopNum = 1;
        int loopPerItem = 1;
        int now = 1;
        for (List<String> list : targetList) {
            now *= list.size();

            int index = 0;
            int currentSize = list.size();

            itemLoopNum = total / now;
            loopPerItem = total / (itemLoopNum * currentSize);
            int myIndex = 0;

            for (String string : list) {
                for (int i = 0; i < loopPerItem; i++) {
                    if (myIndex == list.size()) {
                        myIndex = 0;
                    }

                    for (int j = 0; j < itemLoopNum; j++) {
                        myResult[index] = (myResult[index] == null? "" : myResult[index] + ",") + list.get(myIndex);
                        index++;
                    }
                    myIndex++;
                }

            }
        }

        List<String> stringResult = Arrays.asList(myResult);
        for (String string : stringResult) {
            String[] stringArray = string.split(",");
            resultList.add(Arrays.asList(stringArray));
        }
    }


    public static void main (String[] args) {


        List<String> a = new ArrayList<String>();
        a.add("a1");
        a.add("a2");

        List<String> b = new ArrayList<String>();
        b.add("b1");
        b.add("b2");

        List<String> c = new ArrayList<String>();
        c.add("c1");
        c.add("c2");
        c.add("c3");

        List<String> d = new ArrayList<String>();
        d.add("d1");
        d.add("d2");
        d.add("d3");

        List<List<String>> dimValue = new ArrayList<List<String>>();
        dimValue.add(a);
        dimValue.add(b);
        dimValue.add(c);
        dimValue.add(d);

        List<List<String>> recursiveResult = new ArrayList<List<String>>();

        // 递归实现
        recursive(dimValue, recursiveResult, 0, new ArrayList<String>());
        for (List<String> list : recursiveResult) {
            for (String string : list) {
                System.out.print(string + " ");
            }
            System.out.println();
        }

        //循环调用
        List<List<String>> circulateResult = new ArrayList<List<String>>();
        circulate(dimValue, circulateResult);
        for (List<String> list : circulateResult) {
            for (String string : list) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }
}
