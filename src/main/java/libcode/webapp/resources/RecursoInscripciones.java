/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libcode.webapp.resources;
import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import libcode.webapp.entidades.Inscripciones;
import libcode.webapp.negocio.DataService;
/**
 *
 * @author Gabo
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/inscripciones")
public class RecursoInscripciones {
    
    @EJB DataService servicio;
    
    @GET
    public Response getInscripciones()
    {
        List<Inscripciones> inscripciones = servicio.getInscripciones();
        return Response.ok(inscripciones).build();
    }
    
    @POST
    public Response saveInscripcion(Inscripciones inscripcion)
    {
        servicio.saveInscripcion(inscripcion);
        return Response.ok("La inscripcion fue creada exitosamente").build();
    }
    @PUT
    public Response editInscripcion(Inscripciones inscripcion)
    {
        servicio.editInscripcion(inscripcion);
        return Response.ok("La inscripcion fue editada exitosamente").build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteInscripcion(@PathParam("id") Integer id)
    {
        servicio.deleteInscripcion(new Inscripciones(id));
        return Response.ok("La inscripcion fue eliminada exitosamente").build();
    }
}
