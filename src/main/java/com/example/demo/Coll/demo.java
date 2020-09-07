package com.example.demo.Coll;

import com.example.demo.bo.ResponseVo;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import com.example.demo.po.initPo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@Api("用户相关接口")
public class demo {

    @Autowired
    private JdbcTemplate  jdbcs;


    @RequestMapping(value = "/index")
    @ApiOperation("查询用户信息接口")
    public  String querys(){
        System.out.println("======================查询=========================");

        List<Map<String, Object>> list   =jdbcs.queryForList("select * from users ");
        for (int i=0;i<list.size();i++){
            System.out.println( list.get(i).get("id"));
            System.out.println( list.get(i).get("names"));
            System.out.println( list.get(i).get("age"));
            System.out.println( list.get(i).get("user"));
            System.out.println( list.get(i).get("password"));
        }
        System.out.println("======================查询结束=========================");
        return "123";
    }


    @RequestMapping(value="/updates")
    @ApiOperation("修改用户信息接口")
    public String updates(){

        System.out.println("======================修改开始=========================");
        int count = jdbcs.update("update users set names ='修改以后的姓名' where id='1'");
        System.out.println(count);

        System.out.println("======================修改结束=========================");
        return "";
    }



    @RequestMapping(value = "/indexQueryPo",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("po查询用户信息接口")
    public ResponseVo<List<initPo>> queryspo(@RequestBody initPo bo, HttpServletRequest request){
        ResponseVo<List<initPo>> vo = new ResponseVo<List<initPo>>();
        System.out.println("======================查询=========================");

        String service = request.getRequestURI(); // 路径
        List<Map<String, Object>> list   =jdbcs.queryForList("select * from users ");
        List<initPo> init = new ArrayList<>();
        for (int i=0;i<list.size();i++){
            initPo ints=new initPo();
            ints.setAge(list.get(i).get("age").toString());
            ints.setId(list.get(i).get("id").toString());
            ints.setNamnes(list.get(i).get("names").toString());
            ints.setUser(list.get(i).get("user").toString());
            ints.setPassword(list.get(i).get("password").toString());
            init.add(ints);
        }
        vo.setReturnVoList(init);
        System.out.println("======================查询结束=========================");
        return vo.success(service);
    }

}
