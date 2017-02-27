package com.fimelab.reman.controller;

import com.fimelab.reman.database.DbManagement;
import com.fimelab.reman.pojo.ToolArchiveFile;
import com.fimelab.reman.utils.FileNameParser;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.TreeSet;

@Path("/version")
public class VersionWsController {

    public VersionWsController() {

    }

    @POST
    @Path("/check")
    public Response checkVersion(@FormParam("toolInfo") String toolInfo) {
        System.out.println(toolInfo);
        ToolArchiveFile taf = FileNameParser.getInstance().parse(toolInfo);

        if (taf.getToolName() != null && taf.getToolVersion() != null && taf.getToolStatus() != null) {
            try {
                Set<String> toolVersions = new TreeSet<>();
                ResultSet res = DbManagement.getInstance().query("SELECT version FROM TOOLS WHERE name = '" + taf.getToolName() + "';");
                while (res.next()) {
                    toolVersions.add(res.getString("version"));
                }

                boolean isTheMostRecentVersion = true;
                for (String s : toolVersions) {
                    if (s.compareTo(taf.getToolVersion()) < 0) {
                        isTheMostRecentVersion = false;
                        break;
                    }
                }

                if (!isTheMostRecentVersion) {
                    return Response.status(250).build();
                } else {
                    return Response.status(251).build();
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
                return Response.status(500).build();
            }
        } else {
            return Response.status(252).build();
        }
    }
}
