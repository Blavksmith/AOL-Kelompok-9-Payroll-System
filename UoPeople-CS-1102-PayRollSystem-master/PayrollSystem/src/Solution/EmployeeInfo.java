package Solution;

public class EmployeeInfo {
    private int id;
    private String name;
    private Vehicle vehicle;

    public EmployeeInfo(int id, String name, Vehicle vehicle) {
        this.id = id;
        this.name = name;
        this.vehicle = vehicle;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public Vehicle getVehicle() { return vehicle; }
}
