/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problem;

//Code Smell 3: Deficient Encapsulation
//Reason: Class vehicle sudah memiliki constructor, tapi memiliki setter
//Solution: Remove Setter

// Define the Vehicle
public class Vehicle {
    private String plateNumber;
    private String colour;
    
    public Vehicle (String plateNumber, String colour){
        this.plateNumber = plateNumber;
        this.colour = colour;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
    
}
