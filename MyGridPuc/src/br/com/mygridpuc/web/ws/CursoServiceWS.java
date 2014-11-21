package br.com.mygridpuc.web.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.mygridpuc.web.ws.transaction.TransactionCurso;

@Component
@Path("/curso")
public class CursoServiceWS {

	@Autowired
	TransactionCurso trCurso;
	
	@GET
	@Path("/todos")
	@Produces("application/json; charset=UTF-8")
	public Response retornaAllCursos(){
		
		String result  = trCurso.allCursos();
		return Response.status(200).entity(result).build();
		
	}
}
