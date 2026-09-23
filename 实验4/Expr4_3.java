import java.util.ArrayList;

class Employee {
    private String employeeId;
    private String name;
    private String department;

    public Employee(String employeeId, String name, String department) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
    }

    public double calculateSalary() {
        return 0.0;
    }

    public String getEmployeeInfo() {
        return "工号: " + employeeId + ", 姓名: " + name + ", 部门: " + department;
    }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;
    private double bonus;
    private int yearsOfService;

    public FullTimeEmployee(String employeeId, String name, String department, double monthlySalary, int yearsOfService, double bonus) {
        super(employeeId, name, department);
        this.monthlySalary = monthlySalary;
        this.bonus = bonus;
        this.yearsOfService = yearsOfService;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary + bonus + (yearsOfService * 500);
    }

    public void promote() {
        this.monthlySalary *= 1.2;
        System.out.println(getName() + " 晋升成功，月薪已上调20%。");
    }

    @Override
    public String getEmployeeInfo() {
        return super.getEmployeeInfo() + String.format(" | 类型: 全职 | 月薪: %.2f, 奖金: %.2f, 工龄: %d年", monthlySalary, bonus, yearsOfService);
    }

    public double getMonthlySalary() { return monthlySalary; }
    public void setMonthlySalary(double monthlySalary) { this.monthlySalary = monthlySalary; }
    public double getBonus() { return bonus; }
    public void setBonus(double bonus) { this.bonus = bonus; }
    public int getYearsOfService() { return yearsOfService; }
    public void setYearsOfService(int yearsOfService) { this.yearsOfService = yearsOfService; }
}

class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;
    private int maxHoursPerWeek;

    public PartTimeEmployee(String employeeId, String name, String department, double hourlyRate, double hoursWorked, int maxHoursPerWeek) {
        super(employeeId, name, department);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.maxHoursPerWeek = maxHoursPerWeek;
    }

    @Override
    public double calculateSalary() {
        if (hoursWorked <= maxHoursPerWeek) {
            return hourlyRate * hoursWorked;
        } else {
            double normalPay = hourlyRate * maxHoursPerWeek;
            double overtimePay = (hoursWorked - maxHoursPerWeek) * hourlyRate * 1.5;
            return normalPay + overtimePay;
        }
    }

    public void requestMoreHours(int additionalHours) {
        this.hoursWorked += additionalHours;
        System.out.println(getName() + " 申请增加 " + additionalHours + " 小时工时，当前总工时: " + this.hoursWorked);
    }

    @Override
    public String getEmployeeInfo() {
        return super.getEmployeeInfo() + String.format(" | 类型: 兼职 | 时薪: %.2f, 本周工时: %.1f, 最大工时: %d", hourlyRate, hoursWorked, maxHoursPerWeek);
    }

    public double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }
    public double getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(double hoursWorked) { this.hoursWorked = hoursWorked; }
    public int getMaxHoursPerWeek() { return maxHoursPerWeek; }
    public void setMaxHoursPerWeek(int maxHoursPerWeek) { this.maxHoursPerWeek = maxHoursPerWeek; }
}

class PayrollSystem {
    private ArrayList<Employee> employees;

    public PayrollSystem() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
        System.out.println("成功添加员工: " + emp.getName());
    }

    public void removeEmployee(String employeeId) {
        employees.removeIf(emp -> emp.getEmployeeId().equals(employeeId));
        System.out.println("成功移除工号为 " + employeeId + " 的员工。");
    }

    public double calculateTotalPayroll() {
        double total = 0;
        for (Employee emp : employees) {
            total += emp.calculateSalary();
        }
        return total;
    }

    public void generatePayrollReport() {
        System.out.println("\n========== 薪资报表 ==========");
        for (Employee emp : employees) {
            System.out.println(emp.getEmployeeInfo());
            System.out.printf("本月应发薪资: %.2f 元\n", emp.calculateSalary());
            System.out.println("---------------------------");
        }
        System.out.printf("【系统统计】公司本月总支出: %.2f 元\n", calculateTotalPayroll());
        System.out.println("==============================\n");
    }
}

public class Expr4_3 {
    public static void main(String[] args) {
        System.out.println("---------- 测试全职员工 (张三) ----------");
        FullTimeEmployee ftEmp = new FullTimeEmployee("FT001", "张三", "技术部", 8000, 3, 2000);
        System.out.println("初始薪资: " + ftEmp.calculateSalary()); // 8000+2000+1500 = 11500
        System.out.println(ftEmp.getEmployeeInfo());

        ftEmp.promote(); // 月薪变为 8000 * 1.2 = 9600
        System.out.println("晋升后薪资: " + ftEmp.calculateSalary()); // 9600+2000+1500 = 13100
        System.out.println(ftEmp.getEmployeeInfo());

        System.out.println("\n---------- 测试兼职员工 (李四) ----------");
        PartTimeEmployee ptEmp = new PartTimeEmployee("PT001", "李四", "市场部", 50, 25, 20);
        System.out.println("初始薪资: " + ptEmp.calculateSalary()); // 20*50 + 5*50*1.5 = 1000 + 375 = 1375
        System.out.println(ptEmp.getEmployeeInfo());

        ptEmp.requestMoreHours(10); // 工时变为 35
        System.out.println("增加工时后薪资: " + ptEmp.calculateSalary()); // 20*50 + 15*50*1.5 = 1000 + 1125 = 2125
        System.out.println(ptEmp.getEmployeeInfo());

        System.out.println("\n---------- 测试薪资管理系统 ----------");
        PayrollSystem payrollSystem = new PayrollSystem();
        payrollSystem.addEmployee(ftEmp);
        payrollSystem.addEmployee(ptEmp);

        payrollSystem.generatePayrollReport();
    }
}