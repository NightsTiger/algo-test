package datastructure.binarytree;

/**
 * @author : dingwenqiang
 * @date : 2019/11/8 09:27
 * @description : 二叉堆-最大堆
 */
public class Heap {
    //用数组存储，因为二叉堆是完全二叉树，用数组更方便且节省内存
    //下标从1开始
    private int[] arr;
    //当前堆的大小，最大容量
    private int capacity;
    //当前堆中的元素个数
    private int count;

    public Heap(int capacity) {
        this.capacity = capacity;
        //下标从1开始
        arr = new int[capacity + 1];
        count = 0;
    }

    /**
     * 插入一个元素，在堆底
     *
     * @param data
     */
    private void insert(int data) {
        //堆满
        if (count >= capacity) {
            return;
        }
        count++;
        arr[count] = data;
        int i = count;
        //自下而上堆化
        while (i / 2 > 0 && arr[i] > arr[i / 2]) {
            swap(arr, i, i / 2);
            i = i / 2;
        }
    }

    /**
     * 堆顶删除元素
     *
     * @return
     */
    public int deleteHead() {
        if (count <= 0) {
            return -1;
        }
        int ret = arr[1];
        arr[1] = arr[count];
        //自上而下堆化
        count--;
        heapify(arr, 1, count);
        return ret;
    }

    /**
     * 根据一个乱序数组，构建一个二叉堆
     * 我们不使用传统的方法，一个一个插入，而是通过数组直接构建。那么需要怎么来构建呢？？
     * 因为所有叶子节点都不需要堆化，所以我们从数组的最后一个非叶子节点开始，从后向前遍历数组，依次自上而下堆化
     * 时间复杂度其实是O(n)，不是O(nlogn)，具体可以推导一下。
     * @param arr   数组
     * @param count 当前数组元素个数
     */
    public static void buildHeap(int[] arr, int count) {
        if (arr == null || arr.length == 0 || count <= 0) {
            return;
        }
        //count为最大下标，且arr[count] 一定为叶子节点，
        //所以arr[count/2]（最后一个叶子节点的父节点）是最后一个非叶子节点，所以叶子节点有(count/2 - 1个)
        //而构建二叉堆，只需要构建非叶子节点即可。
        for (int i = count / 2; i >= 1; --i) {
            heapify(arr, i, count);
        }
    }

    /**
     * 堆排序************************************************************************************************************
     * 1、先构建二叉堆
     * 2、二叉堆最上面的元素肯定是最大的，然后替换该元素和数组最后一个元素x，再把x堆化一次。此时最大的元素已归位，将下标-1。
     * 3、重复执行2，直到下标减到1为止，所有元素已排好序。
     * @param arr 乱序数组
     * @param count 元素个数
     */
    public static void sort(int[] arr, int count) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        buildHeap(arr, count);
        int maxIndex = count;
        while (count >= 1) {
            //交换堆顶元素和数组末尾(maxIndex)元素
            swap(arr, 1, maxIndex);
            heapify(arr, 1, --maxIndex);
        }
    }

    /**
     * 自上而下堆化
     * @param arr
     * @param i
     * @param count
     */
    private static void heapify(int[] arr, int i, int count) {
        while (true) {
            int tempIndex = i;
            //和两个子节点比较
            if (2 * i <= count && arr[tempIndex] < arr[2 * i]) {
                tempIndex = 2 * i;
            }
            if ((2 * i + 1) <= count && arr[tempIndex] < arr[2 * i + 1]) {
                tempIndex = 2 * i + 1;
            }
            if (tempIndex == i) {
                break;
            }
            swap(arr, tempIndex, i);
            i = tempIndex;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
