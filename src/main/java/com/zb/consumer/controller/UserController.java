package com.zb.consumer.controller;


import com.zb.consumer.service.FeignService;
import com.zb.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private ServletContext servletContext;

    @Autowired
    FeignService feignService;

    @Value("${server.port}")
    String port;

    @RequestMapping("/buy")
    public String buy(){
        return userService.hiService(port);
    }


    @RequestMapping(value = "/list")
    public String  list(@RequestParam(required = false) String name, Model model){
        System.out.println("search:"+name);
        model.addAttribute("users",feignService.list(name));
        return "list";
    }

    @RequestMapping("/delete/{did}")
    @ResponseBody
    public String delete(@PathVariable("did")String id){
        System.out.println("delete:"+id);

        return feignService.delete(id);
    }

    @RequestMapping("/new")
    public String add(){
        return "new";
    }

    @RequestMapping("/save")
    public String save(@RequestParam Map map){
        System.out.println(map);
        System.out.println("新增:"+feignService.save(map));
        return "forward:/list";
    }

    @PostConstruct
    public void init(){
        System.out.println("获取角色列表");
        servletContext.setAttribute("roles",feignService.getAllRoles());
    }

}
