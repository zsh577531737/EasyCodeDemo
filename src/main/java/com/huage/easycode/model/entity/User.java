package com.huage.easycode.model.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author huage
 * @since 2021-06-23 10:50:06
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 973901544796635249L;

    //主键
    private Integer id;
    //姓名
    private String name;
    //年龄
    private Integer age;
    //家庭住址
    private String address;
}
