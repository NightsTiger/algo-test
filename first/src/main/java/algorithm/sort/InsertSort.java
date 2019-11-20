package algorithm.sort;

import java.util.Arrays;

/**
 * @author : dingwenqiang
 * @date : 2019/10/28 10:10
 * @description : 插入排序
 */
public class InsertSort {

    public static void sort(int[] tempArr) {
        if (tempArr == null || tempArr.length <= 1) {
            return;
        }
        int[] arr = Arrays.copyOf(tempArr, tempArr.length);
        //4,8,7,5,3,1
        //4,5,7,8,3,1
        //从1开始，0下标作为初始数组。
        for (int i = 1; i < arr.length; i++) {
            int target = arr[i];
            int j = i;
            //从后向前遍历已排好序的子数组，如果遇到比目标值target更大的数，就要向后挪一格。
            while (j > 0 && target < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            //j用于找出存放target值的合适位置。
            arr[j] = target;
        }
        ArrayTool.printArr("插入排序：", arr);
    }
}
