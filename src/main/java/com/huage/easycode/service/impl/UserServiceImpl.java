package com.huage.easycode.service.impl;

import com.huage.easycode.model.entity.User;
import com.huage.easycode.model.dto.UserDto;
import com.huage.easycode.model.vo.UserVo;
import com.huage.easycode.mapper.UserMapper;
import com.huage.easycode.service.UserService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.*;

import java.util.*;

import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * (User)表服务实现类
 *
 * @author huage
 * @since 2021-06-23 10:50:05
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserVo findById(Integer id) {
        User user = this.userMapper.selectById(id);

        //将User转成UserVo
        UserVo userVo = null;
        if (user != null) {
            userVo = new UserVo();
            BeanUtils.copyProperties(user, userVo);
        }

        return userVo;
    }

    /**
     * 查询多条数据
     *
     * @param userDto  实例对象
     * @param pageNum  页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    @Override
    public PageInfo<UserVo> findPageList(UserDto userDto, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        //将User转成UserVo
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        List<User> userList = this.userMapper.selectList(user);

        PageInfo<UserVo> pageInfo = new PageInfo<>();
        BeanUtils.copyProperties(new PageInfo<>(userList), pageInfo);
        return pageInfo;
    }

    /**
     * 新增数据
     *
     * @param userDto 实例对象
     * @return 实例对象
     */
    @Override
    public UserVo add(UserDto userDto) {
        //将UserDto转成User
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        this.userMapper.insert(user);

        return this.findById(user.getId());
    }

    /**
     * 修改数据
     *
     * @param userDto 实例对象
     * @return 实例对象
     */
    @Override
    public UserVo modify(UserDto userDto) {
        //将UserDto转成User
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        this.userMapper.update(user);

        return this.findById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean remove(Integer id) {
        return this.userMapper.deleteById(id) > 0;
    }
}

