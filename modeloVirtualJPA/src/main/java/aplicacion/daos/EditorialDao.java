package aplicacion.daos;

import java.util.ArrayList;
import java.util.List;

import aplicacion.dtos.Editorial;
import jakarta.persistence.EntityManager;

public class EditorialDao {

	private EntityManager em;

	public EditorialDao(EntityManager em) {
		this.em = em;
	}

	public void insertEditorial(Editorial editorial) {
		// Hacemos el begin
		em.getTransaction().begin();

		// Hacemos el persist
		em.persist(editorial);

		// Hacemos el commit
		em.getTransaction().commit();
	}

	public void selectEditorial(String query) {
		// Lista auxiliar
		List<Editorial> listaAuxiliar = new ArrayList<Editorial>();

		// Hacemos la query
		// Comprobamos si el select es de todos o no
		if (query.equals("SELECT e FROM Editorial e"))
			listaAuxiliar = em.createQuery(query, Editorial.class).getResultList();
		else
			listaAuxiliar
					.add(em.createQuery(query, Editorial.class).setParameter("nombreEditorial", "Bilbo").getSingleResult());

		// Mostramos por consola
		System.out.println();
		for (Editorial aux : listaAuxiliar) {
			System.out.println(aux.toString());
		}
	}

	public void updateEditorial(Editorial editorial) {
		// Hacemos el begin
		em.getTransaction().begin();

		// Hacemos el merge para conseguir el update
		em.merge(editorial);

		// Hacemos el commit
		em.getTransaction().commit();
	}

	public void deleteEditorial(Editorial editorial) {
		// Hacemos el begin
		em.getTransaction().begin();

		// Hacemos el remove para hacer el delete
		em.remove(editorial);

		// Hacemos el commit
		em.getTransaction().commit();
	}
}
