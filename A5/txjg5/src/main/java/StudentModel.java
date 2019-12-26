import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jurui
 * @Email: acescen@foxmail.com
 * @ProjectName: txjg5
 * @Package: PACKAGE_NAME
 * @Description:
 * @Date: Created in 11:13 2019-12-26
 */
public class StudentModel {
    private static List<StudentModel> students;
    private String stuName;
    private String stuNumber;
    private String age;
    static {
        students = new ArrayList<StudentModel>();
    }


    public static List<StudentModel> getStudents() {
        return students;
    }

    public void addStudent(StudentModel studentModel) {
        students.add(studentModel);
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
