package aplicacion.daos;

import java.util.List;

import aplicacion.dtos.Usuario;
import jakarta.persistence.EntityManager;

public class UsuarioDao {

	public void insertUsuario(EntityManager em, Usuario usuario) {
		// Hacemos el begin
		em.getTransaction().begin();
		
		// Hacemos el persist
		em.persist(usuario);
		
		// Hacemos el commit
		em.getTransaction().commit();
	}

	public List<Usuario> selectUsuario(EntityManager em, List<Usuario> listaUsuarios, String query) {
		// Limpiamos la lista
		listaUsuarios.clear();
		
		// Hacemos la query
		// Comprobamos si el select es de todos o no
		if(query.equals("SELECT u FROM Usuario u"))
			listaUsuarios = em.createQuery(query, Usuario.class).getResultList();
		else
			listaUsuarios.add(em.createQuery(query, Usuario.class).setParameter("dni", "123").getSingleResult());
		
		// Devolvemos la lista actualizada
		return listaUsuarios;
	}

	public void updateUsuario(EntityManager em, Usuario usuario) {
		// Hacemos el begin
		em.getTransaction().begin();
				
		// Hacemos el merge para conseguir el update
		em.merge(usuario);
				
		// Hacemos el commit
		em.getTransaction().commit();
	}

	public void deleteUsuario(EntityManager em, Usuario usuario) {
		// Hacemos el begin
		em.getTransaction().begin();
				
		// Hacemos el remove para hacer el delete
		em.remove(usuario);
				
		// Hacemos el commit
		em.getTransaction().commit();
	}

}
