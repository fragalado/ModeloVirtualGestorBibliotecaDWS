package aplicacion.daos;

import java.util.ArrayList;
import java.util.List;

import aplicacion.dtos.EstadoPrestamo;
import jakarta.persistence.EntityManager;

public class EstadoPrestamoDao {
	
	private EntityManager em;

	public EstadoPrestamoDao(EntityManager em) {
		this.em = em;
	}

	public void insertEstadoPrestamo(EstadoPrestamo estadoPrestamo) {
		// Hacemos el begin
		em.getTransaction().begin();

		// Hacemos el persist
		em.persist(estadoPrestamo);

		// Hacemos el commit
		em.getTransaction().commit();
	}

	public void selectEstadoPrestamo(String query) {
		// Lista auxiliar
		List<EstadoPrestamo> listaAuxiliar = new ArrayList<EstadoPrestamo>();

		// Hacemos la query
		// Comprobamos si el select es de todos o no
		if (query.equals("SELECT ep FROM EstadoPrestamo ep"))
			listaAuxiliar = em.createQuery(query, EstadoPrestamo.class).getResultList();
		else
			listaAuxiliar
					.add(em.createQuery(query, EstadoPrestamo.class).setParameter("codigoEstadoPrestamo", "Dev").getSingleResult());

		// Mostramos por consola
		System.out.println();
		for (EstadoPrestamo aux : listaAuxiliar) {
			System.out.println(aux.toString());
		}
	}

	public void updateEstadoPrestamo(EstadoPrestamo estadoPrestamo) {
		// Hacemos el begin
		em.getTransaction().begin();

		// Hacemos el merge para conseguir el update
		em.merge(estadoPrestamo);

		// Hacemos el commit
		em.getTransaction().commit();
	}

	public void deleteEstadoPrestamo(EstadoPrestamo estadoPrestamo) {
		// Hacemos el begin
		em.getTransaction().begin();

		// Hacemos el remove para hacer el delete
		em.remove(estadoPrestamo);

		// Hacemos el commit
		em.getTransaction().commit();
	}
}
