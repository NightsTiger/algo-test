import com.zhangmen.arch.sensitive.core.util.CollectionUtil;
import org.apache.commons.codec.binary.Base64;

import java.util.*;

/**
 * @author : dingwenqiang
 * @date : 2019/8/7 12:46
 */
public class BaseCodeemo {

    public static void main(String[] args) {
//        System.out.println(getAgoraQuestionReportAuthorization());

//
//        int[] arr = {1, 2, 3};
//
//        List list = Arrays.asList(arr);
//
//        if (list instanceof ArrayList) {
//            System.out.println("aaa");
//        }

        List<Object> list = Collections.emptyList();

        if (CollectionUtil.isEmpty(list)) {

        }





        Date date = new Date();
        String s = date.toString();
        System.out.println(s);


    }

    private static String getAgoraQuestionReportAuthorization(){
        // 填入你获取到的 Customer ID 和 Customer Certificate
        String customerId = "f59fa2c918ba42a6b0b94b495fbd1ed6";
        String customerCertificate = "6729c7cbf15141018310191771e95567";
        String plainCredentials = customerId.concat(":").concat(customerCertificate);
        // 这里的 base64Credentials 就是你要的 Authorization 值
        return new String(Base64.encodeBase64(plainCredentials.getBytes()));
    }
}
