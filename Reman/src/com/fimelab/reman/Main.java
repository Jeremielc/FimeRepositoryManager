package com.fimelab.reman;

import com.fimelab.reman.pojo.ToolArchiveFile;
import com.fimelab.reman.utils.FileManager;
import com.fimelab.reman.utils.FileNameParser;
import com.fimelab.reman.utils.UserManagement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*List<ToolArchiveFile> toolsList = new ArrayList<>();
        FileNameParser fnp = new FileNameParser();
        FileManager fm = new FileManager();

        for (File f : fm.listAllFiles()) {
            toolsList.add(fnp.parse(f.getName()));
        }

        for (ToolArchiveFile taf : toolsList) {
            System.out.println("Name : " + taf.getToolName());
            System.out.println("Version : " + taf.getToolVersion());
            System.out.println("State : " + taf.getToolState());
            System.out.println();
        }*/

        /*UserManagement userManager = new UserManagement();
        System.out.println(userManager.verify("NJWQ6874", "pierrickhue") ? "Pierrick is registered." : "Pierrick not registered.");
        System.out.println(userManager.verify("HRNS9487", "jeremieleclerc") ? "Jérémie is registered." : "Jérémie not registered.");
        userManager.removeUser("HRNS9487");
        userManager.removeUser("NJWQ6874");
        userManager.removeUser("TEST0000");
        userManager.registerNewUser("HRNS9487", "Jérémie", "Leclerc", "Card","jeremielc@orange.fr", "jeremieleclerc");
        userManager.registerNewUser("NJWQ6874", "Pierrick", "Hue", "Reader","lesurferdusud@hotmail.fr", "pierrickhue");
        */
    }
}
