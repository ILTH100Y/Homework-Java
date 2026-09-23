import java.util.Random;
import java.util.Scanner;

public class Expr1_2 {
    public static int expr(){
     int sum=0;
     for(int i=0;i<3;i++)
         sum+=(1+(int)(6* Math.random()));
     return sum;
    }
    public static void main(String[] args){
        int n;
        System.out.println("请输入模拟次数");
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int[] arr=new int[16];
        for(int i=0;i<n;i++) {
            int temp=expr();
            arr[temp-3]++;
        }
        int sum=0;
        for(int i=0;i<arr.length;i++){
            System.out.println((i+3)+":"+arr[i]+"次，概率为"+arr[i]/(double)n);
        }
    }
}
