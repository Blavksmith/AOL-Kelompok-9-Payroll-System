package Solution;

public class FullTime extends Employee {
    private double salary;
    private double overtime;

    public FullTime(EmployeeInfo info, double salary, double overtime) {
        super(info.getId(), info.getName(), info.getVehicle());
        setSalary(salary);
        setOvertime(overtime);
    }

    @Override
    public double calculatePay() {
        return salary + overtime;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) throw new IllegalArgumentException("Salary must be non-negative.");
        this.salary = salary;
    }

    public double getOvertime() {
        return overtime;
    }

    public void setOvertime(double overtime) {
        if (overtime < 0) throw new IllegalArgumentException("Overtime must be non-negative.");
        this.overtime = overtime;
    }
}
