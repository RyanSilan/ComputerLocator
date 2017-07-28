/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerlocator;

import commandexecutor.*;

/**
 *
 * @author silanr
 */
public class ComputerLocator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //MainScreenUI ui = new MainScreenUI(); 
        ObtainSerialNumber obtainSN = new ObtainSerialNumber("10.193.35.78"); 
        obtainSN.run();
        System.out.println("Serial Number: " + obtainSN.getSerialNumber());
        
        ObtainComputerName obtainComputerName = new ObtainComputerName("10.193.35.78"); 
        obtainComputerName.run(); 
        System.out.println("Computer Name: " + obtainComputerName.getComputerName()); 
        
        ObtainComputerModel obtainComputerModel = new ObtainComputerModel("10.193.35.78"); 
        obtainComputerModel.run(); 
        System.out.println("Computer Name: " + obtainComputerModel.getComputerModel()); 
    }
    
}
