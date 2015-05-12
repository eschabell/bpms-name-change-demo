package org.jboss.samples.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService()
public class AgencyConnect {

	@WebMethod()
	public String informAgencies(String ssn) {
	    System.out.println("INFORMED ALL APPLICABLE AGENCIES FOR: " + ssn + "!");
	    return "success";
	}
	
	@WebMethod()
	public String requestSSNCard(String ssn) {
	    System.out.println("SENT APPLICATION FOR SSN CARD FOR: " + ssn);
	    return "success";
	}
	
	@WebMethod()
	public String informNameChange(String ssn) {
	    System.out.println("INFORMED SSA OF NAME CHANGE FOR: " + ssn);
	    return "success";
	}
}
