package ar.edu.utn.frba.dds.ejercicio_03;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "producto")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_producto", discriminatorType = DiscriminatorType.STRING)
public abstract class Producto extends Persistente {

  @Column(name = "nombre")
  private String nombre;

  @ManyToOne
  @JoinColumn(name = "marca_id", referencedColumnName = "id")
  @Cascade(CascadeType.PERSIST) // No lo dejaría persistir en cascada, pero facilita probar en main
  private Marca marca;

  public Producto() {

  }

  public Double precio() {

      return 0.0;
  }

  public Integer stock() {

      return 0;
  }
}
