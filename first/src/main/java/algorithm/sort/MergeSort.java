package algorithm.sort;

import java.util.Arrays;

/**
 * @author : dingwenqiang
 * @date : 2019/10/29 16:56
 * @description : 归并排序
 * 时间复杂度: 最好最坏平均都是O(nlogn)
 * 空间复杂度: O(n) ... 某一时刻cpu只执行一个方法，最多可能存在一个临时数组。
 */
public class MergeSort {

    /**
     * 递归公式: mergeSort(p,r) = merge(mergeSort(p, q), mergeSort(q+1, r))
     * 终止条件: p >= r
     *
     * @param tempArr
     */
    public static void sort(int[] tempArr) {
        if (tempArr == null || tempArr.length <= 1) {
            return;
        }
        int[] arr = Arrays.copyOf(tempArr, tempArr.length);
        sort_c(arr, 0, arr.length - 1);
        ArrayTool.printArr("归并排序：", arr);
    }

    private static void sort_c(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        //防止超过Integer.MAX_VALUE
        int q = p + (r - p) / 2;
        //分治递归（其实就是把大的数组拆分成小数组）
        sort_c(arr, p, q);
        sort_c(arr, q + 1, r);
        //将两个小数组合并成大数组（真正的排序在这里实现）
        merge(arr, p, q, r);
    }

    private static void merge(int[] arr, int p, int q, int r) {
        //初始化 i,j,k
        int i = p;
        int j = q + 1;
        int k = 0;
        //重新申请一个和arr一样大的数组，用于临时排序。最后还是要复制给arr
        int[] tmp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        //把剩余部分放到tmp中
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end) {
            tmp[k++] = arr[start++];
        }
        //把tmp复制到原arr中
        for (int x = 0; x < r - p + 1; x++) {
            arr[p + x] = tmp[x];
        }
    }
}
