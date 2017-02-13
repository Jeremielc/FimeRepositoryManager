package fr.ensicaen.si.jersey.resources;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import fr.ensicaen.util.MyLog;

@Path("/image")
public class ImagesResource {
	
	private static final String TAG = "ImagesResource";

	// Allows to insert contextual objects into the class, 
	// e.g. ServletContext, Request, Response, UriInfo
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	@GET
	@Produces("image/png")
	@Path("{imgname}")
	public Response getImage(@PathParam("imgname") String imgname) {
		File f = new File("d:/img1/"+imgname+".png");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			BufferedImage in = ImageIO.read(f);
			BufferedImage image = new BufferedImage(in.getWidth(), in.getHeight(), BufferedImage.TYPE_INT_ARGB);
			MyLog.d(TAG, "Image download ["+f.getAbsolutePath()+"]");
			Graphics2D g = image.createGraphics();
			g.drawImage(in, 0, 0, null);
			g.dispose();
			ImageIO.write(image, "png", baos);
			
		} catch (IOException e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		byte[] imageData = baos.toByteArray();
		return Response.ok(imageData).build();
	}

	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	public Response uploadFile(
			@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail) {

		String uploadedFileLocation = "d:/img1/" + fileDetail.getFileName();

		// save it
		writeToFile(uploadedInputStream, uploadedFileLocation);

		String output = "File uploaded to [" + uploadedFileLocation + "]";
		MyLog.d(TAG, output);

		return Response.status(200).entity(output).build();

	}

	// save uploaded file to new location
	private void writeToFile(InputStream uploadedInputStream,
			String uploadedFileLocation) {

		try {
			OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
