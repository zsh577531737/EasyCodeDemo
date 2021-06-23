package com.huage.easycode.service;

import com.huage.easycode.model.dto.UserDto;
import com.huage.easycode.model.vo.UserVo;
import com.github.pagehelper.*;

/**
 * (User)表服务接口
 *
 * @author huage
 * @since 2021-06-23 10:50:04
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserVo findById(Integer id);

    /**
     * 查询多条数据
     *
     * @param userDto  实例对象
     * @param pageNum  页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    PageInfo<UserVo> findPageList(UserDto userDto, int pageNum, int pageSize);

    /**
     * 新增数据
     *
     * @param userDto 实例对象
     * @return 实例对象
     */
    UserVo add(UserDto userDto);

    /**
     * 修改数据
     *
     * @param userDto 实例对象
     * @return 实例对象
     */
    UserVo modify(UserDto userDto);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean remove(Integer id);

}
