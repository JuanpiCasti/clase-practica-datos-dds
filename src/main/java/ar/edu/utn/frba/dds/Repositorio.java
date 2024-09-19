package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.ejercicio_03.Producto;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

public class Repositorio implements WithSimplePersistenceUnit {

    public void guardar(Object p) {
        try{
            beginTransaction();
            entityManager().persist(p);
            commitTransaction();
        } catch (Exception e) {
            rollbackTransaction();
            throw e;
        }
    }

    public List<Object> buscarTodos(String nombreDeClase){
        return entityManager().createQuery("from " + nombreDeClase).getResultList();
    }

    public Optional<Object> buscarPorId(Class<?> clase, Long id){
        return Optional.ofNullable(entityManager().find(clase, id));
    }

    public void actualizar(Object o){
        EntityTransaction tx = entityManager().getTransaction();
        if(!tx.isActive())
            tx.begin();
        entityManager().merge(o);
        tx.commit();
    }

    public void eliminar(Object o){
        EntityTransaction tx = entityManager().getTransaction();
        if(!tx.isActive())
            tx.begin();
        entityManager().remove(o);
        tx.commit();
    }
}
