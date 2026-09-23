import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;

class StudentScore implements Comparable<StudentScore>{
    private String name;
    private long number;
    private double usualscore;
    private double finalscore;

    public StudentScore(long number, double finalscore, double usualscore, String name) {
        this.number = number;
        this.finalscore = finalscore;
        this.usualscore = usualscore;
        this.name = name;
    }

    public double score(){
        return 0.4*usualscore+0.6*finalscore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public double getUsualscore() {
        return usualscore;
    }

    public void setUsualscore(double usualscore) {
        this.usualscore = usualscore;
    }

    public double getFinalscore() {
        return finalscore;
    }

    public void setFinalscore(double finalscore) {
        this.finalscore = finalscore;
    }

    @Override
    public int compareTo(StudentScore other){
        if (this.score() > other.score()) return -1;
        if (this.score() < other.score()) return 1;

        if (this.finalscore > other.finalscore) return -1;
        if (this.finalscore < other.finalscore) return 1;

        return Long.compare(this.getNumber(), other.getNumber());
    }
}

public class Expr8_1 {

//    private static void swap(ArrayList<StudentScore> list, int i, int j) {
//        StudentScore temp = list.get(i);
//        list.set(i, list.get(j));
//        list.set(j, temp);
//    }
//
//    private static int hoarepartSort(ArrayList<StudentScore> arrayList,int low,int high){
//        StudentScore middle =arrayList.get(low+(high-low)/2);
//        int i=low-1;
//        int j=high+1;
//        while (true){
//            do {
//                ++i;
//            }while (arrayList.get(i).compareTo(middle)<0);
//            do {
//                --j;
//            }while (arrayList.get(j).compareTo(middle)>0);
//            if (i>=j)
//                return j;
//            swap(arrayList,i,j);
//        }
//    }
//
//    private static void StudentquickSort(ArrayList<StudentScore> arrayList,int low,int high) {
//        if (low < high) {
//            int p = hoarepartSort(arrayList, low, high);
//            StudentquickSort(arrayList, low, p);
//            StudentquickSort(arrayList, p + 1, high);
//        }
//    }

    public static void main(String[] args){
//        ArrayList<StudentScore> arrayList = new ArrayList<>();
//
//        arrayList.add(new StudentScore(2023001, 100.0, 100.0, "张三"));
//        arrayList.add(new StudentScore(2023002, 95.0, 90.0, "李四"));
//        arrayList.add(new StudentScore(2023003, 80.0, 95.0, "王五"));
//        arrayList.add(new StudentScore(2023004, 80.0, 80.0, "赵六"));
//        arrayList.add(new StudentScore(2023006, 80.0, 80.0, "孙七"));
//        arrayList.add(new StudentScore(2023005, 80.0, 80.0, "周八"));
//        arrayList.add(new StudentScore(2023007, 50.0, 60.0, "吴九"));
//        arrayList.add(new StudentScore(2023008, 0.0, 0.0, "郑十"));
//        StudentquickSort(arrayList,0,arrayList.size()-1);
//        for (StudentScore student : arrayList) {
//            System.out.printf("学号: %d, 姓名: %-5s, 平时成绩: %.1f, 项目成绩: %.1f, 总评成绩: %.1f%n",
//                    student.getNumber(),
//                    student.getName(),
//                    student.getUsualscore(),
//                    student.getFinalscore(),
//                    student.score());
//        }

        List<StudentScore> list = new ArrayList<>();

        list.add(new StudentScore(2023001, 100.0, 100.0, "张三"));
        list.add(new StudentScore(2023002, 95.0, 90.0, "李四"));
        list.add(new StudentScore(2023003, 80.0, 95.0, "王五"));
        list.add(new StudentScore(2023004, 80.0, 80.0, "赵六"));
        list.add(new StudentScore(2023006, 80.0, 80.0, "孙七"));
        list.add(new StudentScore(2023005, 80.0, 80.0, "周八"));
        list.add(new StudentScore(2023007, 50.0, 60.0, "吴九"));
        list.add(new StudentScore(2023008, 0.0, 0.0, "郑十"));
        list.sort(null);
        for (StudentScore student : list) {
            System.out.printf("学号: %d, 姓名: %-5s, 平时成绩: %.1f, 项目成绩: %.1f, 总评成绩: %.1f%n",
                    student.getNumber(),
                    student.getName(),
                    student.getUsualscore(),
                    student.getFinalscore(),
                    student.score());
        }
        System.out.printf("总评成绩最高的学生是%s，总评成绩为%.1f。",
                list.getFirst().getName(),
                list.getFirst().score());
    }
}

