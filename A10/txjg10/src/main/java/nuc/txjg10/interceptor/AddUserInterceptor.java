package nuc.txjg10.interceptor;

import com.alibaba.fastjson.JSON;
import nuc.txjg10.annotation.AddUser;
import nuc.txjg10.domain.Record;
import nuc.txjg10.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.function.ServerResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: jurui
 * @Email: acescen@foxmail.com
 * @ProjectName: txjg10
 * @Package: nuc.txjg10.interceptor
 * @Description:
 * @Date: Created in 14:56 2019-12-26
 */
public class AddUserInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        //设置编码格式
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 判断接口是否需要登录
        AddUser methodAnnotation = method.getAnnotation(AddUser.class);

        // 有 @Adduser 注解，需要认证
        if (methodAnnotation != null) {
            String name = request.getParameter("name");
            String sex = request.getParameter("sex");
            String phoneNum = request.getParameter("phoneNum");
            String idCard = request.getParameter("idCard");
            //添加到记录
            Record record = new Record();
            record.setSex(sex);
            record.setIdCard(idCard);
            record.setName(name);
            record.setOptionTime(new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()));
            record.setPhoneNum(phoneNum);
            //TODO 判断姓名合法性
            if (StringUtils.isBlank(name)) {
                request.setAttribute("msg","拦截器拦截，添加失败，姓名为空");
                record.setMsg("添加失败，姓名为空");
                Record.records.add(record);
                return true;
            }
            //TODO 判断性别合法性
            if (StringUtils.isBlank(sex)) {

                request.setAttribute("msg","拦截器拦截，添加失败，性别为空");
                record.setMsg("添加失败，性别为空");
                Record.records.add(record);
                return true;
            }

            System.out.println(sex);
            if (!"男".equals(sex) && !"女".equals(sex)) {
                request.setAttribute("msg","拦截器拦截，添加失败，性别不合法");
                record.setMsg("添加失败，性别不合法");
                Record.records.add(record);
                return true;
            }
            //TODO 判断手机号合法性
            String phoneNumregex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
            if (phoneNum.length() != 11) {
                request.setAttribute("msg","拦截器拦截，添加失败，手机号非法");
                record.setMsg("添加失败，手机号非法");
                Record.records.add(record);
                return true;
            }
            Pattern p = Pattern.compile(phoneNumregex);
            Matcher m = p.matcher(phoneNum);
            if (!m.matches()) {
                request.setAttribute("msg","拦截器拦截，添加失败，手机号非法");
                record.setMsg("添加失败，手机号非法");
                Record.records.add(record);
                return true;
            }

            if (StringUtils.isBlank(idCard)) {
                request.setAttribute("msg","拦截器拦截，添加失败，身份证号为空");
                record.setMsg("添加失败，身份证号为空");
                Record.records.add(record);
                return true;
            }

            //TODO 判断身份证号合法性
            // 定义判别用户身份证号的正则表达式（15位或者18位，最后一位可以为字母）
            String regularExpression = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
                    "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";

            boolean matches = idCard.matches(regularExpression);
            if (matches) {
                if (idCard.length() == 18) {
                    try {
                        char[] charArray = idCard.toCharArray();
                        //前十七位加权因子
                        int[] idCardWi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
                        //这是除以11后，可能产生的11位余数对应的验证码
                        String[] idCardY = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
                        int sum = 0;
                        for (int i = 0; i < idCardWi.length; i++) {
                            int current = Integer.parseInt(String.valueOf(charArray[i]));
                            int count = current * idCardWi[i];
                            sum += count;
                        }
                        char idCardLast = charArray[17];
                        int idCardMod = sum % 11;
                        if (idCardY[idCardMod].toUpperCase().equals(String.valueOf(idCardLast).toUpperCase())) {
                            matches = true;
                        } else {
                            System.out.println("身份证最后一位:" + String.valueOf(idCardLast).toUpperCase() +
                                    "错误,正确的应该是:" + idCardY[idCardMod].toUpperCase());
                            matches = false;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("异常:" + idCard);
                        matches = false;
                    }
                }
            }

            if (!matches) {
                request.setAttribute("msg","拦截器拦截，添加失败，身份证号非法");
                record.setMsg("添加失败，身份证号非法");
                Record.records.add(record);
                return true;
            }

            //TODO 判断身份证号是否存在
            for (User user : User.users) {
                if (user.getIdCard().equals(idCard)) {
                    request.setAttribute("msg","拦截器拦截，添加失败，此身份证号已经存在");
                    record.setMsg("添加失败，此身份证号已经存在");
                    Record.records.add(record);
                    return true;
                }
            }


            //TODO 判断身份证号是否与性别相符
            String testSex = idCard.substring(16, 17);
            int b = Integer.parseInt(testSex);
            System.out.println(b);
            if (b % 2 == 0) {
                if (!"女".equals(sex)) {
                    request.setAttribute("msg","拦截器拦截，添加失败，身份证号与性别不相符");
                    record.setMsg("添加失败，身份证号与性别不相符");
                    Record.records.add(record);
                    return true;
                }
            } else {
                if (!"男".equals(sex)) {
                    request.setAttribute("msg","拦截器拦截，添加失败，身份证号与性别不相符");
                    record.setMsg("添加失败，身份证号与性别不相符");
                    Record.records.add(record);
                    return true;
                }
            }

            request.setAttribute("msg","1");
            record.setMsg("通过校验，添加成功");
            Record.records.add(record);
            return true;
        }
        return true;
    }

}
