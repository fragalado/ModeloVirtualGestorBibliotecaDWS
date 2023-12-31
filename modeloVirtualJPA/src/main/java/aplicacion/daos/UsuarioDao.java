package aplicacion.daos;

import java.util.ArrayList;
import java.util.List;

import aplicacion.dtos.Acceso;
import aplicacion.dtos.Usuario;
import jakarta.persistence.EntityManager;

public class UsuarioDao {
	
	private EntityManager em;

	public UsuarioDao(EntityManager em) {
		this.em = em;
	}

	public void insertUsuario(Usuario usuario) {
		// Hacemos el begin
		em.getTransaction().begin();
		
		// Hacemos el persist
		em.persist(usuario);
		
		// Hacemos el commit
		em.getTransaction().commit();
	}

	public void selectUsuario(String query) {
		// Lista auxiliar
		List<Usuario> listaAuxiliar = new ArrayList<Usuario>();

		// Hacemos la query
		// Comprobamos si el select es de todos o no
		if (query.equals("SELECT u FROM Usuario u"))
			listaAuxiliar = em.createQuery(query, Usuario.class).getResultList();
		else
			listaAuxiliar.add(em.createQuery(query, Usuario.class).setParameter("dni", "123").getSingleResult());

		// Mostramos por consola
		System.out.println();
		for (Usuario aux : listaAuxiliar) {
			System.out.println(aux.toString());
		}
	}

	public void updateUsuario(Usuario usuario) {
		// Hacemos el begin
		em.getTransaction().begin();
				
		// Hacemos el merge para conseguir el update
		em.merge(usuario);
				
		// Hacemos el commit
		em.getTransaction().commit();
	}

	public void deleteUsuario(Usuario usuario) {
		// Hacemos el begin
		em.getTransaction().begin();
				
		// Hacemos el remove para hacer el delete
		em.remove(usuario);
				
		// Hacemos el commit
		em.getTransaction().commit();
	}

}
