import com.zhangmen.arch.sensitive.core.api.SensitiveUtil;
import com.zhangmen.arch.sensitive.core.enums.SensitiveStrategyEnum;

/**
 * @author : dingwenqiang
 * @date : 2019/6/11 15:57
 */
public class SensitiveDemo {
    public static void main(String[] args) {

        singleSensitiveTest();
    }

    private static void singleSensitiveTest() {
        final String email = "123456@163.com";
        System.out.println("脱敏后的邮箱：" + SensitiveUtil.encrypt(email, SensitiveStrategyEnum.EMAIL));
    }
}
