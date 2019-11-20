package mytest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : dingwenqiang
 * @date : 2019/10/8 10:44
 */
public class ListTest {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("eee");

        int batch = 2;
        int turn = list.size() / batch;
        for (int i = 0; i < turn; i++) {
            List<String> subList = list.subList(i * batch, (i + 1) * batch);
            sout(subList);
            System.out.println(String.format("----------第%s轮", i + 1));
        }

        if (turn * batch < list.size()) {
            List<String> subList = list.subList(turn * batch, list.size());
            sout(subList);
        }
    }

    private static void sout(List<String> subList) {
        for (int j = 0; j < subList.size(); j++) {
            System.out.print(subList.get(j) + ", ");
        }
    }
}
