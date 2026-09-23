import java.util.Scanner;

public class Expr2_3 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入数字");
        String line=sc.nextLine();
        int n=0;
        sc.close();
        for(int i=0;i<line.length();i++){
            int dight=line.charAt(i)-'0';
            n+=dight*dight;
        }
        while (n!=1&&n!=4){
            int h=n/100;
            int t=(n-100*h)/10;
            int u=n%10;
            n=h*h+t*t+u*u;
        }
        System.out.println(n == 1 ? "是幸运数字" : "不是幸运数字");
    }
}
