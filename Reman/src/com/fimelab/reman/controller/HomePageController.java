package com.fimelab.reman.controller;

import com.fimelab.reman.database.DbManagement;
import com.fimelab.reman.database.MySqlDbManagement;
import com.fimelab.reman.pojo.ToolArchiveFile;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.TreeSet;

@Path("/home")
public class HomePageController {

    public HomePageController() {

    }

    public Set<ToolArchiveFile> listActiveArchiveFileFromDatabase() {
        Set<ToolArchiveFile> tools = new TreeSet<>();
        try {
            DbManagement dbMan = DbManagement.getInstance();
            dbMan.setDelegate(new MySqlDbManagement());
            dbMan.connection(MySqlDbManagement.dbName);

            ResultSet res = dbMan.query("SELECT * FROM TOOLS;");
            while (res.next()) {
                if (res.getString("archived").equals("0")) {
                    tools.add(
                            new ToolArchiveFile(
                                    res.getString("name"),
                                    res.getString("version"),
                                    res.getString("state"),
                                    res.getString("toolPath"),
                                    res.getString("qualifReportPath"),
                                    res.getString("publicationDate"),
                                    false,
                                    res.getString("qualified").equals("1")
                            )
                    );
                }
            }

            dbMan.disconnection();
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }

        return tools;
    }

    public Set<ToolArchiveFile> listArchivedArchiveFileFromDatabase() {
        Set<ToolArchiveFile> tools = new TreeSet<>();
        try {
            DbManagement dbMan = DbManagement.getInstance();
            dbMan.setDelegate(new MySqlDbManagement());
            dbMan.connection(MySqlDbManagement.dbName);

            ResultSet res = dbMan.query("SELECT * FROM TOOLS;");
            while (res.next()) {
                if (res.getString("archived").equals("1")) {
                    tools.add(
                            new ToolArchiveFile(
                                    res.getString("name"),
                                    res.getString("version"),
                                    res.getString("state"),
                                    res.getString("toolPath"),
                                    res.getString("qualifReportPath"),
                                    res.getString("publicationDate"),
                                    false,
                                    res.getString("qualified").equals("1")
                            )
                    );
                }
            }

            dbMan.disconnection();
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }

        return tools;
    }

    @POST
    @Path("/download")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response download(@FormParam("filename") String filename) throws Exception {
        StreamingOutput fileStream = output -> {
            try {
                java.nio.file.Path path = Paths.get(UploadPageController.appPath + filename);
                byte[] data = Files.readAllBytes(path);
                output.write(data);
                output.flush();
            } catch (Exception ex) {
                throw new WebApplicationException("File Not Found !!");
            }
        };

        return Response.ok(fileStream, MediaType.APPLICATION_OCTET_STREAM).header("content-disposition", "attachment; filename = " + filename).build();
    }

    @POST
    @Path("/download_report")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response downloadReport(@FormParam("filename") String filename) throws Exception {
        StreamingOutput fileStream = output -> {
            try {
                java.nio.file.Path path = Paths.get(UploadPageController.qualifPath + filename);
                byte[] data = Files.readAllBytes(path);
                output.write(data);
                output.flush();
            } catch (Exception ex) {
                throw new WebApplicationException("File Not Found !!");
            }
        };

        return Response.ok(fileStream, MediaType.APPLICATION_OCTET_STREAM).header("content-disposition", "attachment; filename = " + filename).build();
    }
}
