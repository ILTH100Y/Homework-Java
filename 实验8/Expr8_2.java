import java.util.ArrayList;
import java.util.Collections;

class CoursePlan implements Cloneable{
    private String CourseName;
    private String TeacherName;
    private int weekhours;
    private ArrayList<String> tasks;

    public CoursePlan(String courseName, String teacherName, int weekhours) {
        CourseName = courseName;
        TeacherName = teacherName;
        this.weekhours = weekhours;
        tasks = new ArrayList<String>();
    }

    public void addtasks(String task){
        tasks.add(task);
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public int getWeekhours() {
        return weekhours;
    }

    public void setWeekhours(int weekhours) {
        this.weekhours = weekhours;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }

    public ArrayList<String> getTasks() {
        return tasks;
    }

    public void addTasks(String task) {
        this.tasks.add(task);
    }

    public void addTasks(String task,int n) {
        this.tasks.add(n,task);
    }

    public void setTasksByPosition(String task,int n) {
        this.tasks.set(n,task);
    }

    public void setTasksByName(String task1,String task2) {
        Collections.replaceAll(this.tasks,task1,task2);
    }

    public void removeTasks(int n) {
        this.tasks.remove(n);
    }

    @Override
    public CoursePlan clone() throws CloneNotSupportedException{
        CoursePlan cloned= (CoursePlan) super.clone();
        cloned.tasks = new ArrayList<>(this.tasks);
        return cloned;
    }
}

public class Expr8_2 {
    public static void main(String[] args) {
        try {
            CoursePlan originalPlan = new CoursePlan("Java程序设计", "张老师", 4);
            originalPlan.addTasks("预习");
            originalPlan.addTasks("实验");
            originalPlan.addTasks("项目答辩");

            CoursePlan clonedPlan = originalPlan.clone();

            clonedPlan.setCourseName("Java程序设计(进阶)");

            clonedPlan.setTasksByPosition("复习", 0);

            System.out.println("===== 验证普通字段与集合字段的复制效果 =====");
            System.out.println("原对象课程名称: " + originalPlan.getCourseName());
            System.out.println("副本课程名称: " + clonedPlan.getCourseName());
            System.out.println("-----------------------------------------");
            System.out.println("原对象的任务列表: " + originalPlan.getTasks());
            System.out.println("副本的任务列表: " + clonedPlan.getTasks());

            boolean isOriginalUnaffected = originalPlan.getCourseName().equals("Java程序设计")
                    && originalPlan.getTasks().get(0).equals("预习");

            if (isOriginalUnaffected) {
                System.out.println("\n✅ 测试通过！深拷贝成功，修改副本未影响原对象。");
            } else {
                System.out.println("\n❌ 测试失败！数据发生共享，修改副本影响了原对象。");
            }

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
