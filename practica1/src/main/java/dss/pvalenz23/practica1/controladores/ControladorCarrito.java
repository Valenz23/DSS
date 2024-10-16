package dss.pvalenz23.practica1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dss.pvalenz23.practica1.modelos.Producto;
import dss.pvalenz23.practica1.servicios.ServicioCarrito;

@Controller
@RequestMapping("carrito")
public class ControladorCarrito {

    @Autowired
    private ServicioCarrito servicioCarrito;

    @GetMapping
    private String getCarrito(Model model){        
        model.addAttribute("productosCarrito", servicioCarrito.getCarrito());

        
        double total = servicioCarrito.getCarrito().isEmpty() ? 0.0 : servicioCarrito.getCarrito().stream()
            .mapToDouble(producto -> producto.getPrecio())
            .sum(); 
        model.addAttribute("total", total);

        return "carrito";
    }

    @PostMapping("/add")
    private String addProductoCarrito(@RequestParam("id") Long id, @RequestParam("nombre") String nombre, @RequestParam("precio") double precio){
        Producto nuevo = new Producto();
        nuevo.setId(id);
        nuevo.setNombre(nombre);
        nuevo.setPrecio(precio);
        servicioCarrito.addProductoCarrito(nuevo);        
        return "redirect:/carrito";
    }

    @PostMapping("/delete")
    private String deleteProductoCarrito(@RequestParam("id") Long id){        
        servicioCarrito.deleteProductoCarritoById(id);
        return "redirect:/carrito";
    }

    @GetMapping("/clear")
    private String clearCarrito(){
        servicioCarrito.clearCarrito();
        return "redirect:/carrito";
    }

}
