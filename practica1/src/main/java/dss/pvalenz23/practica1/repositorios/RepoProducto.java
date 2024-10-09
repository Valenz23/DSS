package dss.pvalenz23.practica1.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import dss.pvalenz23.practica1.modelos.Producto;

public interface RepoProducto extends JpaRepository<Producto, Long> {

}
