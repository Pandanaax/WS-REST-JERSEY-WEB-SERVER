package fr.doranco.jaxrs.jersey.server;

import java.net.URISyntaxException;
import java.util.List;

import javax.xml.ws.Response;

import fr.doranco.jaxrs.jersey.entity.Employe;

public interface IEmployeWebResource {

	String getInfo();
	String getEmployeXML(Integer id);
	String getEmployeJSON(Integer id);
	Response getEmployeJSONtoResponse(Integer id);
	List<Employe> getEmployes();
	Response addEmploye(Employe employe) throws URISyntaxException;
	Response updateEmploye(Employe employe) throws URISyntaxException;
	Response removeEmploye(Integer id) throws URISyntaxException;
	String getEmployeAuFormatXmlString(Employe employe);
	String getEmployeAuFormatJsonString(Employe employe);
}
