import java.util.Scanner;

public class Expr1_3 {
    public static boolean is_Reverse_equals(String a){
        StringBuilder s=new StringBuilder(a);
        String a_r=s.reverse().toString();
        boolean c=a.equals(a_r);
        return  c;
    }       //是否相等

    public static String add(String a){
        StringBuilder s=new StringBuilder(a);
        String a_r=s.reverse().toString();
        int m=Integer.parseInt(a);
        int n=Integer.parseInt(a_r);
        return Integer.toString(m+n);
    }       //与自身逆序相加

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String n=sc.nextLine();
        StringBuilder n_change=new StringBuilder();
        n_change.append(n);
        int count=0;
        if(is_Reverse_equals(n))
            System.out.println("n 已经是回文数，步数为0");
        else
        {
            while (!is_Reverse_equals(n_change.toString())) {
                count++;
                String temp = add(n_change.toString());
                System.out.println("第" + count + "步：" + n_change + "+" + n_change.reverse() + "=" + temp);
                n_change.delete(0, n_change.length());
                n_change.append(temp);
            }
            System.out.println("经过" + count + "步得到回文数：" + n_change);
        }
    }
}
