package Solution;

import java.util.ArrayList;
import java.util.Scanner;

public class PayrollSystem {

    public static void main(String[] args) {
        ArrayList<Employee> arrEmp = new ArrayList<Employee>();
        byte menuOption = 0;
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

    public static FullTime readNewFullTime() {
        int id = 0;
        String name = null;
        double sal = 0.0;
        double hourAndHalf = 0.0;
        Scanner kbd = new Scanner(System.in);
        System.out.print("Enter Id: "); id = kbd.nextInt();
        System.out.print("\nEnter Name: "); name = kbd.next();
        System.out.print("\nEnter Salary: "); sal = kbd.nextDouble();
        System.out.print("\nEnter Bonus: "); hourAndHalf = kbd.nextDouble();
        
        FullTime ft1 = new FullTime(id, name, sal, hourAndHalf, getVehicle());
        return ft1;
    }

    public static PartTime readNewPartTime() {
        int id = 0;
        String name = null;
        Scanner kbd = new Scanner(System.in);
        System.out.print("Enter Id: "); id = kbd.nextInt();
        System.out.print("\nEnter Name: "); name = kbd.next();
        System.out.print("\nEnter Hourly Rate: "); double rate = kbd.nextDouble();
        System.out.print("\nEnter Number of Hours Worked: "); double hoursWorked = kbd.nextDouble();
        
        Vehicle v1 = getVehicle();
        PartTime pt1 = new PartTime(id, name, rate, hoursWorked, v1);
        return pt1;
    }

    public static byte showMenu() {
        byte menuOption = 0;
        Scanner kbd = new Scanner(System.in);
        System.out.println(""
            + "/* *************************************************/"
            + "\n/* 1. Add FullTime                               */"
            + "\n/* 2. Add PartTime                               */"
            + "\n/* 3. Calculate Payroll                          */" 
            + "\n/* 4. Exit                                       */"   
            + "\n/* *************************************************/");
        System.out.print("Input: "); menuOption = kbd.nextByte();
        return menuOption;
    }

    public static Vehicle getVehicle() {
        Scanner kbd = new Scanner(System.in);
        String hasVehicle = "N";
        System.out.println("\nDoes this employee have a vehicle? Y/N : ");
        hasVehicle = kbd.next();
        if (hasVehicle.equalsIgnoreCase("Y")) {
            System.out.println("\nEnter plate number: "); String auxPlate = kbd.next();
            System.out.println("\nEnter vehicle colour: "); String auxColour = kbd.next();
            return new Vehicle(auxPlate, auxColour);
        } else {
            return null;
        }
    }

    public static void addEmployee(ArrayList<Employee> pArrEmp, Employee pEmp) {
        pArrEmp.add(pEmp);
    }

    public static void calcPayroll(ArrayList<Employee> pArrEmp) {
        double totalCompanyPay = 0.0;
        System.out.print("\n**********************\n");
        for (Employee employee : pArrEmp) {
            double individualPay = calculateIndividualPay(employee);
            printEmployeeDetails(employee, individualPay);
            totalCompanyPay += individualPay;
        }
        printTotalPayroll(totalCompanyPay);
    }

    private static double calculateIndividualPay(Employee employee) {
        return employee.calculatePay();
    }

    private static void printEmployeeDetails(Employee employee, double individualPay) {
        String hasVehicle = employee.getVehicle() == null ? "No" : "Yes";
        System.out.println("Employee Name: " + employee.getName());
        System.out.println("Has Vehicle: " + hasVehicle);
        printVehicleInfo(employee.getVehicle());
        System.out.println("Take Home Pay: " + individualPay);
    }

    private static void printVehicleInfo(Vehicle vehicle) {
        if (vehicle != null) {
            System.out.println("Plate Number: " + vehicle.getPlateNumber());
            System.out.println("Colour: " + vehicle.getColour());
        }
    }

    private static void printTotalPayroll(double totalCompanyPay) {
        System.out.println("------------\nTotal payroll of the company: " + totalCompanyPay + "\n----");
    }
}