package Solution;

public class PartTime extends Employee {
    private double rate;
    private double hoursWorked;

    public PartTime(EmployeeInfo info, double rate, double hoursWorked) {
        super(info.getId(), info.getName(), info.getVehicle());
        setRate(rate);
        setHoursWorked(hoursWorked);
    }

    @Override
    public double calculatePay() {
        return hoursWorked * rate;
    }

    public double getRate() { return rate; }

    public void setRate(double rate) {
        if (rate < 0) throw new IllegalArgumentException("Rate must be non-negative.");
        this.rate = rate;
    }

    public double getHoursWorked() { return hoursWorked; }

    public void setHoursWorked(double hoursWorked) {
        if (hoursWorked < 0) throw new IllegalArgumentException("Hours worked must be non-negative.");
        this.hoursWorked = hoursWorked;
    }
}
