/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Solution;

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

    public String getColour() {
        return colour;
    }    
}
