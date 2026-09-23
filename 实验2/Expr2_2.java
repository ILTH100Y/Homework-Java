import java.util.Scanner;

public class Expr2_2{
    public static void main(String[] args) {
        System.out.println("请输入数组长度");
        int arr_length;
        Scanner sc = new Scanner(System.in);
        arr_length = sc.nextInt();
        int[] arr = new int[arr_length];
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();
        if (arr.length == 1) {      // 如果数组长度为 1，无需进入循环
            System.out.println("最长连续充能阶段起点下标：0");
            System.out.println("最长连续充能阶段终点下标：0");
            System.out.println("阶段长度：1");
            System.out.print("该阶段能量值为：" + arr[0]);
            return;
        }
        int maxStart=0, maxEnd=0, maxLength=1;      //最终起止下标、长度
        int Start=0, Length=1;
        for (int i = 1; i <= arr.length; i++) {
            if (i == arr.length || arr[i] <= arr[i - 1] ) {
                Length = i - Start;
                if (Length > maxLength) {
                    maxLength = Length;
                    maxStart = Start;
                    maxEnd = i - 1;
                }
                Start = i;
            }
        }
        System.out.println("最长连续充能阶段起点下标：" + maxStart);
        System.out.println("最长连续充能阶段终点下标：" + maxEnd);
        System.out.println("阶段长度：" + maxLength);
        System.out.print("该阶段能量值为：");
        for (int j = maxStart; j <= maxEnd; j++) {
            System.out.print(arr[j] + " ");
        }
    }
}
