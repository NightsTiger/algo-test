package gsontest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author : dingwenqiang
 * @date : 2019/6/20 16:27
 * @description : 一键复制工单信息返回vo
 */
@ApiModel("一键复制工单信息返回vo")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CopyTicketInfoVO implements Serializable {

    private static final long serialVersionUID = -2367474110946270819L;

    @ApiModelProperty("lessonUid")
    private String lessonUid;

    @ApiModelProperty("课程类型")
    private String lessonType;

    @ApiModelProperty("课程分类")
    private String lessonCategory;

    @ApiModelProperty("问题分类")
    private String categoryName;

    @ApiModelProperty(value = "问题描述")
    private String questionDesc;

    @ApiModelProperty(value = "当前通道")
    private String channel;

    private List<CopyUserInfoVO> copyUsers;

}
