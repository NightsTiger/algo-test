package algorithm;

import java.util.*;

/**
 * @author : dingwenqiang
 * @date : 2019/9/23 17:30
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {

        String str = "abcabcweklwadff";
//        String str = "dvdf";

        int i = lengthOfLongestSubstring(str);
        System.out.println("i:" + i);


        int i1 = lengthOfLongestSubstringSlide(str);
        System.out.println("i1:" + i1);


        int i2 = lengthOfLongestSubstringSlide2(str);
        System.out.println("i2:" + i2);

    }

    //1.暴力解法
    private static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }
    private static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

    //2.滑动窗口
    private static int lengthOfLongestSubstringSlide(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        int i = 0, j = 0, ans = 0;
        while (i < n && j < n) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            }else {
                set.add(s.charAt(j++));
                ans = Integer.max(ans, j - i);
            }
        }
        return ans;
    }

    //3.滑动窗口改良
    private static int lengthOfLongestSubstringSlide2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

}
