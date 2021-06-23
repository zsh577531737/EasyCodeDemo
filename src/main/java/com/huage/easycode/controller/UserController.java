package com.huage.easycode.controller;

import com.huage.easycode.model.dto.UserDto;
import com.huage.easycode.model.vo.UserVo;
import com.huage.easycode.service.UserService;
import com.huage.easycode.config.ValidationGroups;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import com.github.pagehelper.*;

import javax.annotation.Resource;
import javax.validation.constraints.Min;

/**
 * (User)表控制层
 *
 * @author huage
 * @since 2021-06-23 10:50:06
 */
@Api(tags = "(User)")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "通过id查询单条数据 ")
    @ApiImplicitParam(name = "id", value = "User id", dataType = "Integer", paramType = "path", required = true)
    @GetMapping("/findById/{id}")
    public UserVo findById(@Min(value = 1) @PathVariable(value = "id") Integer id) {
        return this.userService.findById(id);
    }

    @ApiOperation(value = "查询多条数据 ")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", dataType = "int", paramType = "path", required = true),
            @ApiImplicitParam(name = "pageSize", value = "查询条数", dataType = "int", paramType = "path", required = true)
    })
    @PostMapping(value = "/findPageList/{pageNum}/{pageSize}")
    public PageInfo<UserVo> findPageList(@RequestBody UserDto userDto, @PathVariable(value = "pageNum") int pageNum, @PathVariable(value = "pageSize") int pageSize) {
        return this.userService.findPageList(userDto, pageNum, pageSize);
    }

    @ApiOperation(value = "新增数据 ")
    @PostMapping("/add")
    public UserVo add(@Validated(ValidationGroups.Save.class) @RequestBody UserDto userDto) {
        return this.userService.add(userDto);
    }

    @ApiOperation(value = "修改数据 Dto")
    @ApiImplicitParam(name = "id", value = "User id", dataType = "long", paramType = "query", required = true)
    @PatchMapping("/modify")
    public UserVo modify(@Validated(ValidationGroups.Update.class) @RequestBody UserDto userDto) {
        return this.userService.modify(userDto);
    }

    @ApiOperation(value = "通过主键删除数据 ")
    @ApiImplicitParam(name = "id", value = "User id", dataType = "Integer", paramType = "path", required = true)
    @DeleteMapping("/remove/{id}")
    public boolean remove(@Min(value = 1) @PathVariable(value = "id") Integer id) {
        return this.userService.remove(id);
    }

}
