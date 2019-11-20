import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author : dingwenqiang
 * @date : 2019/11/1 19:50
 */
public class Md5Demo {

    public static void main(String[] args) throws Exception {

        String md5 = md5("AAA", "11f65b7039768d970d40051fe6bb3d95");


        System.out.println(md5);

        boolean verify = verify("123", "11f65b7039768d970d40051fe6bb3d95", md5);

        System.out.println(verify);
    }



    /**
     * MD5方法
     *
     * @param text 明文
     * @param key 密钥
     * @return 密文
     * @throws Exception
     */
    public static String md5(String text, String key) throws Exception {


        //请求方式，大写--POST
        String requestMethod = "POST";
        //请求路径，从网关前缀算起
        //String requestURL = "/gateway/zhangmen-client-wo/agora/issue/updateIssueCallBack";
        String queryParam = "_expires=1572934632";
        //body参数，序列化成字符串
        String bodyText = "{\"issue_id\":\"f1d739a4-a0e2-43f6-b213-550eb0918197\"}";
        StringBuilder result = new StringBuilder();
        result.append(requestMethod).append(",")
                //.append(requestURL).append(",")
                .append(queryParam).append(",")
                .append(bodyText).append(",")
                .append("c82440b46677287efaac46e377ccb76b");



        //加密后的字符串
        String encodeStr=DigestUtils.md5Hex(result.toString());
        System.out.println("MD5加密后的字符串为:encodeStr="+encodeStr);
        return encodeStr;
    }

    /**
     * MD5验证方法
     *
     * @param text 明文
     * @param key 密钥
     * @param md5 密文
     * @return true/false
     * @throws Exception
     */
    public static boolean verify(String text, String key, String md5) throws Exception {
        //根据传入的密钥进行验证
        String md5Text = md5(text, key);
        if(md5Text.equalsIgnoreCase(md5))
        {
            System.out.println("MD5验证通过");
            return true;
        }
        return false;
    }
}