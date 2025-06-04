package Solution;

import java.util.ArrayList;
import java.util.Scanner;

public class PayrollSystem {

    public static void main(String[] args) {
        ArrayList<Employee> arrEmp = new ArrayList<Employee>();
        byte menuOption;

        do {
            menuOption = showMenu();
            switch (menuOption) {
                case 1:
                    FullTime ft = readNewFullTime();
                    addEmployee(arrEmp, ft);
                    break;
                case 2:
                    PartTime pt = readNewPartTime();
                    addEmployee(arrEmp, pt);
                    break;
                case 3:
                    calcPayroll(arrEmp);
                    break;
                default:
                    break;
            }
        } while (menuOption != 4);
    }

    public static byte showMenu() {
        Scanner kbd = new Scanner(System.in);
        System.out.println("""
                /* *************************************************/
                /* 1. Add FullTime                                */
                /* 2. Add PartTime                                */
                /* 3. Calculate Payroll                           */
                /* 4. Exit                                        */
                /* *************************************************/""");
        System.out.print("Input: ");
        return kbd.nextByte();
    }

    public static void addEmployee(ArrayList<Employee> pArrEmp, Employee pEmp) {
        pArrEmp.add(pEmp);
    }

    public static FullTime readNewFullTime() {
        EmployeeInfo empInfo = readEmployeeInfo();
        double sal = readDouble("Enter Salary: ");
        double bonus = readDouble("Enter Bonus: ");
        return new FullTime(empInfo, sal, bonus);
    }

    public static PartTime readNewPartTime() {
        EmployeeInfo empInfo = readEmployeeInfo();
        double rate = readDouble("Enter Hourly Rate: ");
        double hoursWorked = readDouble("Enter Number of Hours Worked: ");
        return new PartTime(empInfo, rate, hoursWorked);
    }
    
    public static EmployeeInfo readEmployeeInfo() {
        int id = readInt("Enter Id: ");
        String name = readString("Enter Name: ");
        Vehicle vehicle = getVehicle();
        return new EmployeeInfo(id, name, vehicle);
    }

    private static int readInt(String prompt) {
        System.out.print(prompt);
        return new Scanner(System.in).nextInt();
    }

    private static double readDouble(String prompt) {
        System.out.print(prompt);
        return new Scanner(System.in).nextDouble();
    }

    private static String readString(String prompt) {
        System.out.print(prompt);
        return new Scanner(System.in).next();
    }

    public static Vehicle getVehicle() {
        Scanner kbd = new Scanner(System.in);
        System.out.print("\nDoes this employee have a vehicle? Y/N: ");
        String hasVehicle = kbd.next();

        if (hasVehicle.equalsIgnoreCase("Y")) {
            System.out.print("Enter plate number: ");
            String plate = kbd.next();
            System.out.print("Enter vehicle colour: ");
            String colour = kbd.next();
            return new Vehicle(plate, colour);
        } else {
            return null;
        }
    }

    // 💡 Refactored Long Method: calcPayroll
    public static void calcPayroll(ArrayList<Employee> employees) {
        double totalCompanyPay = 0.0;

        for (Employee emp : employees) {
            System.out.println("\n**********************");
            double pay = calculateIndividualPay(emp);
            printEmployeeDetails(emp, pay);
            printVehicleInfo(emp.getVehicle());
            totalCompanyPay += pay;
        }

        printTotalPayroll(totalCompanyPay);
    }

    private static double calculateIndividualPay(Employee emp) {
        return emp.calculatePay();
    }

    private static void printEmployeeDetails(Employee emp, double pay) {
        System.out.println("Employee Name: " + emp.getName());
        System.out.println("Has Vehicle: " + (emp.getVehicle() != null ? "Yes" : "No"));
        System.out.println("Take Home Pay: " + pay);
    }

    private static void printVehicleInfo(Vehicle vehicle) {
        if (vehicle != null) {
            System.out.println("Plate Number: " + vehicle.getPlateNumber());
            System.out.println("Colour: " + vehicle.getColour());
        }
    }

    private static void printTotalPayroll(double total) {
        System.out.println("------------");
        System.out.println("Total payroll of the company: " + total);
        System.out.println("------------");
    }
}
