package com.huage.easycode.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.huage.easycode.config.ValidationGroups;

/**
 * (User)实体类
 *
 * @author huage
 * @since 2021-06-23 10:50:06
 */
@ApiModel("UserDto")
@Data
public class UserDto implements Serializable {

    private static final long serialVersionUID = 892332098095862675L;

    @ApiModelProperty(value = "主键")
    @NotNull(groups = {ValidationGroups.Update.class, ValidationGroups.Delete.class})
    @Min(value = 1, groups = {ValidationGroups.Update.class, ValidationGroups.Delete.class})
    private Integer id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "家庭住址")
    private String address;

}
