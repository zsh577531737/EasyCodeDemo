package com.huage.easycode.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author huage
 * @since 2021-06-23 10:50:07
 */
@Data
public class UserVo implements Serializable {

    private static final long serialVersionUID = 660226178848720924L;

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "家庭住址")
    private String address;

}
