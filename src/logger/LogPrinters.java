/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author silanr
 */
public class LogPrinters {

    BufferedWriter bw;
    File file;

    public LogPrinters(File file) throws IOException {
        this.file = file;
        bw = new BufferedWriter(new FileWriter(this.file, true));
    }

    public void writeToFile(String ipAddress, String model, String manu) throws IOException {
        bw.write(ipAddress + "," + model + "," + manu);
        bw.newLine();
    }

    public void closeWriter() throws IOException {
        bw.close();
    }

    public void clearContents() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(this.file);
        pw.print("");
        pw.close();
    }

}
