import java.util.Scanner;

class Teacher {
    private String name;
    private String title;

    public Teacher(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public void showInfo() {
        System.out.println("姓名：" + name + "     职位：" + title);
    }
}

class Course {
    private String courseName;
    private Teacher teacher;

    public Course(String courseName, Teacher teacher) {
        this.courseName = courseName;
        this.teacher = teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void showInfo() {
        System.out.println("课程：" + courseName);
        System.out.print("任课教师：");
        teacher.showInfo();
    }
}

public class Expr3_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请依次输入课程名、老师的姓名、职位（按下回车切换）：");
        String courseName = sc.nextLine();
        String name = sc.nextLine();
        String title = sc.nextLine();

        Teacher initialTeacher = new Teacher(name, title);
        Course course_0 = new Course(courseName, initialTeacher);

        int option;
        System.out.println("\n操作种类：");
        System.out.println("1——查看课程信息");
        System.out.println("2——更换任课老师");
        System.out.println("3——查看当前老师姓名");
        System.out.println("0——退出程序");

        while (true) {
            System.out.println("请输入数字以执行操作：");
            option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:
                    course_0.showInfo();
                    break;
                case 2:
                    System.out.println("请依次输入新老师的姓名、职位：");
                    String newName = sc.nextLine();
                    String newTitle = sc.nextLine();
                    Teacher newTeacher = new Teacher(newName, newTitle);
                    course_0.setTeacher(newTeacher);
                    System.out.println("更换老师成功！");
                    break;
                case 3:
                    System.out.println("当前老师姓名：" + course_0.getTeacher().getName());
                    break;
                case 0:
                    sc.close();
                    System.out.println("程序已退出。");
                    return;
                default:
                    System.out.println("数字错误，请重新输入");
            }
        }
    }
}