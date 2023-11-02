package aplicacion.daos;

import java.util.ArrayList;
import java.util.List;

import aplicacion.dtos.Prestamo;
import jakarta.persistence.EntityManager;

public class PrestamoDao {
	
	private EntityManager em;

	public PrestamoDao(EntityManager em) {
		this.em = em;
	}

	public void insertPrestamo(Prestamo prestamo) {
		// Hacemos el begin
		em.getTransaction().begin();

		// Hacemos el persist
		em.persist(prestamo);

		// Hacemos el commit
		em.getTransaction().commit();
	}

	public void selectPrestamo(String query) {
		// Lista auxiliar
		List<Prestamo> listaAuxiliar = new ArrayList<Prestamo>();

		// Hacemos la query
		// Comprobamos si el select es de todos o no
		if (query.equals("SELECT p FROM Prestamo p"))
			listaAuxiliar = em.createQuery(query, Prestamo.class).getResultList();
		else
			listaAuxiliar
					.add(em.createQuery(query, Prestamo.class).setParameter("idPrestamo", 1).getSingleResult());

		
		// Mostramos por consola
		System.out.println();
		for (Prestamo aux : listaAuxiliar) {
			System.out.println(aux.toString());
		}
	}

	public void updatePrestamo(Prestamo prestamo) {
		// Hacemos el begin
		em.getTransaction().begin();

		// Hacemos el merge para conseguir el update
		em.merge(prestamo);

		// Hacemos el commit
		em.getTransaction().commit();
	}

	public void deletePrestamo(Prestamo prestamo) {
		// Hacemos el begin
		em.getTransaction().begin();

		// Hacemos el remove para hacer el delete
		em.remove(prestamo);

		// Hacemos el commit
		em.getTransaction().commit();
	}
}
