import java.util.Scanner;

class Exception1 extends Exception {
    public Exception1(String msg) { super(msg); }
}
class Exception2 extends Exception {
    public Exception2(String msg) { super(msg); }
}
class Exception3 extends Exception {
    public Exception3(String msg) { super(msg); }
}

public class Expr6_3 {
    public static void main(String[] args) {
        System.out.println("根据输入数字模拟场景：");
        System.out.println("除0~3以外数字(无异常)");
        System.out.println("0(退出)");
        System.out.println("1(Exception1)");
        System.out.println("2(Exception2)");
        System.out.println("3(Exception3)");
        Scanner sc=new Scanner(System.in);
        int i;
        while (true) {
            i = Integer.parseInt(sc.nextLine());
            if (i==0)
                break;
            try {
                method1(i);
                System.out.println("执行 statement2 (main)");
            } catch (Exception e) {
                System.out.println("⚠️ main 方法捕获了未处理的异常: " + e.getClass().getSimpleName());
            }
        }
        System.out.println("已退出模拟");
        sc.close();
    }

    public static void method1(int kindOfException) throws Exception {
        try {
            System.out.println("进入 method1...");
            method2(kindOfException);
            System.out.println("执行 statement3 (method1)");
        } catch (Exception2 ex2) {
            System.out.println("处理 ex2 (method1): Process ex2");
        }
        System.out.println("执行 statement4 (method1)");
    }

    public static void method2(int kindOfException) throws Exception {
        try {
            System.out.println("进入 method2...");
            method3(kindOfException);
            System.out.println("执行 statement5 (method2)");
        } catch (Exception3 ex3) {
            System.out.println("处理 ex3 (method2): Process ex3");
        }
        System.out.println("执行 statement6 (method2)");
    }


    public static void method3(int kindOfException) throws Exception {
        System.out.println("进入 method3...");
        if (kindOfException<1||kindOfException>3)
            return;
        System.out.println("在 method3 中抛出异常...");

        // 根据传入的场景参数抛出不同类型的异常
        if (kindOfException == 1) {
            throw new Exception1("Exception1");
        } else if (kindOfException == 2) {
            throw new Exception2("Exception2");
        } else if (kindOfException == 3) {
            throw new Exception3("Exception3");
        }
    }
}
