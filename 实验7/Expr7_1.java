import java.util.Scanner;

public class Expr7_1 {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.println("请输入昵称");
        String s1=sc.nextLine();
        sc.close();
        String s2=s1.trim();
        String s3=s2.replaceAll("\\s+","_");
        System.out.println("整理后的昵称:"+s3);
        System.out.println("大写形式:"+s3.toUpperCase());
        System.out.println("小写形式:"+s3.toLowerCase());
        System.out.println("长度:"+s3.length());
        boolean r=true;
        int letterCount=0;
        int numCount=0;
        for(int i=0;i<s3.length();i++){
            if(Character.isLetter(s3.charAt(i)))
                letterCount++;
            else if(Character.isDigit(s3.charAt(i)))
                numCount++;
            else if (s3.charAt(i)!='_')
                r=false;
        }
        if (s3.length()<4||s3.length()>12)
            r=false;
        if (!Character.isLetter(s3.charAt(0)))
            r=false;
        System.out.println("字母个数:"+letterCount);
        System.out.println("数字个数:"+numCount);
        System.out.println("昵称"+(r?"合格":"不合格"));
    }
}
