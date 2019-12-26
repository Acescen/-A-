package nuc.txjg10.controller;

import nuc.txjg10.annotation.AddUser;
import nuc.txjg10.domain.Record;
import nuc.txjg10.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: jurui
 * @Email: acescen@foxmail.com
 * @ProjectName: txjg10
 * @Package: nuc.txjg10.controller
 * @Description:
 * @Date: Created in 15:05 2019-12-26
 */
@Controller
public class UserController {

    @RequestMapping({"/","index"})
    public String index(Model model) {
        model.addAttribute("users", User.users);
        model.addAttribute("records", Record.records);

        return "index";
    }


    @RequestMapping("/add")
    @AddUser
    public String addUser(HttpServletRequest request,User user) {
        String msg = (String) request.getAttribute("msg");
        System.out.println(msg);

        if ("1".equals(msg)) {
            User.users.add(user);
            request.getSession().setAttribute("msg", "通过校验，添加成功");
        } else {
            request.getSession().setAttribute("msg",msg);
        }

        return "redirect:/index";
    }
}
