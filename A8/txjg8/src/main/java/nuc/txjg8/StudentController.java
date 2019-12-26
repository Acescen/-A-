package nuc.txjg8;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Author: jurui
 * @Email: acescen@foxmail.com
 * @ProjectName: txjg8
 * @Package: nuc.txjg8
 * @Description:
 * @Date: Created in 11:46 2019-12-26
 */
@Controller
public class StudentController {

    @RequestMapping("/show")
    public String showStus(Model model) {
        List<StudentModel> students = StudentModel.getStudents();

        model.addAttribute("students", students);
        return "studentView";
    }

    @RequestMapping("/addstu")
    public String addstu() {
        StudentModel stu = new StudentModel();
        stu.setStuName("学生"+new Random().nextInt(15)+"号");
        stu.setAge(""+(15+new Random().nextInt(6)));
        stu.setStuNumber(""+(1000+new Random().nextInt(100)));
        StudentModel.addStudent(stu);

        return "redirect:/show";
    }
}
