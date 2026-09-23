import java.util.Scanner;

public class Expr2_1 {
    public static void main(String[] args){
        int[] arr=new int[12];
        Scanner sc=new Scanner(System.in);
        int count_minus,count_0,count_plus,sum;
        sum=count_minus=count_0=count_plus=0;
        System.out.println("请输入12个月的结余金额：");
        for(int i=0;i<12;i++) {
            arr[i] = sc.nextInt();
            sum+=arr[i];
            if(arr[i]<0)
                count_minus++;
            else if(arr[i]==0)
                count_0++;
            else
                count_plus++;
        }
        sc.close();
        int max_num=0;
        for(int i=0;i<12;i++)
            if(arr[i] > arr[max_num])
                max_num = i;
        System.out.println("结余最高月为"+(max_num+1)+"月，为"+arr[max_num]+"元");
        System.out.println(count_minus+"个月超支，"+count_0+"个月收支平衡，"+count_plus+"个月结余");
        System.out.println("全年共结余"+sum+"元");
    }

}
