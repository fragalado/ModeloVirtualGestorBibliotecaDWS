package aplicacion.daos;

import java.util.ArrayList;
import java.util.List;

import aplicacion.dtos.Libro;
import jakarta.persistence.EntityManager;

public class LibroDao {

	private EntityManager em;

	public LibroDao(EntityManager em) {
		this.em = em;
	}

	public void insertLibro(Libro libro) {
		// Hacemos el begin
		em.getTransaction().begin();

		// Hacemos el persist
		em.persist(libro);

		// Hacemos el commit
		em.getTransaction().commit();
	}

	public void selectLibro(String query) {
		// Lista auxiliar
		List<Libro> listaAuxiliar = new ArrayList<Libro>();

		// Hacemos la query
		// Comprobamos si el select es de todos o no
		if (query.equals("SELECT l FROM Libro l"))
			listaAuxiliar = em.createQuery(query, Libro.class).getResultList();
		else
			listaAuxiliar
					.add(em.createQuery(query, Libro.class).setParameter("isbnLibro", "123").getSingleResult());

		// Mostramos por consola
		System.out.println();
		for (Libro aux : listaAuxiliar) {
			System.out.println(aux.toString());
		}
	}

	public void updateLibro(Libro libro) {
		// Hacemos el begin
		em.getTransaction().begin();

		// Hacemos el merge para conseguir el update
		em.merge(libro);

		// Hacemos el commit
		em.getTransaction().commit();
	}

	public void deleteLibro(Libro libro) {
		// Hacemos el begin
		em.getTransaction().begin();

		// Hacemos el remove para hacer el delete
		em.remove(libro);

		// Hacemos el commit
		em.getTransaction().commit();
	}
}
