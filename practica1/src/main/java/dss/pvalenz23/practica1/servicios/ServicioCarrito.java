package dss.pvalenz23.practica1.servicios;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import dss.pvalenz23.practica1.modelos.Producto;

@Service
@RequiredArgsConstructor
public class ServicioCarrito {

    private List<Producto> carrito;

    public List<Producto> getCarrito(){
        return carrito;
    }

    public Producto addProductoCarrito(Producto producto){
        carrito.add(producto);
        return producto;
    }

    public boolean deleteProductoCarrito(Producto producto){
        return carrito.remove(producto);
    }
}
