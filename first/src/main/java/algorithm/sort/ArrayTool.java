package algorithm.sort;

import datastructure.binarytree.Heap;

/**
 * @author : dingwenqiang
 * @date : 2019/10/28 10:52
 */
public class ArrayTool {

    public static void main(String[] args) {
        int[] randomArr = pre();
        //System.out.println(Arrays.toString(randomArr));

        InsertSort.sort(randomArr);

        BubbleSort.sort(randomArr);

        SelectSort.sort(randomArr);

        MergeSort.sort(randomArr);

        QuickSort.sort(randomArr);

        //todo 排序还有点问题。
        System.out.println("Kth-第3大的值为：" + KthBiggest.findKth(randomArr, 3));

        //int[] arr = {0, 27, 24, 15, 3, 20, 18, 28, 5};

        Heap.sort(randomArr, randomArr.length - 1);
        printArr("堆排序：", randomArr);

    }

    public static int[] pre() {
        int[] randomArr = createRandomArr(30, 1, 8);
        printArr("源数组：", randomArr);
        return randomArr;
    }

    private static int[] createRandomArr(int max, int min, int length) {
        if (length < 1) {
            return new int[0];
        }
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            //[0,1.0)
            arr[i] = (int)(Math.random() * (max - min) + min);
        }
        return arr;

    }

    public static void printArr(String s, int[] arr) {
        System.out.println(s);
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.println(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
    }
}
