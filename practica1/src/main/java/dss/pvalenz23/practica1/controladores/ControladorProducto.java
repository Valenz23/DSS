package dss.pvalenz23.practica1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// import dss.pvalenz23.practica1.modelos.Producto;
import dss.pvalenz23.practica1.servicios.ServicioProducto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("productos")
public class ControladorProducto {

    @Autowired
    private ServicioProducto servicioProducto;

    @GetMapping
    public String getProductos(Model model) {
        model.addAttribute("productos", servicioProducto.getAllProductos());
        return "productos";
    }

    // @GetMapping("nuevo")
    // public String formularioNuevoProducto(Model model){
    //     model.addAttribute("producto", new Producto());
    //     return "formulario-producto";
    // }

    // @PostMapping("detalles")
    // public String formularioEditarProducto(@RequestParam("id") Long id, Model model){
    //     Producto producto = servicioProducto.getProductoById(id);
    //     model.addAttribute("producto", producto);
    //     return "formulario-producto";
    // }

    // @PostMapping("add")
    // public String addProducto(@RequestParam("nombre") String nombre, @RequestParam("precio") double precio) {
    //     servicioProducto.saveProducto(new Producto(nombre, precio));
    //     return "redirect:/productos";
    // }

    // @PostMapping("delete")
    // public String eliminarProducto(@RequestParam("id") Long id) {
    //     servicioProducto.deleteProducto(id);
    //     return "redirect:/productos"; 
    // }

    // @PostMapping("update")
    // public String actualizarProducto(@RequestParam("id") Long id, @RequestParam("nombre") String nombre, @RequestParam("precio") double precio) {
    //     Producto producto = servicioProducto.getProductoById(id);
    //     producto.setNombre(nombre);
    //     producto.setPrecio(precio);
    //     servicioProducto.saveProducto(producto);
    //     return "redirect:/productos"; 
    // }
    
}
