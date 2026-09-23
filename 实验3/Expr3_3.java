import java.util.Scanner;

class Snack{
    private String Name;
    private double price;
    private int number;
    public Snack(String n,double d,int i){
        Name=n;
        price=d;
        number=i;
    }
    double getTotalPrice(){
        return price*number;
    }
    String getName(){
        return Name;
    }
    void showInfo(){
        System.out.println("名称："+Name);
        System.out.println("共"+number+"个，单价为"+price+"元");
    }
}

public class Expr3_3 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入零食总种数");
        int num_kind= Integer.parseInt(sc.nextLine());
        if(num_kind<=0){
            System.out.println("无零食");
            return;
        }
        Snack[] all=new Snack[num_kind];
        System.out.println("每次输入完都请用回车切换");
        for(int i=0;i<num_kind;i++){
            System.out.println("请输入零食名、单价、数量");
            String name=sc.nextLine();
            double price=Double.parseDouble(sc.nextLine());
            int num=Integer.parseInt(sc.nextLine());
            all[i]=new Snack(name,price,num);
        }
        double sum=0;
        int max=0;
        for(int i=0;i<num_kind;i++){
            all[i].showInfo();
            double temp=all[i].getTotalPrice();
            sum+=temp;
            if(temp>all[max].getTotalPrice())
                max=i;
        }
        System.out.println("所有零食总价为"+sum+"元");
        System.out.println("具有最高总价的零食为"+all[max].getName());
        sc.close();
    }
}
