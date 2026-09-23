import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class ScoreOutOfRangeException extends Exception{
    public ScoreOutOfRangeException(){
        super();}
}

class StudentScore{
    private String course;
    private double score;

    public StudentScore(String course,double score) throws ScoreOutOfRangeException {
        this.course = course;
        double temp = score;
        temp = (int)(temp*100)/100.0;
        if(temp<0||temp>100)
                throw new ScoreOutOfRangeException();
        this.score = temp;
    }

    public double getScore() {
        return score;
    }
}

public class Expr6_2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n;
        while (true){
            try {
                System.out.println("请输入需要录入课程的门数");
                n=Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("输入错误，请重新输入");
                continue;
            }
        }
        ArrayList<StudentScore> s=new ArrayList<>();
        System.out.println("提示：分数限制在0~100以内,且请输入阿拉伯数字");
        for (int i=0;i<n;i++) {
            System.out.println("请输入需要录入课程的名称");
            String temp1 = sc.nextLine();
            for (int j = 0; j < 3; j++) {
                System.out.println("请输入需要录入课程的分数");
                try {
                    double temp2 = sc.nextDouble();
                    sc.nextLine();
                    StudentScore student=new StudentScore(temp1, temp2);
                    s.add(student);
                } catch (InputMismatchException e) {
                    System.out.println("输入的成绩不是数字，请重新输入，剩余"+(2-j)+"次,否则跳过该课程。");
                    sc.nextLine();
                    continue;
                } catch (ScoreOutOfRangeException e) {
                    System.out.println("输入的成绩超出范围，请重新输入，剩余"+(2-j)+"次,否则跳过该课程。");
                    continue;
                }
                break;
            }
        }
        sc.close();
        if (s.size()==0){
            System.out.println("未录入课程");
            return;
        }
        double sum=0;
        for (int i=0;i<s.size();i++)
            sum+=s.get(i).getScore();
        System.out.println("共成功录入"+s.size()+"门，平均成绩为"+(int)((sum/s.size())*100)/100.0 );
    }
}
