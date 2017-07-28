/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandexecutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author silanr
 */
public class ObtainComputerModel implements Runnable {

    private String computerIp;
    private String computerModel;
    private Process process;

    public ObtainComputerModel(String computerIp) {
        this.computerIp = computerIp;
        computerModel = null;
        process = null;

    }

    public void run() {

        try {
            process = Runtime.getRuntime().exec(
                    "cmd /c %windir%\\System32\\wbem\\WMIC.exe " + "/node:" + computerIp + " computersystem get model");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            read(process);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void read(Process p) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

        reader.readLine();
        reader.readLine();

        computerModel = reader.readLine();
    }

    public String getComputerModel() {
        return computerModel;
    }
}
