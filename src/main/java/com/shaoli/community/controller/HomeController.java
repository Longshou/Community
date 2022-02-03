package com.shaoli.community.controller;

import com.shaoli.community.entity.DiscussPost;
import com.shaoli.community.entity.Page;
import com.shaoli.community.entity.User;
import com.shaoli.community.service.DiscussPostService;
import com.shaoli.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    //指定控制器处理URL请求
    @RequestMapping(path = "/index",method = RequestMethod.GET)
    //Model携带数据给模板
    public String getIndexPage(Model model, Page page) {
        //方法调用前，SpringMVC会自动实例化Model和Page，并将Page注入Model.
        //所以在thymeleaf中可以直接访问page对象中的数据.
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");
        //controller->service->Dao
       List <DiscussPost> list = discussPostService.findDiscussPosts(0,page.getOffset(),page.getLimit());
       List<Map<String,Object>> discussPosts = new ArrayList<>();
       if (list != null)
       {
           for (DiscussPost post:list)
           {
               Map<String,Object> map = new HashMap<>();
               //put(K key,V value)
               // key：是要保存到 Map 集合中的键名。
               //value：是要保存到 Map 集合中对应键名的键值对象。
               map.put("post",post);
               User user = userService.findUserById(post.getUserId());
               map.put("user",user);
               discussPosts.add(map);
           }
       }
        //传递参数给前台，用${}获取
       model.addAttribute ("discussPosts",discussPosts);
       //返回给模板的路径
        return "/index";
    }


}
