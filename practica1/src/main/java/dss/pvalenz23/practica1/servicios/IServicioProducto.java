package dss.pvalenz23.practica1.servicios;

import java.util.List;

import dss.pvalenz23.practica1.modelos.Producto;

public interface IServicioProducto {

    List<Producto> getAllProductos();
    Producto geProductoById(Long id);
    Producto saveProducto(Producto producto);
    void deleteProducto(Long id);

}
