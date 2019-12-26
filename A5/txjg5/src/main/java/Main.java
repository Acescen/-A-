/**
 * @Author: jurui
 * @Email: acescen@foxmail.com
 * @ProjectName: txjg5
 * @Package: PACKAGE_NAME
 * @Description:
 * @Date: Created in 11:31 2019-12-26
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        StudentController studentController = new StudentController();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(2000);
            studentController.addStudent();
        }
    }
}
