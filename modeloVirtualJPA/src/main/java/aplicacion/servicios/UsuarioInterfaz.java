package aplicacion.servicios;

import jakarta.persistence.EntityManager;

public interface UsuarioInterfaz {
	

	public void insertUsuario(EntityManager em);
	
	public void selectUsuario(EntityManager em);
	
	public void updateUsuario(EntityManager em);
	
	public void deleteUsuario(EntityManager em);
}
