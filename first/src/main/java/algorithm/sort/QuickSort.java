package algorithm.sort;

import java.util.Arrays;

/**
 * @author : dingwenqiang
 * @date : 2019/10/30 14:04
 * @description : 快排
 * 时间复杂度T(n) = O(nlogn)，最差O(n^2)
 * 空间复杂度：由于是原地排序，没有额外消耗空间，所以空间复杂度为O(1)
 * 对比归并排序，时间复杂度更不稳定，但不消耗空间
 */
public class QuickSort {

    /**
     * 递归公式: quickSort(p,r) = quickSort(p, q-1) + quickSort(q+1, r))
     * 终止条件: p >= r
     *
     * @param tempArr
     */
    public static void sort(int[] tempArr) {
        if (tempArr == null || tempArr.length <= 1) {
            return;
        }
        int[] arr = Arrays.copyOf(tempArr, tempArr.length);
        quickSort(arr, 0, arr.length - 1);
        ArrayTool.printArr("快速排序：", arr);
    }

    private static void quickSort(int[] arr, int low, int high) {
        //终止条件
        if (low >= high) {
            return;
        }
        int pivot = partition(arr, low, high);
        //分治递归左半边数组
        quickSort(arr, low, pivot - 1);
        //分之递归右半边数组
        quickSort(arr, pivot + 1, high);
    }

    /**
     * 让中间点归位并找出中间点下标，使得中间点左边的数比pivot小，右边的数比pivot大
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private static int partition(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        int target = arr[low];
        while (i < j) {
            //j往左边移，找到了比target小的数就停下
            while (i < j && arr[j] >= target) {
                j--;
            }
            //i往右边移，找到了比target大的数就停下
            while (i < j && arr[i] <= target) {
                i++;
            }
            //停下之后，就交换 arr[i] 和 arr[j]
            swap(arr, i, j);
        }
        //跳出while循环，代表i==j了，交换target和j的位置，
        swap(arr, low, j);
        //此时target已经归位了，不需要再参与排序了，将下标返回即可
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
