package controller;

import javabean.Chaoqiezi;
import javabean.Chushi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: jurui
 * @Email: acescen@foxmail.com
 * @ProjectName: txjg1
 * @Package: controller
 * @Description:
 * @Date: Created in 14:50 2019-12-25
 */
@WebServlet(name="FormatServlet", urlPatterns= {"/cook"})
public class Fuwuyuan extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        Chushi chushi = new Chushi();
        Chaoqiezi chaoqiezi = chushi.cookEggplant();
        if (chaoqiezi != null) {
            request.getSession().setAttribute("msg", "上一道" + chaoqiezi.toString() + "菜品");
        } else {
            request.getSession().setAttribute("msg","厨房没有茄子了");
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        this.doGet(httpServletRequest,httpServletResponse);
    }

}
