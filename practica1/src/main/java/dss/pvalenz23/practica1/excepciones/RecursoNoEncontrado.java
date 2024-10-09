package dss.pvalenz23.practica1.excepciones;

public class RecursoNoEncontrado extends RuntimeException {
    public RecursoNoEncontrado(String mensaje){
        super(mensaje);
    }
}
