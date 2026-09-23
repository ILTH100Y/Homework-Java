import java.util.Scanner;

public class Expr6_1 {
    public static void LuckyNumber(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入数字");
        String temp=sc.nextLine();
//        for(int i=0;i<temp.length();i++)
//            if((temp.charAt(i)-'0')>9||(temp.charAt(i)-'0')<0)
//            throw new NumberFormatException();
        long num=Long.parseLong(temp);
        boolean isLucky=(num%7)==0;
        System.out.println("号码"+num+(isLucky?"是幸运号码":"不是幸运号码"));
        sc.close();
    }

    public static void main(String[] args){
        try {
            LuckyNumber();
        } catch (NumberFormatException e) {
            System.out.println("输入格式错误");
        }
    }
}
