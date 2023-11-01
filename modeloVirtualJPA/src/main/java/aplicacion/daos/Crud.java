package aplicacion.daos;

import java.util.List;

import jakarta.persistence.EntityManager;

public class Crud {
	
	public void insert(EntityManager em, Object objeto) {
		// Hacemos el begin
		em.getTransaction().begin();
				
		// Hacemos el persist
		em.persist(objeto);
		
		// Hacemos el commit
		em.getTransaction().commit();
	}
	
	public List<Object> select(EntityManager em, String query, List<Object> lista) {
		
		// Hacemos la query y le asignamos la lista devuelta a la lista pasada por parametros
		lista = (List<Object>) em.createQuery(query, lista.getClass()).getResultList();
		
		// Mostramos por consola
		System.out.println();
		for (Object aux : lista) {
			System.out.println(aux.toString());
		}
		
		// Devolvemos la lista actualizada
		return lista;
	}
}
