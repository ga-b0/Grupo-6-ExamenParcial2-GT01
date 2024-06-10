/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libcode.webapp.controladores;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import libcode.webapp.entidades.Inscripciones;
import libcode.webapp.negocio.DataService;
/**
 *
 * @author Gabo
 */
@Named
@RequestScoped
public class InscripcionesController {
    private List<Inscripciones> inscripcionesList = new ArrayList<>();
    private Inscripciones inscripcion = new Inscripciones();
    
    @EJB
    DataService servicio;
    
    @PostConstruct
    public void cargarInscripciones() {
        inscripcionesList = servicio.getInscripciones();
    }
    
    public void guardarInscripcion() {
        System.out.println("Inscripción a guardar: " + inscripcion);
        if(inscripcion.getId() != null) {
            servicio.editInscripcion(inscripcion);
        } else {
            servicio.saveInscripcion(inscripcion);
        }
        inscripcion = new Inscripciones();
        cargarInscripciones();
    }
    
    public void llenarFormEditar(Inscripciones inscripcion)
    {
        this.inscripcion.setId(inscripcion.getId());
        this.inscripcion.setAlumno(inscripcion.getAlumno());
        this.inscripcion.setMateria(inscripcion.getMateria());
        this.inscripcion.setCiclo(inscripcion.getCiclo());
        this.inscripcion.setAnio(inscripcion.getAnio());
        this.inscripcion.setFechaInscripcion(inscripcion.getFechaInscripcion());
    }
    
    public void eliminarInscripcion(Inscripciones inscripcion)
    {
        servicio.deleteInscripcion(inscripcion);
        cargarInscripciones();
    }

    public List<Inscripciones> getInscripcionesList() {
        return inscripcionesList;
    }

    public void setInscripcionesList(List<Inscripciones> inscripcionesList) {
        this.inscripcionesList = inscripcionesList;
    }

    public Inscripciones getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripciones inscripcion) {
        this.inscripcion = inscripcion;
    }
}
