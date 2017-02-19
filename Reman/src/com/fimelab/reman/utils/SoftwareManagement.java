package com.fimelab.reman.utils;

import com.fimelab.reman.controller.UploadPageController;
import com.fimelab.reman.database.DbManagement;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SoftwareManagement {

    private static SoftwareManagement instance = new SoftwareManagement();

    private SoftwareManagement() {

    }

    public static SoftwareManagement getInstance() {
        return instance;
    }

    public void archive(String filename) {
        try {
            DbManagement.getInstance().update("UPDATE TOOLS SET archived = True WHERE toolPath = '" + filename + "';");
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
    }

    public void revalidate(String filename) {
        try {
            DbManagement.getInstance().update("UPDATE TOOLS SET archived = False WHERE toolPath = '" + filename + "';");
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
    }

    public void remove(String filename) {
        try {
            ResultSet res = DbManagement.getInstance().query("SELECT * FROM TOOLS WHERE toolPath = '" + filename + "';");
            String toolPath = "", reportPath = "";
            while (res.next()) {
                toolPath = UploadPageController.appPath + res.getString("toolPath");
                reportPath = UploadPageController.qualifPath + res.getString("qualifReportPath");
            }

            File f = new File(toolPath);
            f.delete();
            f = new File(reportPath);
            if (f.exists()) {
                f.delete();
            }

            DbManagement.getInstance().update("DELETE FROM TOOLS WHERE toolPath = '" + filename + "';");
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
    }
}
