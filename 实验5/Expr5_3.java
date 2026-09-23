import java.util.ArrayList;

class PrinterQueue extends ArrayList<String>{
    public void addFileToPrint(String fileName){
        add(fileName);
    }

    public boolean isEmpty(){
        return size()==0;
    }
    public String print(){
        if (isEmpty())
            return "目前无打印任务";
        String temp=get(0);
        remove(0);
        return temp;
    }

    public int getSize(){
        return size();
    }
}

public class Expr5_3 {
    public static void main(String[] args) {
        PrinterQueue printerQueue = new PrinterQueue();
        printerQueue.addFileToPrint("java-基本程序设计、选择、循环");
        printerQueue.addFileToPrint("java-一维数组");
        printerQueue.addFileToPrint("java-对象和类");
        printerQueue.addFileToPrint("java-面向对象——继承");

        System.out.println("待打印文件： " + printerQueue );
        System.out.println("待打印文件数量为：" + printerQueue.getSize());

        System.out.println("\n打印操作：");
        while (!printerQueue.isEmpty()) {
            String file = printerQueue.print();
            System.out.println("打印文件：" + file);
        }
    }
}
