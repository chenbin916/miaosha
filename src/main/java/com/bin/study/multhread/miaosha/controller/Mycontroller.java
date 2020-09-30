package com.bin.study.multhread.miaosha.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.bin.study.multhread.miaosha.service.MiaoshaService;

import javax.servlet.http.HttpServletRequest;


@RestController
public class Mycontroller {
    @Autowired
    MiaoshaService miaoshaService;


    @RequestMapping("/myapitest")
    public List<Map> myapitest(@RequestParam("id") int id) {
        return null;
    }

    //跳转首页
    @RequestMapping("/")
    public String index(ModelMap model, HttpServletRequest request)
    {

        String message="current server and port is : "+ request.getLocalAddr()+":"+ request.getLocalPort();
        model.put("message",message);
        return message;
    }

    //秒杀接口
    @RequestMapping("/miaosha")
    @ResponseBody
    public Object  miaosha(String goods_code,String user_id)
    {

        boolean res=false;
              for(int i=0;i<201;i++) {
                   res = miaoshaService.miaosha(goods_code, "tommy"+i);
              }
            System.out.println("秒杀结果："+res);
        return res;

    }
}