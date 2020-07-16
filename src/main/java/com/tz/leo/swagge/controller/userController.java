package com.tz.leo.swagge.controller;

import com.tz.leo.swagge.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: tz_wl
 * Date: 2020/7/16 20:17
 * Content:
 */
@RestController
@RequestMapping("user")
@Api( tags="用户模块接口规范说明")
public class userController {

    @GetMapping("findAll")
    @ApiOperation(value = "查询Action",
    notes = "<span style='color:red;'>描述:</span>&nbsp;&nbsp; 用于查询用户信息详情")
    public Map<String,Object> findAll(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("success","查询所有成功");
        map.put("state",true);
        return map;
    }



    //路径传参  http://localhost:8985/user/save02?id=21&name=nnnnname
    @PostMapping("save01")
    @ApiOperation(value="保存Action01",notes ="<span style='color:red;'>描述:</span>&nbsp;&nbsp; 用于保存用户信息" )
    public Map<String,Object> save01(String id,String name){
        System.out.println("id01:"+id);
        System.out.println("name:"+name);
        HashMap<String, Object> map = new HashMap<>();
        map.put("success","查询所有成功");
        map.put("state",true);
        return map;
    }

    //路径传参  http://localhost:8985/user/save02?id=21&name=nnnnname
    //save01的升级版
    @PostMapping("save02")
    @ApiOperation(value="保存Action升级",notes ="<span style='color:red;'>描述:</span>&nbsp;&nbsp; 用于保存用户信息" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户id",dataType = "String" ,defaultValue = "21"),
            @ApiImplicitParam(name="name" ,value = "用户姓名" ,dataType = "String",defaultValue = "张老四")
    })
    public Map<String,Object> save02(String id,String name){
        System.out.println("id:"+id);
        System.out.println("name:"+name);
        HashMap<String, Object> map = new HashMap<>();
        map.put("success","查询所有成功！！");
        map.put("state",true);
        return map;
    }


    //REST风格传参  http://localhost:8985/user/save03/21/name
    //save01的升级版
    @PostMapping("saveRest/{id}/{name}")
    @ApiOperation(value="保存Action升级rest风格 路径传参",notes ="<span style='color:red;'>描述:</span>&nbsp;&nbsp; 用于保存用户信息" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户id",dataType = "String" ,defaultValue = "21",paramType = "path"),
            @ApiImplicitParam(name="name" ,value = "用户姓名" ,dataType = "String",defaultValue = "张老四",paramType = "path")
    })
    public Map<String,Object> save03(@PathVariable("id") String id,@PathVariable("name") String name){
        System.out.println("id:"+id);
        System.out.println("name:"+name);
        HashMap<String, Object> map = new HashMap<>();
        map.put("success","查询所有成功！！！！！");
        map.put("state",true);
        return map;
    }


    //save01的升级版  body 传参  定义一个对象接收 body 数据
    @PostMapping("saveByBody")
    @ApiOperation(value="保存Action升级rest风格 路径传参",notes ="<span style='color:red;'>描述:</span>&nbsp;&nbsp; 用于保存用户信息" )
    public Map<String,Object> saveByBody(@RequestBody User user){
        System.out.println("id:"+user.getId());
        System.out.println("name:"+user.getName());
        HashMap<String, Object> map = new HashMap<>();
        map.put("success","查询所有成功！！！！！");
        map.put("state",true);
        return map;
    }





    @PostMapping("saveUserDefineReturn")
    @ApiResponses({@ApiResponse(code=200,message = "保存成功"),
            @ApiResponse(code=401,message = "当前请求没有被授权"),
            @ApiResponse(code=404,message = "当前请求路径不存在")
    })
    public Map<String,Object> saveDefineReturn(String id,String name){
        System.out.println("id01:"+id);
        System.out.println("name:"+name);
        HashMap<String, Object> map = new HashMap<>();
        map.put("success","查询所有成功！！！");
        map.put("state",true);
        return map;
    }




}
