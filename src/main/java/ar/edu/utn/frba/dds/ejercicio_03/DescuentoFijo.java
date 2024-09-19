package ar.edu.utn.frba.dds.ejercicio_03;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@DiscriminatorValue("DESCUENTO_FIJO")
public class DescuentoFijo extends Decorado {

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "valor")
  private Double valor;

  public Double precio() {
    return this.producto.precio() - this.valor;
  }

  public DescuentoFijo() {

  }
}
