import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import gsontest.CopyTicketInfoVO;
import org.apache.commons.lang3.StringUtils;

/**
 * @author : dingwenqiang
 * @date : 2019/6/21 11:30
 */
public class JsonDemo {


    public static void main(String[] args) {


        JSONObject jsonObject = JSON.parseObject("{\"qq\":\"\"}");
        System.out.println(jsonObject);

    }


//    public static void copyString(){
//        CopyTicketInfoVO vo = CopyTicketInfoVO.builder()
//                .lessonUid("9168506ad8b1428c8aacf5c70c24bb44")
//                .lessonType("1对1")
//                .lessonCategory("测评课")
//                .channel("agore")
//                .build();
//
//
//
////            private String name;
////            private String mobile;
////            private String role;
////            private String qq;
////            private String netState;
////            private String platformInfo;
////            private String versionInfo;
////            private String voice;
////            private String speaker;
////            private String video;
//
//        String contact = "{\"qq\":\"111111\"}";
//        if (StringUtils.isNotBlank((contact))) {
//
//            JSONObject qqJson = JSON.parseObject(contact,SerializerFeature.);
//            qq = qqJson.getString("qq");
//        }
//
//        String voice = StringUtils.EMPTY;
//        String deviceStateInfo = userDetail.getDeviceStateInfo();
//        JSONObject
//
//
//        CopyUserInfoVO.builder()
//                .name(userDetail.getName())
//                .mobile(userDetail.getMobile())
//                .role(userDetail.getRole())
//                .qq(qq)
//                .netState(userDetail.getNetState())
//                .platformInfo(userDetail.getPlatformInfo())
//                .versionInfo(userDetail.getVersionInfo())
//                .build();
//
//    }

}
