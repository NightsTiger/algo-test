package algorithm.dynamic_programming;

import java.util.*;

/**
 * @author : dingwenqiang
 * @date : 2019/11/12 16:40
 * @description : 0-1 背包问题求解
 */
public class BackPack01_answer {

    public static void main(String[] args) {
        int[] a = {5, 2, 11, 15, 5};
        BackPack01_answer answer = new BackPack01_answer();
        answer.f(0, 0, a, 5, 25);
        List<int[]> answerList = answer.bestAnswerMap.get(20);
        answerList.forEach(x -> System.out.println(Arrays.toString(x)));
    }

    // 存储背包中物品总重量的最大值
    private int maxW = Integer.MIN_VALUE;
    // 下标表示物品序号，值表示是否放进背包:1放，0不放
    private int[] currentAnswer;
    // 存储所有解(map key表示放进去的重量，value表示对应重量的物品放法)，
    // 最终所有最优解为bestAnswerMap.get(maxW)
    private Map<Integer, List<int[]>> bestAnswerMap = new HashMap();

    /**
     * @param i     表示考察到哪个物品了；
     * @param cw    表示当前已经装进去的物品的重量和；
     * @param items 表示每个物品的重量；
     * @param n     表示物品个数
     * @param w     背包重量（最大容量）；
     *              假设背包可承受重量 100，物品个数 10，物品重量存储在数组 a 中，那可以这样调用函数：
     *              f(0, 0, a, 10, 100)
     */
    public void f(int i, int cw, int[] items, int n, int w) {
        if (currentAnswer == null) {
            currentAnswer = new int[n];
        }
        // cw==w 表示装满了;
        // i==n 表示已经考察完所有的物品
        if (cw == w || i == n) {
            if (cw >= maxW) {
                maxW = cw;
                int[] bestAnswer = new int[currentAnswer.length];
                for (int j = 0; j < currentAnswer.length; j++) {
                    bestAnswer[j] = currentAnswer[j];
                }
                if (bestAnswerMap.containsKey(cw)) {
                    bestAnswerMap.get(cw).add(bestAnswer);
                } else {
                    List<int[]> list = new ArrayList<int[]>();
                    list.add(bestAnswer);
                    bestAnswerMap.put(cw, list);
                }
            }
            return;
        }
        currentAnswer[i] = 0;
        // 选择不装第i个物品
        f(i + 1, cw, items, n, w);
        // 已经超过可以背包承受的重量的时候，就不要再装了
        if (cw + items[i] <= w) {
            currentAnswer[i] = 1;
            // 选择装第i个物品
            f(i + 1, cw + items[i], items, n, w);
        }
    }
}
