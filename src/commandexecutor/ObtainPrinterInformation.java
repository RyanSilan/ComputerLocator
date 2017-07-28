/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandexecutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import printers.Printer;

/**
 *
 * @author silanr
 */
public class ObtainPrinterInformation implements Runnable {

    private String computerIp;
    private String printerManu;
    private String printerIp;
    private String printerModel;
    private Process process;
    ArrayList<Printer> printerArray = new ArrayList<Printer>();

    public ObtainPrinterInformation(String computerIp) {
        this.computerIp = computerIp;
    }

    public void run() {

        try {

            process = Runtime.getRuntime().exec(
                    "cmd /c %windir%\\System32\\wbem\\WMIC.exe " + "/node:" + computerIp + " printer get name, portname");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            read(process);
        } catch (IOException ex) {
            Logger.getLogger(ObtainPrinterInformation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void read(Process p) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

        for (int i = 0; i < 20; i++) {

            String text = reader.readLine();
            String[] temp = text.split("\t", -1);

            for (String tempItem : temp) {

                if (!tempItem.equals("") && !tempItem.contains("Name") && !tempItem.contains("Send To OneNote 2013 ") && !tempItem.contains("Microsoft Print to PDF") && !tempItem.contains("Microsoft XPS Document Writer")) {

                    String[] tempString = tempItem.split("(?=\\d\\d.\\d\\d\\d.\\d\\d.\\d\\d)|(?=\\d\\d.\\d\\d\\d.\\d\\d.\\d\\d\\d)|(?=WSD)");
                    Printer tempPrinter = new Printer(tempString[1], tempString[0]);
                    printerArray.add(tempPrinter);
                }

            }
        }
    }

    public ArrayList<Printer> getPrinterArray() {
        return printerArray;
    }

}
