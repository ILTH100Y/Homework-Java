import java.util.Scanner;

public class Expr1_4 {

    static class inti_couple{
        public int front;
        public int later;
    }

    public static void produce(int n,inti_couple c){
        int a=0,b=0;
        for(int i=1;i<n;i++)
            if(n%i==0)
                a+=i;
        for(int i=1;i<a;i++)
            if(a%i==0)
                b+=i;
        if(b==n&&a!=b)
        {
            if (a>b) {
                int temp=a;
                a=b;
                b=temp;
            }
            c.front=a;
            c.later=b;
        }
    }


    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.close();
        inti_couple[] arr1=new inti_couple[n-1];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = new inti_couple();
        }
        int count = 0;
        for (int i = 2; i <= n; i++) {
            inti_couple temp = new inti_couple();
            produce(i, temp);

            if (temp.front != 0) {
                boolean duplicate = false;
                for (int k = 0; k < count; k++) {
                    if (arr1[k].front == temp.front) {
                        duplicate = true;
                        break;
                    }
                }
                if (!duplicate) {
                    arr1[count].front = temp.front;
                    arr1[count].later = temp.later;
                    count++;
                }
            }
        }
        if(count==0)
            System.out.println("无亲密数对");
        else for (int i=0;i<count;i++)
            System.out.println(arr1[i].front+" "+arr1[i].later);
    }
}
