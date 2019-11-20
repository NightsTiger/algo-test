package algorithm;

/**
 * @author : dingwenqiang
 * @date : 2019/9/24 05:55
 * @description : 求最小子数组。
 */
public class MinSubArr {


    public static void main(String[] args) {

        int s = 7;

        int[] nums = {2, 3, 1, 2, 4, 3};

        int minSubArrLen = getMinSubArrLen(s, nums);
        System.out.println(minSubArrLen);

        int minSubArrLenSlide = getMinSubArrLenSlide(s, nums);
        System.out.println("minSubArrLenSlide:" + minSubArrLenSlide);

        int minSubArrLenSlide2 = getMinSubArrLenSlide2(s, nums);
        System.out.println("minSubArrLenSlide2:" + minSubArrLenSlide2);

    }


    /**
     * 1.暴力求解
     * 时间复杂度:O(n^2)
     * 空间复杂度:O(1)
     *
     * @param s
     * @param arr
     * @return
     */
    private static int getMinSubArrLen(int s, int[] arr) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int tempSum = 0;
            for (int j = i; j < arr.length; j++) {
                tempSum += arr[j];
                if (tempSum >= s) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * 2.滑动窗口
     * 时间复杂度:O(n^2)
     * 空间复杂度:O(1)
     * @param s
     * @param arr
     * @return
     */
    private static int getMinSubArrLenSlide(int s, int[] arr) {
        int ans = Integer.MAX_VALUE;

        int left = 0;
        int right = -1;
        int sum = 0;

        while (left < arr.length) {
            //两个条件都满足，右边指针才能向右
            //1.没到边界
            //2.sum < s
            if (right + 1 < arr.length && sum < s) {
                right++;
                sum += arr[right];
            } else {
                //去掉left，再++
                sum -= arr[left];
                left++;
            }
            if (sum >= s) {
                ans = Math.min(ans, right - left + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * 3.滑动窗口改良
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param s
     * @param arr
     */
    private static int getMinSubArrLenSlide2(int s, int[] arr) {
        int ans = Integer.MAX_VALUE;
        //保持左边框不动，遍历右边框
        int left = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            //如果满足条件了，左边框向右移
            while (sum >= s) {
                ans = Math.min(ans, i - left + 1);
                sum -= arr[left++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    //int[] nums = {2, 3, 1, 2, 4, 3};
}
