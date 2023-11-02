package aplicacion.daos;

import java.util.ArrayList;
import java.util.List;

import aplicacion.dtos.Genero;
import jakarta.persistence.EntityManager;

public class GeneroDao {

	private EntityManager em;

	public GeneroDao(EntityManager em) {
		this.em = em;
	}

	public void insertGenero(Genero genero) {
		// Hacemos el begin
		em.getTransaction().begin();

		// Hacemos el persist
		em.persist(genero);

		// Hacemos el commit
		em.getTransaction().commit();
	}

	public void selectGenero(String query) {
		// Lista auxiliar
		List<Genero> listaAuxiliar = new ArrayList<Genero>();

		// Hacemos la query
		// Comprobamos si el select es de todos o no
		if (query.equals("SELECT g FROM Genero g"))
			listaAuxiliar = em.createQuery(query, Genero.class).getResultList();
		else
			listaAuxiliar
					.add(em.createQuery(query, Genero.class).setParameter("nombreGenero", "Terror").getSingleResult());

		// Mostramos por consola
		System.out.println();
		for (Genero aux : listaAuxiliar) {
			System.out.println(aux.toString());
		}
	}

	public void updateGenero(Genero genero) {
		// Hacemos el begin
		em.getTransaction().begin();

		// Hacemos el merge para conseguir el update
		em.merge(genero);

		// Hacemos el commit
		em.getTransaction().commit();
	}

	public void deleteGenero(Genero genero) {
		// Hacemos el begin
		em.getTransaction().begin();

		// Hacemos el remove para hacer el delete
		em.remove(genero);

		// Hacemos el commit
		em.getTransaction().commit();
	}
}
