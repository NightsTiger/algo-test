package algorithm.search.binarySearch;

/**
 * @author : dingwenqiang
 * @date : 2019/11/3 23:18
 * @description : 二分查找
 *
 * 二分查找需要满足几个条件：
 * 1.被查找的数据物理结构是数组。
 * 2.数组必须是有序的
 *
 * 二分查找的时间复杂度:O(logn)
 *
 * 二分查找更适合处理静态数据，也就是没有频繁的数据插入、删除操作。
 * 针对动态数据的查找，二叉树更适合
 */
public class BinarySearch {

    private static int target;

    private static void setTarget(int target) {
        BinarySearch.target = target;
    }

    public static int find(int[] arr, int target) {
        if (arr == null) {
            return -1;
        }
        setTarget(target);
        return findSimple(arr, 0, arr.length - 1);
    }

    /**
     * 简单写法，不管重复值
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public static int findSimple(int[] arr, int low, int high) {
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] == target) {
                return middle;
            } else if (arr[middle] > target) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 递归写法
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public static int findRecursive(int[] arr, int low, int high) {
        if (low > high) {
            return -1;
        }
        int middle = low + (high - low) / 2;
        int middleValue = arr[middle];
        if (target == middleValue) {
            return middle;
        } else if (target > middleValue) {
            return findRecursive(arr, middle + 1, high);
        } else {
            return findRecursive(arr, low, middle - 1);
        }
    }

    /**
     * 查找第一个值等于给定值的元素
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public static int findFirst(int[] arr, int low, int high) {
        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (arr[middle] > target) {
                high = middle - 1;
            } else if (arr[middle] < target) {
                low = middle + 1;
            } else {
                if (middle == 0 || arr[middle - 1] != target) {
                    return middle;
                } else {
                    high = middle - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 最后一个值等于给定值的元素
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public static int findLast(int[] arr, int low, int high) {
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] > target) {
                high = middle - 1;
            } else if (arr[middle] < target) {
                low = middle + 1;
            } else {
                if (middle == (arr.length - 1) || arr[middle + 1] != target) {
                    return middle;
                } else {
                    low = middle + 1;
                }
            }
        }
        return -1;
    }
}
