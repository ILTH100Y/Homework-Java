import java.util.Scanner;

class MovieTicket{
    private String movieName;
    private double price;
    public static int count=0;
    public MovieTicket(){
        count++;
    }
    public MovieTicket(String name){
        movieName=name;
        count++;
    }
    public MovieTicket(String name,double num){
        movieName=name;
        price=num;
        count++;
    }
    void getFinalPrice(){
        System.out.println("【Original Price】Final ticket price is: "+price);
    }
    void getFinalPrice(double discount){
        price=((int)(price*discount*100))/100.00;
        System.out.println("【Discount】Final ticket price is: "+price);
    }
    void getFinalPrice(double discount,double coupon){
        price=((int)((price-coupon)*discount*100))/100.00;
        System.out.println("【Discount + Coupon】Final ticket price is: "+price);
    }
}

public class Expr3_2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter the name of movie");
        String name=sc.nextLine();
        System.out.println("Please enter the price of movie");
        double num= Double.parseDouble(sc.nextLine());
        MovieTicket ticket = new MovieTicket(name, num);

        System.out.println("\nPlease select the pricing method:");
        System.out.println("1. Original Price");
        System.out.println("2. Discount");
        System.out.println("3. Discount + Coupon");
        System.out.print("Please enter your choice (1/2/3): ");
        
        int choice=Integer.parseInt(sc.nextLine());
        switch (choice){
            case 1:
                ticket.getFinalPrice();break;
            case 2:
                System.out.println("Please enter the discount");
                double discount=Double.parseDouble(sc.nextLine());
                ticket.getFinalPrice(discount);break;
            case 3:
                System.out.println("Please enter the discount and coupon");
                double discount2=Double.parseDouble(sc.nextLine());
                double coupon=Double.parseDouble(sc.nextLine());
                ticket.getFinalPrice(discount2,coupon);break;
            default:
                System.out.println("Error,you enter a wrong number.");
        }
        System.out.println("Number of MovieTicket objects created: "+MovieTicket.count);
        sc.close();
    }
}
