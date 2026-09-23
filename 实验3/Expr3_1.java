import java.util.Scanner;

class Desklamp{
    String brand;
    boolean isOn;
    Desklamp(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter the brand,then enter the switch status(ture/false) after pressing enter.");
        brand=sc.nextLine();
        isOn=sc.nextBoolean();
        sc.close();
    }
    void turnOn(){
        isOn=true;
    }
    void turnOff(){
        isOn=false;
    }
    void showInof(){
        System.out.println(isOn);
    }
    void showBrand(){
        System.out.println(brand);
    }
}

public class Expr3_1 {
    public static void main(String[] args){
        Desklamp d1=new Desklamp();
        d1.turnOn();
        d1.showInof();
        d1.turnOff();
        d1.showInof();
        d1.showBrand();
    }

}
