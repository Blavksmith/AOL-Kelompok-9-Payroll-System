package Solution;

//Code Smell 2: Dead Code
//Reason: Default constructor tidak digunakan sama sekali
//Solution: Remove Constructor

public abstract class Employee {
    private int empId;
    private String name;
    private Vehicle vehicle;
    
    public Employee(int pEmpId, String pName, Vehicle pV) {
        System.out.println("... inside Employee non-default constructor");
        empId = pEmpId;
        name = pName;
        this.vehicle = pV;
    }
    
    public Employee(int pEmpId, String pName, String pPlate, String pColour) {
        System.out.println("... inside Employee non-default constructor");
        empId = pEmpId;
        name = pName;
        this.vehicle = new Vehicle(pPlate, pColour);
    }
    
    public abstract double calculatePay();
    
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}