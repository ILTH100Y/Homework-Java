import java.util.List;
import java.util.ArrayList;

interface Evaluatable{
    double evaluate();
    default String getEvaluationLevel(){
        switch ((int)this.evaluate()/10){
            case 10:
            case 9: {
                return "优秀";
            }
            case 8:{
                return "良好";
            }
            case 7:{
                return "中等";
            }
            case 6:{
                return "合格";
            }
            default:
                return "不及格";
        }
    }
}

abstract class CampusPerson{
    protected String name;
    protected long number;
    protected String position;

    public CampusPerson(long number, String name, String position) {
        this.number = number;
        this.name = name;
        this.position = position;
    }

    public abstract String getRole();
    public abstract void showInfo();
}

class Student extends CampusPerson{
    private String major;
    private int grade;

    public Student(long number, String name, String position, String major, int grade) {
        super(number, name, position);
        this.major = major;
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String getRole(){
        return "学生";
    }

    @Override
    public void showInfo(){
        System.out.printf("学生姓名：%s,编号：%d，所属单位：%s，专业：%s，年级：第%d级。",
                name,number,position,major,grade);
    }
}

class Teacher extends CampusPerson implements Evaluatable {
    private double coursescore;
    private double scientific_researchscore;

    public Teacher(long number, String name, String position, double coursescore, double scientific_researchscore) {
        super(number, name, position);
        this.coursescore = coursescore;
        this.scientific_researchscore = scientific_researchscore;
    }

    public double getcoursescore() {
        return coursescore;
    }

    public void setcoursescore(double coursescore) {
        this.coursescore = coursescore;
    }

    public double getScientific_researchscore() {
        return scientific_researchscore;
    }

    public void setScientific_researchscore(double scientific_researchscore) {
        this.scientific_researchscore = scientific_researchscore;
    }
    
    @Override
    public String getRole(){
        return "老师";
    }
    
    @Override
    public void showInfo(){
        System.out.printf("老师姓名：%s,编号：%d，所属单位：%s，课程评分：%.2f，科研评分：%.2f。",
                name,number,position,coursescore,scientific_researchscore);
    }
    
    @Override
    public double evaluate(){
        return 0.6*scientific_researchscore+0.4*coursescore;
    }
}

class Staff extends CampusPerson implements Evaluatable{
    private double attitudescore;
    private double efficiencyscore;

    public Staff(long number, String name, String position, double attitudescore, double efficiencyscore) {
        super(number, name, position);
        this.attitudescore = attitudescore;
        this.efficiencyscore = efficiencyscore;
    }

    public double getAttitudescore() {
        return attitudescore;
    }

    public void setAttitudescore(double attitudescore) {
        this.attitudescore = attitudescore;
    }

    public double getEfficiencyscore() {
        return efficiencyscore;
    }

    public void setEfficiencyscore(double efficiencyscore) {
        this.efficiencyscore = efficiencyscore;
    }

    @Override
    public double evaluate(){
        return 0.4*attitudescore+0.6*efficiencyscore;
    }

    @Override
    public String getRole(){
        return "后勤人员";
    }

    @Override
    public void showInfo(){
        System.out.printf("后勤人员姓名：%s,编号：%d，所属单位：%s，服务态度评分：%.2f，效率评分：%.2f。",
                name,number,position,attitudescore,efficiencyscore);
    }
}

public class Expr8_4 {
    public static void main(String[] args) {
        List<CampusPerson> campusList = new ArrayList<>();
        campusList.add(new Student(2023001, "张三", "计算机学院", "软件工程", 2023));
        campusList.add(new Teacher(10086, "李四", "计算机学院", 85.0, 92.0));
        campusList.add(new Staff(20015, "王五", "后勤集团", 95.0, 88.0));
        campusList.add(new Student(2023002, "赵六", "数学学院", "应用数学", 2023));
        campusList.add(new Teacher(10087, "孙七", "理学院", 78.0, 65.0));

        System.out.println("===== 校园人员信息展示与评价系统 =====");
        for (CampusPerson person : campusList) {
            person.showInfo();

            if (person instanceof Evaluatable) {
                Evaluatable evaluatable = (Evaluatable) person;
                double score = evaluatable.evaluate();
                String level = evaluatable.getEvaluationLevel();
                System.out.printf("【评价结果】综合得分：%.2f，评价等级：%s%n", score, level);
            } else {
                System.out.println("【评价结果】该对象不参与评价");
            }
            System.out.println("-----------------------------------------");
        }
    }
}
