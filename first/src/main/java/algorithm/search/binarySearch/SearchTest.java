package algorithm.search.binarySearch;

import algorithm.sort.ArrayTool;

import java.util.Arrays;

/**
 * @author : dingwenqiang
 * @date : 2019/11/3 23:22
 */
public class SearchTest {

    public static void main(String[] args) {

        int[] randomArr = ArrayTool.pre();
        Arrays.sort(randomArr);
        ArrayTool.printArr("排序后数组: ", randomArr);
        testBinarySearchRecursive(randomArr);
        System.out.println("------------------------------------------------------------------------------------------ ");
        testBinarySearch(randomArr);

    }


    /**
     * 测试二分查找-递归实现
     *
     * @param randomArr
     */
    private static void testBinarySearchRecursive(int[] randomArr) {
        System.out.println("testBinarySearchRecursive查找目标值:" + randomArr[5]);
        int i = BinarySearch.find(randomArr, randomArr[5]);
        System.out.println("testBinarySearchRecursive目标值的下标:" + i + "--------" + (i == 5));
    }

    /**
     * 测试二分查找
     *
     * @param randomArr
     */
    private static void testBinarySearch(int[] randomArr) {
        System.out.println("testBinarySearch查找目标值:" + randomArr[5]);
        int i = BinarySearch.find(randomArr, randomArr[5]);
        System.out.println("testBinarySearch目标值的下标:" + i + "--------" + (i == 5));
    }
}
