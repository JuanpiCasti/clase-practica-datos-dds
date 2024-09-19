package ar.edu.utn.frba.dds.ejercicio_03;

import ar.edu.utn.frba.dds.ProductoRepository;
import ar.edu.utn.frba.dds.Repositorio;

import java.util.Optional;

public class AMainEjercicio3 {
  // corre el metodo main para persistir y ver como queda en tu DB!

  public static void main(String[] args) {

    ProductoRepository productoRepository = new ProductoRepository();

    //* -------------- Marcas --------------
    Marca lays = new Marca();
    lays.setNombre("Lays");

    Marca cocaCola = new Marca();
    cocaCola.setNombre("Coca Cola");

    Marca paty = new Marca();
    paty.setNombre("Paty");

    Marca marcaNachos = new Marca();
    marcaNachos.setNombre("Combo Nachos!");

    //* -------------- Producto Simple --------------
    ProductoSimple papas = new ProductoSimple();
    papas.setNombre("Papas");
    papas.setMarca(lays);
    papas.setPrecio(100.0);
    papas.setStock(10);


    ProductoSimple coca = new ProductoSimple();
    coca.setNombre("Coca");
    coca.setMarca(cocaCola);
    coca.setStock(20);
    coca.setPrecio(150.0);


    ProductoSimple hamburguesa = new ProductoSimple();
    hamburguesa.setNombre("Hamburguesa");
    hamburguesa.setMarca(paty);
    hamburguesa.setStock(30);
    hamburguesa.setPrecio(200.0);

    Combo comboHamburguesaConPapasYBebida = new Combo();
    comboHamburguesaConPapasYBebida.setNombre("Combo Hamburguesa con Papas y Bebida");
    comboHamburguesaConPapasYBebida.setMarca(marcaNachos);
    comboHamburguesaConPapasYBebida.agregarProducto(hamburguesa);
    comboHamburguesaConPapasYBebida.agregarProducto(papas);
    comboHamburguesaConPapasYBebida.agregarProducto(coca);


    DescuentoFijo descuentoFijo = new DescuentoFijo();
    descuentoFijo.setNombre("DescuentoFijo");
    descuentoFijo.setValor(100.0);


    Packaging packagingDeHamburguesa = new Packaging();

    packagingDeHamburguesa.setPrecio(50.0);
    packagingDeHamburguesa.setProducto(hamburguesa);

    Repositorio repositorio = new Repositorio();
    repositorio.guardar(lays);
    productoRepository.guardarProducto(hamburguesa);
    productoRepository.guardarProducto(comboHamburguesaConPapasYBebida);

    Packaging packagingDeCombo = new Packaging();
    packagingDeCombo.setMarca(marcaNachos);
    packagingDeCombo.setPrecio(50.0);
    packagingDeCombo.setProducto(comboHamburguesaConPapasYBebida);

    productoRepository.guardarProducto(packagingDeCombo);

    DescuentoFijo descuentoFijo1 = new DescuentoFijo();
    descuentoFijo1.setNombre("DescuentoFijo1");
    descuentoFijo1.setValor(100.0);
    descuentoFijo1.setProducto(comboHamburguesaConPapasYBebida);
    descuentoFijo1.setMarca(marcaNachos);
    productoRepository.guardarProducto(descuentoFijo1);



    System.out.println(productoRepository.buscarTodos());

    Optional<Producto> pack = productoRepository.buscarPorId(packagingDeCombo.getId());

    pack.ifPresent(p -> System.out.println(p.precio()));

    Optional<Producto> desc = productoRepository.buscarPorId(descuentoFijo1.getId());

    desc.ifPresent(p -> System.out.println(p.precio()));
  }
}
