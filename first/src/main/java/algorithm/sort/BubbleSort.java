package algorithm.sort;

import java.util.Arrays;

/**
 * @author : dingwenqiang
 * @date : 2019/10/28 10:52
 * @description : 冒泡
 */
public class BubbleSort {

    public static void sort(int[] tempArr) {
        if (tempArr == null || tempArr.length <= 1) {
            return;
        }
        int[] arr = Arrays.copyOf(tempArr, tempArr.length);
        int temp;
        for (int i = 0; i < arr.length; i++) {
            //提前退出
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        //System.out.println(Arrays.toString(arr));
        ArrayTool.printArr("冒泡排序：", arr);
    }

}
