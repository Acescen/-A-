import java.util.List;
import java.util.Random;

/**
 * @Author: jurui
 * @Email: acescen@foxmail.com
 * @ProjectName: txjg5
 * @Package: PACKAGE_NAME
 * @Description:
 * @Date: Created in 11:13 2019-12-26
 */
public class StudentController {
    private static StudentModel studentModel;
    private static StudentView studentView;

    static {
        studentModel = new StudentModel();
        studentView = new StudentView();
    }


    public void addStudent() {
        StudentModel stu = new StudentModel();
        stu.setStuName("学生"+new Random().nextInt(15)+"号");
        stu.setAge(""+(15+new Random().nextInt(6)));
        stu.setStuNumber(""+(1000+new Random().nextInt(100)));
        System.out.println("添加学生");
        studentModel.addStudent(stu);
        System.out.println("显示学生信息");
        studentView.showStus();
        System.out.println();
        System.out.println();
    }

}
