package dss.pvalenz23.practica1.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import dss.pvalenz23.practica1.excepciones.RecursoNoEncontrado;
import dss.pvalenz23.practica1.modelos.Producto;
import dss.pvalenz23.practica1.repositorios.RepoProducto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioProducto implements IServicioProducto {
    private final RepoProducto repoProducto;

    @Override
    public List<Producto> getAllProductos() {
        return repoProducto.findAll();
    }

    @Override
    public Producto geProductoById(Long id) {
        return repoProducto.findById(id)
            .orElseThrow(
                () -> new RecursoNoEncontrado("Producto no encontrado.")
            );
    }

    @Override
    public Producto saveProducto(Producto producto) {
        return repoProducto.save(producto);
    }

    @Override
    public void deleteProducto(Long id) {
        repoProducto.findById(id)
            .ifPresentOrElse(repoProducto::delete, 
                () -> new RecursoNoEncontrado("Producto no encontrado.")
            );
    }

}
