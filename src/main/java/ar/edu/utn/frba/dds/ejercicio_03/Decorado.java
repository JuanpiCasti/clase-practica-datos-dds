package ar.edu.utn.frba.dds.ejercicio_03;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("DECORADO")
public abstract class Decorado extends Producto {

  @ManyToOne
  @JoinColumn(name = "producto_decorado_id", referencedColumnName = "id")
  // Acá no se puede hacer no-nulleable porque sino no se pueden persistir productos no decorados.
  // Es justificación suficiente para hacer un joined table?
  // No quisiera que hayan decorados que no tengan un producto.
  protected Producto producto;

  public Double precio() {
    return this.producto.precio();
  }
}
