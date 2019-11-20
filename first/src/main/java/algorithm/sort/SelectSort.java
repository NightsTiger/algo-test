package algorithm.sort;

import java.util.Arrays;

/**
 * @author : dingwenqiang
 * @date : 2019/10/28 15:18
 * @description : 选择排序
 */
public class SelectSort {
    public static void sort(int[] tempArr) {
        if (tempArr == null || tempArr.length <= 1) {
            return;
        }
        int[] arr = Arrays.copyOf(tempArr, tempArr.length);
        int temp;
        //2,4,1,3
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        ArrayTool.printArr("选择排序：", arr);
    }
}
