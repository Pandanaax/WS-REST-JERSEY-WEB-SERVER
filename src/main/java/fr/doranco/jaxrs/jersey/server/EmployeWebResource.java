package fr.doranco.jaxrs.jersey.server;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.JSONObject;

import fr.doranco.jaxrs.jersey.entity.Employe;

@Path("employes")
@Produces(MediaType.TEXT_PLAIN + ";charset=UTF-8")
public class EmployeWebResource {

	private final static String CHARSET = ";charset=UTF-8"; 

	public EmployeWebResource() {
	}

	@GET
	public String getInfo() {
		return "vous avez appelé le web service REST 'employes' pour récupérer des infos.";
	}

	@GET
	@Path("employe-{id}-XML")
	@Produces(MediaType.APPLICATION_XML + CHARSET)
	public String getEmployeXML(@PathParam("id") @DefaultValue("0") Integer id) {

		Employe employe = new Employe();
		employe.setId(id);
		employe.setPrenom("Paul");
		employe.setNom("BERT");
		
		return getEmployeAuFormatXmlString(employe);
	}

	@GET
	@Path("employe-{id}-JSON")
	@Produces(MediaType.APPLICATION_JSON + CHARSET)
	public String getEmployeJSON(@PathParam("id") Integer id) {

		Employe employe = new Employe();
		employe.setId(id);
		employe.setPrenom("Paul");
		employe.setNom("BERT");

		return getEmployeAuFormatJsonString(employe);
	}

	@GET
	@Path("employe-{id}")
	@Produces({MediaType.APPLICATION_XML + CHARSET, MediaType.APPLICATION_JSON + CHARSET})
	public Response getEmployeXMLorJSONtoResponse(@PathParam("id") Integer id) {

		Employe employe = new Employe("Paul", "BERT");
		employe.setId(id);
		return Response.status(201).entity(employe).build();
//		return Response.status(Status.NO_CONTENT).build();
	}

	@GET
	@Path("liste")
	@Produces({MediaType.APPLICATION_XML + CHARSET, MediaType.APPLICATION_JSON + CHARSET})
	public List<Employe> getEmployes() {

		List<Employe> listeEmployes = new ArrayList<Employe>();
		
		Employe employe = new Employe("Victor", "HUGO");
		employe.setId(1);
		listeEmployes.add(employe);
		
		employe = new Employe("Albert", "CAMUS");
		employe.setId(2);
		listeEmployes.add(employe);
		
//		return Response.ok().entity(listeEmployes).build();
		return listeEmployes;
	}
	
    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_XML + CHARSET)
    @Produces(MediaType.APPLICATION_XML + CHARSET)
    public Response addEmploye(Employe employe) throws URISyntaxException {
    	
    	employe.setId(100);

    	
			return Response.status(901).entity(employe).build();
			
    }
 
    /**
     * Permet de transformer un objet Employe en un format XML
     * @author Ryadh HADJ MOKHNECHE
     * @param employe
     * @return
     */
	private final String getEmployeAuFormatXmlString(Employe employe) {
	
		StringBuilder sb = new StringBuilder();
		sb.append("<employe>");
		sb.append("<date>").append(new Date()).append("</date>");
		sb.append("<id>").append(employe.getId()).append("</id>");
		sb.append("<prenom>").append(employe.getPrenom()).append("</prenom>");
		sb.append("<nom>").append(employe.getNom()).append("</nom>");
		sb.append("</employe>");
		
		return sb.toString();
	}

    /**
     * Permet de transformer un objet Employe en un format JSON
     * @author Ryadh HADJ MOKHNECHE
     * @param employe
     * @return
     */
	private final String  getEmployeAuFormatJsonString(Employe employe) {

		JSONObject obj = new JSONObject(); 
	
		obj.put("date", new Date());
		obj.put("id", employe.getId());
		obj.put("prenom", employe.getPrenom());
		obj.put("nom", employe.getNom());
	
		return obj.toString();
	}

}
