package controller;

import dao.UserDao;
import javabean.Record;
import javabean.User;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: jurui
 * @Email: acescen@foxmail.com
 * @ProjectName: txjg1
 * @Package: controller
 * @Description:
 * @Date: Created in 14:50 2019-12-25
 */
@WebServlet(name = "FormatServlet", urlPatterns = {"/addUser"})
public class UserServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        UserDao userDao = new UserDao();

        if (StringUtils.isBlank(username) || StringUtils.isBlank(name) || StringUtils.isBlank(password)) {
            request.setAttribute("msg", "请完整输入！");
        } else {
            User user = new User(username, name, password);
            boolean flag = userDao.add(user);

            if (flag) {
                request.setAttribute("msg", "添加成功！");
            } else {
                request.setAttribute("msg", "添加失败！");

            }
        }

        List<User> users = userDao.getUserList();
        List<Record> records = userDao.getRecordList();
        request.setAttribute("users", users);
        request.setAttribute("records", records);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        this.doGet(httpServletRequest, httpServletResponse);
    }

}
