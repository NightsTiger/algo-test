package datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : dingwenqiang
 * @date : 2019/11/11 08:49
 * @description : 无向图
 */
public class Graph {

    //顶点个数
    private int v;
    //邻接表数组
    private LinkedList<Integer>[] adj;

    /**
     * 初始化一个图
     *
     * @param v
     */
    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 添加一条边，无向图两个顶点都要加。
     *
     * @param x
     * @param y
     */
    public void addEdge(int x, int y) {
        adj[x].add(y);
        adj[y].add(x);
    }


    //todo----------------------------------------------------BFS-------------------------------------------------------

    /**
     * 广度优先搜索-无向图-邻接表实现
     *
     * @param s 起始顶点
     * @param t 终止顶点
     */
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        //记录每个顶点的访问状态，如果访问过了就无需再访问
        boolean[] visited = new boolean[v];
        visited[s] = true;
        //记录第i次访问的顶点
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        //记录顶点的前驱顶点
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        while (queue.size() != 0) {
            int w = queue.poll();
            LinkedList<Integer> linkedList = adj[w];
            for (int i = 0; i < linkedList.size(); ++i) {
                int q = linkedList.get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    private void print(int[] prev, int s, int t) { // 递归打印s->t的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }


    /**
     * 广度优先搜索(社交网络查找3度好友)-无向图-邻接表实现
     * @param s 用户s
     * @param x 度
     */
    public List<Integer> findXFriends(int s, int x) {
        List<Integer> ret = new ArrayList<>();
        if (x <= 0) {
            return ret;
        }

        //记录每个顶点的访问状态，如果访问过了就无需再访问
        boolean[] visited = new boolean[v];
        visited[s] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        int time = 1;
        while (queue.size() != 0) {
            if (time == x) {
                return ret;
            }

            int w = queue.poll();
            LinkedList<Integer> linkedList = adj[w];
            for (int i = 0; i < linkedList.size(); ++i) {
                int q = linkedList.get(i);
                if (!visited[q]) {
                    visited[q] = true;
                    queue.add(q);
                    ret.add(q);
                }
            }
            time++;
        }
        return ret;
    }

    //todo----------------------------------------------------DFS-------------------------------------------------------

    //深度优先遍历标示已经找到，用于return
    private boolean found;

    /**
     * 深度优先遍历
     *
     * @param s
     * @param t
     */
    public void dfs(int s, int t) {
        if (s == t) {
            return;
        }

        boolean[] visited = new boolean[v];
        visited[s] = true;

        int[] prev = new int[v];
        for (int i = 0; i < prev.length; i++) {
            prev[i] = -1;
        }
        found = false;

        recurDFS(visited, prev, s, t);
        print(prev, s, t);
    }

    private void recurDFS(boolean[] visited, int[] prev, int w, int t) {
        if (found) {
            return;
        }
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        LinkedList<Integer> linkedList = adj[w];
        for (int i = 0; i < linkedList.size(); i++) {
            int q = linkedList.get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDFS(visited, prev, q, t);
            }
        }
    }


}
