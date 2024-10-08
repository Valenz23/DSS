package dss.pvalenz23.practica1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dss.pvalenz23.practica1.modelos.Producto;
import dss.pvalenz23.practica1.servicios.ServicioProducto;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/productos")
public class ControladorProducto {

    @Autowired
    private ServicioProducto servicioProducto;

    @GetMapping
    public String getProductos(Model model) {
        model.addAttribute("producto", servicioProducto.getAllProductos());
        return "productos";
    }

    @PostMapping("/add")
    public String addProducto(@RequestParam String name, @RequestParam double price) {
        Producto nuevo = new Producto(name, price);
        servicioProducto.saveProducto(nuevo);
        return "productos";
    }
    
    

    // @RequestMapping(value = "/producto")
    //     public String producto(){
    //         return "producto";
    //     }
}
