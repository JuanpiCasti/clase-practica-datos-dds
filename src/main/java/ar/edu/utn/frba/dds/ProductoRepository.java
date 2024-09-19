package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.ejercicio_03.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository extends Repositorio {

  public void guardarProducto(Producto producto) {
    this.guardar(producto);
  }

  public List<Producto> buscarTodos() {
    return (List<Producto>) (List<?>) this.buscarTodos(Producto.class.getName());
  }

  public Optional<Producto> buscarPorId(Long id) {
    return this.buscarPorId(Producto.class, id).map(p -> (Producto) p);
  }

  public void actualizar(Producto producto) {
    this.actualizar(producto);
  }

  public void eliminar(Producto producto) {
    this.eliminar(producto);
  }
}
