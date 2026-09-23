import java.util.Scanner;

public class Expr1_1 {
    public static void main(String[] args){
        int a,b,c;
        Scanner sc=new Scanner(System.in);
        a= sc.nextInt();
        b= sc.nextInt();
        c= sc.nextInt();
        sc.close();
        if(a>b)
        {
            int temp;
            temp=a;
            a=b;
            b=temp;
        }
        if(b>c)
        {
            int temp;
            temp=b;
            b=c;
            c=temp;
        }
        if(a>b)
        {
            int temp;
            temp=a;
            a=b;
            b=temp;
        }
        if((a+b)<=c||a<=0)
        {
            System.out.println("不是三角形");
            System.exit(0);
        }
        if(a==b&&b==c)
            System.out.println("等边三角形");
        else if((a==b||b==c||a==c)) {
            if ((c * c == (a * a + b * b)))
                System.out.println("等腰直角三角形");
            else
                System.out.println("等腰三角形");
        }
        else if ((c * c == (a * a + b * b)))
            System.out.println("直角三角形");
        else
            System.out.println("一般三角形");
    }
}
