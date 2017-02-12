package fr.ensicaen.si.jersey.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author JRD
 * @see <a href="https://jersey.java.net/documentation/latest/representations.html#d0e6754">Jersey documentation : Representations and Responses</a>
 */
@SuppressWarnings("serial")
public class WrongArgumentsException extends WebApplicationException {
	/**
	 * Create a HTTP 400 (Bad Request) exception.
	 */
	public WrongArgumentsException() {
		super("Wrong Arguments");
	}

	/**
	 * Create a HTTP 400 (Bad Request) exception.
	 * @param message the String that is the entity of the 404 response.
	 */
	public WrongArgumentsException(String message) {
		super(Response.status(Response.Status.BAD_REQUEST).
				entity(message).type(MediaType.TEXT_PLAIN).build());
	}
}
