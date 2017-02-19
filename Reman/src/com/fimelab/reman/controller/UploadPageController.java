package com.fimelab.reman.controller;

import com.fimelab.reman.database.DbManagement;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

@Path("/file")
public class UploadPageController {

    private static String baseDir = "/home/jeremie/Developpement/IdeaProjects/Reman/Reman/";
    static String appPath = baseDir + "apps/";
    static String qualifPath = baseDir + "qualif/";

    public UploadPageController() {

    }

    @POST
    @Path("/upload")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public void uploadFile(@Context HttpServletRequest request,
                           @Context HttpServletResponse response,
                           @FormDataParam("software_name") String softwareName,
                           @FormDataParam("software_version") String version,
                           @FormDataParam("qualified") String qualified,
                           @FormDataParam("status") String status,
                           @FormDataParam("reportFile") InputStream reportFileInputStream,
                           @FormDataParam("reportFile") FormDataContentDisposition reportFileDetails,
                           @FormDataParam("file") InputStream fileInputStream,
                           @FormDataParam("file") FormDataContentDisposition fileDetails) throws IOException, ServletException {

        String reportName = reportFileDetails.getFileName();
        String name = softwareName.replaceAll(" ", "");
        String extension = fileDetails.getFileName();

        StringTokenizer st = new StringTokenizer(extension, ".");
        while (st.hasMoreElements()) {
            extension = st.nextToken();
        }

        String archiveFileLocation = appPath + name + "-v" + version + "-" + status + "." + extension;
        String reportFileLocation = qualifPath + softwareName.replaceAll(" ", "") + "_" + reportName;

        // save it
        boolean softwareSave, reportSave = true;
        softwareSave = writeToFile(fileInputStream, archiveFileLocation);

        if (softwareSave && qualified.contains("yes")) {
            reportSave = writeToFile(reportFileInputStream, reportFileLocation);
        }

        if (softwareSave && reportSave) {
            String softPath = archiveFileLocation.replace(appPath, "");
            String reportPath = reportFileLocation.replace(qualifPath, "");

            try {
                DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String date = df.format(new Date());

                DbManagement.getInstance().update("INSERT INTO `TOOLS`(`name`, `version`, `state`, `archived`, `qualified`, `toolPath`, `qualifReportPath`, `publicationDate`)" +
                "VALUES ('" + name + "', '" + version + "', '" + status + "', 0, " + (qualified.contains("yes") ? 1 : 0) + ", '" + softPath + "', '" + reportPath + "', '" + date + "');");
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }

            response.sendRedirect("/upload_registered.jsp");
        } else {
            File temp = new File(archiveFileLocation);
            if (temp.exists()) {
                temp.delete();
            }

            temp = new File(reportFileLocation);
            if (temp.exists()) {
                temp.delete();
            }

            response.sendError(500);
        }
    }

    // save uploaded file to new location
    private boolean writeToFile(InputStream uploadedInputStream, String uploadedFileLocation) {
        try {
            /*int read = 0;
            byte[] bytes = new byte[1024];

            OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            out.flush();
            out.close();*/
            Files.copy(uploadedInputStream, FileSystems.getDefault().getPath(uploadedFileLocation));
            return true;
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
            return false;
        }
    }
}
