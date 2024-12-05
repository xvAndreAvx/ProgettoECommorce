package ControllerREST;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;

import ejb.ProdottoService;
import entity.Prodotto;

@Path("/prodotto")
public class ProdottoController {
	
	@GET
	@Path("/index")
	@Produces({"application/json"})
	public Response findAll() {
		List<Prodotto> model = ProdottoService.getInstance().findAll();
		return Response.status(200).entity(model).build();
	}
	
	@POST
	@Path("/insert")
	@Produces({"application/json"})
	@Consumes({"application/json"})
	public Response insert(Prodotto model) {
		System.out.println(model);
		ProdottoService.getInstance().insert(model);
		return Response.status(200).entity(model).build();
	}
	
	@GET
	@Path("/delete")
	@Produces({"application/json"})
	public Response delete(Prodotto model) {
		ProdottoService.getInstance().delete(model);
		return Response.status(200).entity(null).build();
	}
	
	@POST
	@Path("/update")
	@Produces({"applicatio/json"})
	@Consumes({"application/json"})
	public Response update(Prodotto model) {
		System.out.println(model);
		ProdottoService.getInstance().update(model);
		return Response.status(200).entity(model).build();
	}

	
}
