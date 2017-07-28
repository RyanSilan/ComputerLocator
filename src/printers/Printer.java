/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printers;

/**
 *
 * @author silanr
 */
public class Printer {

    private String printerIp;
    private String printerName;

    //for future use
    private String printerManu;
    private String printerModel;

    public Printer(String printerIp, String printerManu, String printerModel, String printerName) {
        this.printerIp = printerIp;
        this.printerManu = printerManu;
        this.printerModel = printerModel;
        this.printerName = printerName;
    }

    public Printer(String printerIp, String printerName) {
        this.printerIp = printerIp;
        this.printerName = printerName;
    }

    public void setIp(String printerIp) {
        this.printerIp = printerIp;
    }

    public void setManu(String printerManu) {
        this.printerManu = printerManu;
    }

    public void setModel(String printerModel) {
        this.printerModel = printerModel;
    }

    public void setName(String printerName) {
        this.printerName = printerName;
    }

    public String getIp() {
        return printerIp;
    }

    public String getManu() {
        return printerManu;
    }

    public String getModel() {
        return printerModel;
    }

    public String getName() {
        return printerName;
    }
}
