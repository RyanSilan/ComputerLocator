/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import computerlocator.Computer;
import java.util.ArrayList;

/**
 *
 * @author silanr
 */
public class ReadFile {

    Scanner scanner;
    String line = "";
    ArrayList<Computer> computerList = new ArrayList<Computer>();
    String[] text;

    public ReadFile(File file) {
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scanner.hasNextLine()) {
            String temp = scanner.nextLine();
            text = temp.split(",");

            //If text.length==4, that means that all data was generated. 
            if (text.length == 4) {
                Computer computer = new Computer(text[0], text[1], text[2], text[3]);
                computerList.add(computer);
            }

            //If text.length == 1, we're reading the list of computer IP addresses. 
            if (text.length == 1) {
                Computer computer = new Computer(text[0]);
                computerList.add(computer);
            }

        }
    }

    public ArrayList<Computer> getComputerInformation() {
        return computerList;
    }

}
