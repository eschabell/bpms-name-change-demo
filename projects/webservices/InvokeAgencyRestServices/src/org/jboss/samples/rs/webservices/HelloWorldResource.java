package org.jboss.samples.rs.webservices;

import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

//@Path("/AgencyRESTApplication")
//public class HelloWorldResource {
//
//	@GET()
//	@Produces("text/plain")
//	public String sayHello() {
//		
//	    return "Hello World!";
//	}
//}

@Path("/AgencyRESTApplication")
public class HelloWorldResource {

	@GET()
	@Produces("text/plain")
	public String requestDocuments() {
		
	    return "success";
	}
}