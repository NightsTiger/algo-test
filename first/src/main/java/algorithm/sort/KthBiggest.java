package algorithm.sort;

import java.util.Arrays;

/**
 * @author : dingwenqiang
 * @date : 2019/11/1 17:28
 * @description : 找出乱序数组中第K大的值
 * 利用快排思想，先分区，找出分区点，分区点归位即确认了该分区点在数组中的位置，和K比较，如果合适
 */
public class KthBiggest {

    public static int findKth(int[] tempArr, int k) {
        if (tempArr == null || k > tempArr.length) {
            return -1;
        }
        int[] arr = Arrays.copyOf(tempArr, tempArr.length);
        int partition = partition(arr, 0, arr.length - 1);
        //分区后排好序的那个元素(arr[partition])，是数组中第innerK大的值
        int innerK = arr.length - partition;
        if (innerK == k) {
            return arr[partition];
        } else if (innerK < k) {//k更大，说明target值在partition的左边
            partition = partition(arr, 0, partition - 1);
        } else {
            partition = partition(arr, partition + 1, arr.length - 1);
        }
        return arr[partition];
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        int j = low;
        while (j < high) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
            j++;
        }
        swap(arr, i, high);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
