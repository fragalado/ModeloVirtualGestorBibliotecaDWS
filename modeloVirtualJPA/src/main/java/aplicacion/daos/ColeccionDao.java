package aplicacion.daos;

import java.util.ArrayList;
import java.util.List;

import aplicacion.dtos.Coleccion;
import jakarta.persistence.EntityManager;

public class ColeccionDao {

	private EntityManager em;

	public ColeccionDao(EntityManager em) {
		this.em = em;
	}

	public void insertColeccion(Coleccion coleccion) {
		// Hacemos el begin
		em.getTransaction().begin();

		// Hacemos el persist
		em.persist(coleccion);

		// Hacemos el commit
		em.getTransaction().commit();
	}

	public void selectColeccion(String query) {
		// Lista auxiliar
		List<Coleccion> listaAuxiliar = new ArrayList<Coleccion>();

		// Hacemos la query
		// Comprobamos si el select es de todos o no
		if (query.equals("SELECT c FROM Coleccion c"))
			listaAuxiliar = em.createQuery(query, Coleccion.class).getResultList();
		else
			listaAuxiliar
					.add(em.createQuery(query, Coleccion.class).setParameter("nombreColeccion", "Coleccion prueba").getSingleResult());

		// Mostramos por consola
		System.out.println();
		for (Coleccion aux : listaAuxiliar) {
			System.out.println(aux.toString());
		}
	}

	public void updateColeccion(Coleccion coleccion) {
		// Hacemos el begin
		em.getTransaction().begin();

		// Hacemos el merge para conseguir el update
		em.merge(coleccion);

		// Hacemos el commit
		em.getTransaction().commit();
	}

	public void deleteColeccion(Coleccion coleccion) {
		// Hacemos el begin
		em.getTransaction().begin();

		// Hacemos el remove para hacer el delete
		em.remove(coleccion);

		// Hacemos el commit
		em.getTransaction().commit();
	}
}
