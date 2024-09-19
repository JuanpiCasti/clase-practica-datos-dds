package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.ejercicio_03.ProductoSimple;

public class EjemploMainPersistencia {
    
    public static void main(String[] args) {

        ProductoSimple producto = new ProductoSimple();
        producto.setNombre("ejemplo");

        Repositorio repositorio = new Repositorio();

        repositorio.guardar(producto);
    }
}
