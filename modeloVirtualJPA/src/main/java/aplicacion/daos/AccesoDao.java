package aplicacion.daos;

import java.util.List;

import aplicacion.dtos.Acceso;
import jakarta.persistence.EntityManager;

public class AccesoDao {
	
	public void insertAcceso(EntityManager em, Acceso acceso) {
		// Hacemos el begin
		em.getTransaction().begin();

		// Hacemos el persist
		em.persist(acceso);

		// Hacemos el commit
		em.getTransaction().commit();
	}

	public List<Acceso> selectUsuario(EntityManager em, List<Acceso> listaAcceso, String query) {
		// Limpiamos la lista
		listaAcceso.clear();

		// Hacemos la query
		// Comprobamos si el select es de todos o no
		if (query.equals("SELECT a FROM Acceso a"))
			listaAcceso = em.createQuery(query, Acceso.class).getResultList();
		else
			listaAcceso.add(em.createQuery(query, Acceso.class).setParameter("codigoAcceso", "Usu").getSingleResult());

		// Devolvemos la lista actualizada
		return listaAcceso;
	}

	public void updateUsuario(EntityManager em, Acceso acceso) {
		// Hacemos el begin
		em.getTransaction().begin();

		// Hacemos el merge para conseguir el update
		em.merge(acceso);

		// Hacemos el commit
		em.getTransaction().commit();
	}

	public void deleteUsuario(EntityManager em, Acceso acceso) {
		// Hacemos el begin
		em.getTransaction().begin();

		// Hacemos el remove para hacer el delete
		em.remove(acceso);

		// Hacemos el commit
		em.getTransaction().commit();
	}
}
