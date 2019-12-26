import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: jurui
 * @Email: acescen@foxmail.com
 * @ProjectName: txjg5
 * @Package: PACKAGE_NAME
 * @Description:
 * @Date: Created in 11:13 2019-12-26
 */
public class StudentView {
    private static StudentModel studentModel;

    static {
        studentModel = new StudentModel();
    }

    public void showStus() {
        List<StudentModel> students = StudentModel.getStudents();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
                + "的学生信息为:"
        );
        for (StudentModel studentModel : students) {
            System.out.print("姓名:" + studentModel.getStuName()+"   ");
            System.out.print("学号:" + studentModel.getStuNumber()+"   ");
            System.out.print("年龄:" + studentModel.getAge());
            System.out.println();
        }

    }
}
