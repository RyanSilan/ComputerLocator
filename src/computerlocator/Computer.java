/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerlocator;

/**
 *
 * @author silanr
 */
public class Computer {

    private String name;
    private String ip;
    private String serialNumber;
    private String model;

    //constructor
    public Computer(String ip) {
        this.ip = ip;
    }

    //constructor
    public Computer(String ip, String name, String serialNumber, String model) {
        this.name = name;
        this.ip = ip;
        this.serialNumber = serialNumber;
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public String getIp() {
        return ip;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getModel() {
        return model;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
