package aplicacion.daos;

import java.util.ArrayList;
import java.util.List;

import aplicacion.dtos.Acceso;
import jakarta.persistence.EntityManager;

public class AccesoDao {
	
	private EntityManager em;
	
	public AccesoDao(EntityManager em) {
		this.em = em;
	}
	
	public void insertAcceso(Acceso acceso) {
		// Hacemos el begin
		em.getTransaction().begin();

		// Hacemos el persist
		em.persist(acceso);

		// Hacemos el commit
		em.getTransaction().commit();
	}

	public void selectAcceso(String query) {
		// Lista auxiliar
		List<Acceso> listaAuxiliar = new ArrayList<Acceso>();

		// Hacemos la query
		// Comprobamos si el select es de todos o no
		if (query.equals("SELECT a FROM Acceso a"))
			listaAuxiliar = em.createQuery(query, Acceso.class).getResultList();
		else
			listaAuxiliar.add(em.createQuery(query, Acceso.class).setParameter("codigoAcceso", "Usu").getSingleResult());

		// Mostramos por consola
		System.out.println();
		for (Acceso aux : listaAuxiliar) {
			System.out.println(aux.toString());
		}
	}

	public void updateAcceso(Acceso acceso) {
		// Hacemos el begin
		em.getTransaction().begin();

		// Hacemos el merge para conseguir el update
		em.merge(acceso);

		// Hacemos el commit
		em.getTransaction().commit();
	}

	public void deleteAcceso(Acceso acceso) {
		// Hacemos el begin
		em.getTransaction().begin();

		// Hacemos el remove para hacer el delete
		em.remove(acceso);

		// Hacemos el commit
		em.getTransaction().commit();
	}
}
