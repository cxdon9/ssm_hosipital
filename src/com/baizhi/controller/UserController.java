package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("selectByName")
    public String selectByName(User user, HttpSession session) {
        System.out.println("接受到的用户 " + user);
        User u1 = userService.selectByName(user);
        if (u1 != null) {
            session.setAttribute("user", u1);
            return "redirect:/dept/select.do";
        } else {
            session.setAttribute("error", "密码或用户名错误");
            return "redirect:index.jsp";
        }
    }


}
