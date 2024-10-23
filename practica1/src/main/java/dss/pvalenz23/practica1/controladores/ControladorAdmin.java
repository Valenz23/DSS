package dss.pvalenz23.practica1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dss.pvalenz23.practica1.modelos.Producto;
import dss.pvalenz23.practica1.servicios.ServicioProducto;

@Controller
@RequestMapping("admin")
public class ControladorAdmin {

    @Autowired
    private ServicioProducto servicioProducto;

    @GetMapping
    public String getProductos(Model model) {
        model.addAttribute("productos", servicioProducto.getAllProductos());
        return "admin";
    }

    @GetMapping("nuevo")
    public String formularioNuevoProducto(Model model){
        model.addAttribute("productoDetalles", new Producto());
        return "admin";
    }

    @PostMapping("detalles")
    public String formularioEditarProducto(@RequestParam("id") Long id, Model model){
        Producto producto = servicioProducto.getProductoById(id);
        model.addAttribute("productoDetalles", producto);
        model.addAttribute("productos", servicioProducto.getAllProductos());
        return "admin";
    }

    @PostMapping("add")
    public String addProducto(@RequestParam("nombre") String nombre, @RequestParam("precio") double precio) {
        servicioProducto.saveProducto(new Producto(nombre, precio));
        return "redirect:/admin";
    }

    @PostMapping("delete")
    public String eliminarProducto(@RequestParam("id") Long id) {
        servicioProducto.deleteProducto(id);
        return "redirect:/admin"; 
    }

    @PostMapping("update")
    public String actualizarProducto(@RequestParam("id") Long id, @RequestParam("nombre") String nombre, @RequestParam("precio") double precio) {
        Producto producto = servicioProducto.getProductoById(id);
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        servicioProducto.saveProducto(producto);
        return "redirect:/admin"; 
    }

}
