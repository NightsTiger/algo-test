import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: dingwenqiang
 * @date: 2019/4/15 18:14
 */
public class Main {
    public static int k ;

    public static void main(String[] args) {


        //abc def  ghi   jkl mnp
        String lessonUidStr = "abc def  ghi            jkl mnp";
        String lessonUid = lessonUidStr.replaceAll(" +", " ");

        String[] arr = lessonUid.split(" ");
        List<String> strings = Arrays.asList(arr);
        System.out.println(strings);
    }

    private static void initAdd(int i) {

        k = i + 1;

        System.out.println(k);
    }
}
