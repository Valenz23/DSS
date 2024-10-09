package dss.pvalenz23.practica1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControladorProducto {
    @RequestMapping(value = "/producto")
        public String producto(){
            return "producto";
        }
}
