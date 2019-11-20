package gsontest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * @author : dingwenqiang
 * @date : 2019/6/20 19:09
 * @description : 一键复制工单信息 [user] resp
 */
@ApiModel("一键复制工单信息 [user] resp")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CopyUserInfoVO implements Serializable {

    private static final long serialVersionUID = -3404472850726863504L;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "手机号码")
    private String mobile;

    @ApiModelProperty("角色")
    private String role;

    @ApiModelProperty(value = "qq")
    private String qq;

    @ApiModelProperty(value = "网络状况")
    private String netState;

    @ApiModelProperty(value = "平台信息")
    private String platformInfo;

    @ApiModelProperty(value = "版本号")
    private String versionInfo;

    @ApiModelProperty(value = "麦克风")
    private String voice;

    @ApiModelProperty(value = "扬声器")
    private String speaker;

    @ApiModelProperty(value = "摄像头")
    private String video;

    @Override
    public String toString() {
        return "CopyUserInfoVO{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", qq='" + qq + '\'' +
                ", netState='" + netState + '\'' +
                ", platformInfo='" + platformInfo + '\'' +
                ", versionInfo='" + versionInfo + '\'' +
                ", voice='" + voice + '\'' +
                ", speaker='" + speaker + '\'' +
                ", video='" + video + '\'' +
                '}';
    }
}
