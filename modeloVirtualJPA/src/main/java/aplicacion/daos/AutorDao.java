package aplicacion.daos;

import java.util.ArrayList;
import java.util.List;

import aplicacion.dtos.Autor;
import jakarta.persistence.EntityManager;

public class AutorDao {

	private EntityManager em;

	public AutorDao(EntityManager em) {
		this.em = em;
	}

	public void insertAutor(Autor autor) {
		// Hacemos el begin
		em.getTransaction().begin();

		// Hacemos el persist
		em.persist(autor);

		// Hacemos el commit
		em.getTransaction().commit();
	}

	public void selectAutor(String query) {
		// Lista auxiliar
		List<Autor> listaAuxiliar = new ArrayList<Autor>();

		// Hacemos la query
		// Comprobamos si el select es de todos o no
		if (query.equals("SELECT au FROM Autor au"))
			listaAuxiliar = em.createQuery(query, Autor.class).getResultList();
		else
			listaAuxiliar
					.add(em.createQuery(query, Autor.class).setParameter("nombreAutor", "Fran").getSingleResult());

		// Mostramos por consola
		System.out.println();
		for (Autor aux : listaAuxiliar) {
			System.out.println(aux.toString());
		}
	}

	public void updateAutor(Autor autor) {
		// Hacemos el begin
		em.getTransaction().begin();

		// Hacemos el merge para conseguir el update
		em.merge(autor);

		// Hacemos el commit
		em.getTransaction().commit();
	}

	public void deleteAutor(Autor autor) {
		// Hacemos el begin
		em.getTransaction().begin();

		// Hacemos el remove para hacer el delete
		em.remove(autor);

		// Hacemos el commit
		em.getTransaction().commit();
	}
}
